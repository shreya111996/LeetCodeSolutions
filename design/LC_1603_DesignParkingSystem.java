package design;

public class LC_1603_DesignParkingSystem {

    /*
     * TC: O(1) - for addCar() method
     * SC: O(1) - for storing the slots
     */
     
    static class ParkingSystem {

        int[] slots;

        public ParkingSystem(int big, int medium, int small) {
            slots = new int[3];
            slots[0] = big;
            slots[1] = medium;
            slots[2] = small;
        }

        public boolean addCar(int carType) {
            if (slots[carType - 1] > 0) {
                slots[carType - 1]--;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Basic functionality
        ParkingSystem ps1 = new ParkingSystem(1, 1, 0);
        System.out.println(ps1.addCar(1)); // true, big car fits
        System.out.println(ps1.addCar(2)); // true, medium car fits
        System.out.println(ps1.addCar(3)); // false, no small car slot
        System.out.println(ps1.addCar(1)); // false, big is full

        // Test Case 2: All slots available
        ParkingSystem ps2 = new ParkingSystem(2, 2, 2);
        System.out.println(ps2.addCar(1)); // true
        System.out.println(ps2.addCar(2)); // true
        System.out.println(ps2.addCar(3)); // true
        System.out.println(ps2.addCar(1)); // true
        System.out.println(ps2.addCar(1)); // false, now full

        // Test Case 3: Edge case - No slots
        ParkingSystem ps3 = new ParkingSystem(0, 0, 0);
        System.out.println(ps3.addCar(1)); // false
        System.out.println(ps3.addCar(2)); // false
        System.out.println(ps3.addCar(3)); // false
    }
}
