class FirstUnique {

    private class MapElement<T> {
        MapElement<T> previous;
        MapElement<T> next;
        T value;

        MapElement(T value) {
            this.value = value;
        }
    }

    private class DoublyLinkedList<T> {
        MapElement<T> head;
        MapElement<T> tail;

        MapElement<T> addToTail(T element) {
            MapElement<T> newElement = new MapElement<>(element);

            if (this.head == null) {
                this.head = newElement;
                this.tail = newElement;
            } else {
                newElement.previous = this.tail;
                this.tail.next = newElement;
                this.tail = newElement;
            }

            return newElement;
        }

        T getHead() {
            if (this.head == null) {
                return null;
            }
            return this.head.value;
        }

        void remove(MapElement<T> element) {
            if (element.previous != null) {
                element.previous.next = element.next;
            }
            if (element.next != null) {
                element.next.previous = element.previous;
            }
            if (this.head == element) {
                this.head = this.head.next;
            }
            if (this.tail == element) {
                this.tail = this.tail.previous;
            }
        }
    }

    private Map<Integer, MapElement<Integer>> elements;
    private DoublyLinkedList<Integer> queue;

    public FirstUnique(int[] nums) {
        this.elements = new HashMap<>(nums.length);
        this.queue = new DoublyLinkedList<>();
        this.populateElements(nums);
    }

    private void populateElements(int[] nums) {
        for (int element: nums) {
            this.add(element);
        }
    }
    
    public int showFirstUnique() {
        Integer queueHead = this.queue.getHead();
        return queueHead == null ? - 1: queueHead;
    }
    
    public void add(int value) {
        if (this.elements.containsKey(value)) {
            MapElement<Integer> existingValue = this.elements.get(value);
            if (existingValue != null) {
                this.queue.remove(existingValue);
                this.elements.put(value, null);
            }       // Else, if key exists but value is null, the value has already been processed (i.e., this is at least the 3rd occurrence of such value)
        } else {
            MapElement<Integer> newElement = this.queue.addToTail(value);
            this.elements.put(value, newElement);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */