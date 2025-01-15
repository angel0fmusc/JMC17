package dev.lpa.model;

public class LPAStudent extends Student{

    private double percentComplete;

    public LPAStudent(){
        // execute the super constructor implicitly
        // will generate data for the other fields
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
