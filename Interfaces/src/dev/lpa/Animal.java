package dev.lpa;

interface FlightEnabled{
//    protected abstract void takeOff();    Incorrect access modifier (protected), redundant "abstract"
//    abstract void land();     Redundant "abstract" classification

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void fly();
    void takeOff();
    void land();
}

interface Trackable{
    void track();
}

public abstract class Animal {

    public abstract void move();
}
