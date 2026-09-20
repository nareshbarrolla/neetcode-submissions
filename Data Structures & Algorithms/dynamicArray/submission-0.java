class DynamicArray {

    int[] inputArray;
    int inputArraySize = 0;

    public DynamicArray(int capacity) {
        if(capacity > 0){
            inputArray = new int[capacity];                
        }
    }

    public int get(int i) {
        if(i >= 0 && inputArraySize > i){
            return inputArray[i];
        }
        return 0;
    }

    public void set(int i, int n) {
        if(i >= 0 && inputArraySize > i){
            inputArray[i] = n;
        }
    }

    public void pushback(int n) {   
        if (inputArraySize == inputArray.length) {
            resize();
        }
        inputArray[inputArraySize] = n;
        inputArraySize++;
    }

    public int popback() {
        inputArraySize--;
        return inputArray[inputArraySize];
    }

    private void resize() {
        int[] newArray = new int[inputArray.length * 2];
        for (int i = 0; i < inputArraySize; i++) {
            newArray[i] = inputArray[i];
        }
        inputArray = newArray;
    }

    public int getSize() {
        return inputArraySize;        
    }

    public int getCapacity() {
        return inputArray.length; 
    }
}