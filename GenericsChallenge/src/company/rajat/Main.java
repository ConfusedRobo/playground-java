package company.rajat;

public class Main {
//     Create a generic class to implement a league table for a sport.
//     The class should allow teams to be added to the list, and store
//     a list of teams that belong to the league.
//
//     Your class should have a method to print out the teams in order,
//     with the team at the top of the league printed first.
//
//     Only teams of the same type should be added to any particular
//     instance of the league class - the program should fail to compile
//     if an attempt is made to add an incompatible team.

    public static void main(String[] args) {
        Football football = new Football();
        System.out.println("Sports: " + football.getName());

        Team<Football> liverpool = new Team<>("Liverpool", 3, 32, 3, 38, 85, 33, "+52", 99);
        Team<Football> manchesterCity = new Team<>("Manchester City", 3, 26, 9, 38, 102, 35, "+67", 81);
        Team<Football> manchesterUnited = new Team<>("Manchester United", 12, 18, 8, 38, 66, 36, "+30", 66);
        Team<Football> chelsea = new Team<>("Chelsea", 6, 20, 12, 38, 69, 54, "+15", 66);

        LeagueTable<Football> premierLeague = new LeagueTable<>("Premier League");
        premierLeague.addTeam(liverpool);
        premierLeague.addTeam(manchesterCity);
        premierLeague.addTeam(manchesterUnited);
        premierLeague.addTeam(chelsea);

        premierLeague.removeTeam(chelsea);

        premierLeague.printTeamList();

        System.out.println();
        System.out.println();

        Cricket cricket = new Cricket();
        System.out.println("Sports: " + cricket.getName());

        Team<Cricket> chennaiSuperKings = new Team<>("Chennai Super Kings", 20, 10, 8, 38, 200, 150, "+50", 55);
        Team<Cricket> mumbaiIndians = new Team<>("Mumbai Indians", 10, 18, 18, 38, 100, 150, "-50", 10);
        Team<Cricket> kolkataKnightRiders = new Team<>("Kolkata Knight Riders", 21, 9, 8, 38, 500, 150, "+350", 155);

        LeagueTable<Cricket> indianPremierLeague = new LeagueTable<>("Indian Premier League");
        indianPremierLeague.addTeam(chennaiSuperKings);
        indianPremierLeague.addTeam(kolkataKnightRiders);
        indianPremierLeague.addTeam(mumbaiIndians);
//        indianPremierLeague.addTeam(chelsea);
//        error code ^
        indianPremierLeague.printTeamList();
    }
}
