package dev.lpa;

enum FlightStages implements Trackable{
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}
record DragonFly(String name, String type) implements FlightEnabled{

    @Override
    public void fly() {

    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }
}

class Satellite implements OrbitEarth{

    FlightStages stage = FlightStages.GROUNDED;

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved!");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data collection while orbiting");
    }

    @Override
    public void takeOff() {
        transition("Taking off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

interface OrbitEarth extends FlightEnabled{
    void achieveOrbit();

    private static void log(String description){
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description){
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition to " + nextStage);
        return nextStage;

    }
}

interface FlightEnabled{
//    protected abstract void takeOff();    Incorrect access modifier (protected), redundant "abstract"
//    abstract void land();     Redundant "abstract" classification

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void fly();
    void takeOff();
    void land();

    default FlightStages transition(FlightStages stage) {
//        System.out.println(getClass().getSimpleName() + "transitioning");
//        return FlightStages.CRUISE;
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }
}

interface Trackable{
    void track();
}

public abstract class Animal {

    public abstract void move();
}
