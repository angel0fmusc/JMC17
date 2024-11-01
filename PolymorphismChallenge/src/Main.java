public class Main {
    public static void main(String[] args) {

        /**
         * Want to have runtime code execute different behavior for different objects
         */
        Car car = new Car("2022 Blue Ferrari 296 GTS");
        runRace(car);

        Car ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTS", 15.4, 6);
        runRace(ferrari);

        ElectricCar tesla = new ElectricCar("2022 Red Tesla model 3", 568, 75);
        runRace(tesla);

        Car ferrariHybrid = new HybridCar("2022 black Ferrari SF90 Stradale", 16, 8, 8);
        runRace(ferrariHybrid);
    }

    public static void runRace(Car car){
        car.startEngine();
        car.drive();
    }
}
