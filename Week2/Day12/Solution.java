class Solution {
    
    public int lastStoneWeight(int[] stones) {
        int[] weightsBuckets = getWeightBuckets(stones);
        int max1WeightIndex = weightsBuckets.length-1;
        
        while (max1WeightIndex >= 0) {
            if (weightsBuckets[max1WeightIndex] == 0) {
                max1WeightIndex--;
            } else {
                weightsBuckets[max1WeightIndex] %= 2;
                if (weightsBuckets[max1WeightIndex] == 0) {
                    max1WeightIndex--;
                    continue;
                }
                
                int max1 = max1WeightIndex+1;
                weightsBuckets[max1WeightIndex]--;

                int max2WeightIndex = max1WeightIndex-1;
                while (max2WeightIndex >= 0) {
                    if (weightsBuckets[max2WeightIndex] == 0) {
                        max2WeightIndex--;
                    } else {
                        int max2 = max2WeightIndex+1;
                        weightsBuckets[max2WeightIndex]--;
                        if (max1 > max2) {
                            int smashedStoneWeightIndex = max1-max2-1;
                            weightsBuckets[smashedStoneWeightIndex]++;
                            max1WeightIndex = Math.max(smashedStoneWeightIndex, max2WeightIndex);
                        }
                        break;
                    }
                }
                if (max2WeightIndex < 0) {
                    return max1;
                }
            }
        }
        return 0;
    }
    
    private int[] getWeightBuckets(int[] weights) {
        int maxWeight = getMaxWeight(weights);
        int[] weightsBuckets = new int[maxWeight];

        for (int stoneWeight: weights) {
            weightsBuckets[stoneWeight-1] += 1;
        }
        
        return weightsBuckets;
    }
    
    private int getMaxWeight(int[] weights) {
        int maxWeight = 0;

        for (int stoneWeight: weights) {
            maxWeight = Math.max(maxWeight, stoneWeight);
        }
        return maxWeight;
    }
}