package com.martijn.plugins;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    private int wins;
    private int lost;
    private int draw;

    public ArrayList<T> players = new ArrayList();

    public Team(String name) {
        this.name = name;
    }

    public boolean addPlayer(T player){
        if(this.players.contains(player)){
            System.out.println(player.getName() + " already exists in this team");
            return false;
        } else{
            this.players.add(player);
            System.out.println(player.getName() + " added to " + this.name);
        }
        return true;
    }

    public int numPlayers(){
        return this.players.size();
    }

    public void matchResults(Team<T> opponentTeam, int homeScore, int outScore){
        String message;
        if(homeScore > outScore){
            this.wins++;
            message = "win: ";
        }else if(homeScore == outScore){
            this.draw++;
            message = " draw ";
        }else{
            this.lost++;
            message = " lost ";
        }if(opponentTeam != null){
            opponentTeam.matchResults(null, outScore, homeScore);
            System.out.println(message + this.getName() + " VS " + opponentTeam.getName() + " ends with: " + homeScore + " - " + outScore);
        }
    }

    public String getName() {
        return name;
    }

    public int ranking(){
        return (wins * 2) + draw;
    }

    @Override
    public int compareTo(Team<T> opponent) {
        if(this.ranking() > opponent.ranking()){
            return -1;
        }else if(this.ranking() < opponent.ranking()){
            return 1;
        }
        return 0;
    }
}
