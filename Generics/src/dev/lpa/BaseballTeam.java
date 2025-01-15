package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {

    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(BaseballPlayer player){

        // Check if one player is equal to another players
        // same fields, if not, add the player
        if(!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listTeamMembers(){
        System.out.print(teamName + " Roster:");
        System.out.println(teamMembers);
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
