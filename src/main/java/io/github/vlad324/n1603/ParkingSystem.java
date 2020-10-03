package io.github.vlad324.n1603;

/**
 * {@link "https://leetcode.com/problems/design-parking-system/"}
 */
class ParkingSystem {

    private final int[] parkPlaces = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        this.parkPlaces[0] = big;
        this.parkPlaces[1] = medium;
        this.parkPlaces[2] = small;
    }

    public boolean addCar(int carType) {
        return --this.parkPlaces[carType - 1] >= 0;
    }
}
