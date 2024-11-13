package dev.lpa;

public record Location(String town, int distance) {

    @Override
    public String toString() {
        return String.format("%s (%d)", town, distance);
    }
}
