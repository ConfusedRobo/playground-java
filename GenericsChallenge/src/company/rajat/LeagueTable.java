package company.rajat;

import java.util.*;

public class LeagueTable<T extends Game> {
    private final List<Team<T>> teamList;
    private final String name;

    public LeagueTable(String name) {
        teamList = new ArrayList<>();
        this.name = name;
    }

    public void printTeamList() {
        if (teamList.isEmpty()) {
            System.out.println("League has no members.");
        } else {
            Collections.sort(teamList);

            System.out.println(getName());
            System.out.println("Order: Position Club Played Won Drawn Lost F A D Points");
            for (int i = 0; i < teamList.size(); i++) {
                System.out.println((i + 1) + " " + teamList.get(i).getName() + "\t"
                        + teamList.get(i).getPlayed() + " " + teamList.get(i).getWon() + " "
                        + teamList.get(i).getDrawn() + " " + teamList.get(i).getLost() + " "
                        + teamList.get(i).getScoreFor() + " " + teamList.get(i).getScoreAgainst() + " "
                        + teamList.get(i).getScoreDifference() + " " + teamList.get(i).getPoints());
            }
        }
    }

    public void addTeam(Team<T> team) {
        if (teamList.contains(team)) {
            System.out.println("Duplicate values are not allowed.");
        } else {
            teamList.add(team);
            System.out.println(team.getName() + " added to the table.");
        }
    }

    public void removeTeam(Team<T> team) {
        if (!teamList.contains(team)) {
            System.out.println("Unable to remove. Reason: Value not found.");
        } else {
            teamList.remove(team);
            System.out.println(team.getName() + " removed from the table.");
        }
    }

    public String getName() {
        return name;
    }
}
