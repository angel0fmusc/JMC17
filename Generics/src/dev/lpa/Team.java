package dev.lpa;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode){
    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}

// Dealing with T instances
public class Team<T extends Player, S> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t){

        // Check if one T is equal to another Ts
        // same fields, if not, add the T
        if(!teamMembers.contains(t)){
            teamMembers.add(t);
        }
    }

    public void listTeamMembers(){
        System.out.print(teamName + " Roster:");
        System.out.println((affiliation == null ? "" : " AFFILIATION: " + affiliation));
        for(T t : teamMembers){
            System.out.println(t.name());
        }
    }

    /**
     * Best team should have the highest rank:
     * Team with the most wins
     * Losses count more, adding 1 ensures
     * the highest rank is never higher than 1
     * @return int representing this team's rank
     */
    public int ranking(){
        return (totalLosses * 2) + totalTies + 1;
    }

    /**
     * Figures out which variable to increase:
     * wins, ties, or losses
     * @param ourScore int
     * @param theirScore int
     * @return String
     */
    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";
        if(ourScore > theirScore){
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore){
            totalTies++;
            message = "tied";
        } else{
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
