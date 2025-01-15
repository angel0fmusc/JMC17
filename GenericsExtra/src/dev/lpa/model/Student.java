package dev.lpa.model;

import java.util.Random;

public class Student {

    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();
    private static String[] firstNames = {"Ann","Bill","Cathy","John","Tim"};
    private static String[] courses = {"C++","Java","Python"};

    public Student(){
        // Randomly generate a single letter for last name
        // 65 is the integer value for 'A', 90 is the integer value for 'Z'
        // upper bound includes 90, but not 91
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char)lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
    }

    @Override
    public String toString() {
        // name and course are left justified with -15
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }
}
