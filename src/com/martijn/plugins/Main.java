package com.martijn.plugins;

public class Main {

    public static void main(String[] args) {
        SoccerPlayer henk = new SoccerPlayer("henk");
        FootballPlayer bas = new FootballPlayer("bas");
        BaseballPlayer ruud = new BaseballPlayer("ruud");
        BaseballPlayer mike = new BaseballPlayer("mike");

        Team<SoccerPlayer> soccerTeam = new Team<>("suckers");
        soccerTeam.addPlayer(henk);
//        soccerTeam.addPlayer(bas);
//        soccerTeam.addPlayer(ruud);

        Team<BaseballPlayer> baseballTeam = new Team<>("handsfree");
        baseballTeam.addPlayer(ruud);
        System.out.println("clubmembers: " + baseballTeam.numPlayers());

        Team<BaseballPlayer> baseballTeam2 = new Team<>("noHands");
        baseballTeam2.addPlayer(mike);

        baseballTeam.matchResults(baseballTeam2, 3, 4);

//        Team<String> doesntWork = new Team<>("pooopp");
//        doesntWork.addPlayer("pooo");
        System.out.println(baseballTeam.compareTo(baseballTeam2));


    }
}
