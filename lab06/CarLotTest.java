import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class CarLotTest extends TestCase {
    CarLot carLot = new CarLot(4);
    /**
     * A test method.
     * (Replace "X" with a name describing the test.  You may write as
     * many "testSomething" methods in this class as you wish, and each
     * one will be called when running JUnit over this class.)
     */
    
    
    public void testCarLotAdd() {
        assertTrue(carLot.add(new Car("green", "toyota")));
        assertTrue(carLot.add(new Car("red", "buick")));
        assertTrue(carLot.add(new Car("blue", "infiniti")));
        assertTrue(carLot.add(new Car("yellow", "gm")));
        assertFalse(carLot.add(new Car("black", "ford")));
    }
    
    public void testCarLotRemove() {
        carLot.add(new Car("green", "toyota"));
        carLot.add(new Car("red", "buick"));
        carLot.add(new Car("blue", "infiniti"));
        carLot.add(new Car("yellow", "gm"));
        assertNotNull(carLot.remove(0));
        assertNull(carLot.remove(0));
        assertNull(carLot.remove(6));
        assertNull(carLot.remove(-1));
    }
    
    public void testCarLotGet() {
        carLot.add(new Car("green", "toyota"));
        carLot.add(new Car("red", "buick"));
        carLot.add(new Car("blue", "infiniti"));
        carLot.add(new Car("yellow", "gm"));
        assertNotNull(carLot.get(0));
        assertNull(carLot.get(-1));
        assertNull(carLot.get(6));
    }
    
    public void testCarLotCapacity() {
        assertEquals(4, carLot.capacity());
    }
    
    public void testCarLotNumVehicles() {
        carLot.add(new Car("green", "toyota"));
        carLot.add(new Car("red", "buick"));
        carLot.add(new Car("blue", "infiniti"));
        carLot.add(new Car("yellow", "gm"));
        assertEquals(4, carLot.numVehicles());
    }
    
    public void testCarLotSearch() {
        carLot.add(new Car("green", "toyota"));
        carLot.add(new Car("red", "buick"));
        carLot.add(new Car("blue", "infiniti"));
        carLot.add(new Car("yellow", "gm"));
        assertTrue(carLot.searchByMake("buick")[1]);
        assertFalse(carLot.searchByMake("buick")[2]);
    }
    
    public void testCar() {
        Car c = new Car("red", "toyota");
        assertEquals("red", c.getColor());
        assertEquals("toyota", c.getMake());
    }
}
