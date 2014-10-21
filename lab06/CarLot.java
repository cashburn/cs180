class CarLot implements Inventory<Car> {
    private Car[] array;
    private int numVehicles;
    private int capacity;
    public CarLot(int capacity) {
        if (capacity < 0)
            return;
        array = new Car[capacity];
        this.capacity = capacity;
        numVehicles = 0;
    }
    
    public int capacity() {
        return capacity;
    }
    
    public int numVehicles() {
        return numVehicles;
    }
    
    public boolean add(Car vehicle) {
        if (numVehicles >= capacity)
            return false;
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null) {
                array[i] = vehicle;
                numVehicles++;
                return true;
            }
            else
                continue;
        }
        return false;
        
    }
    
    public Car get(int location) {
        if (location >= capacity)
            return null;
        if (location < 0)
            return null;
        if (array[location] == null)
            return null;
        return array[location];
    }
    
    public Car remove(int location) {
        if ((get(location) == null) | (location > capacity) | (location < 0))
            return null;
        else {
            Car c = array[location];
            array[location] = null;
            numVehicles--;
            return c;
        }
    }
    
    public boolean[] searchByMake(String make) {
        boolean[] search = new boolean[capacity];
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null)
                search[i] = false;
            else if (array[i].getMake().equals(make))
                search[i] = true;
            else 
                search[i] = false;
        }
        return search;
    }
}