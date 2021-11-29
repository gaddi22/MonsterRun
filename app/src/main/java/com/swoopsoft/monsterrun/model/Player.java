package com.swoopsoft.monsterrun.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player{

    public Map<String, Object> statistics;  //{statName, value}
    public String email;
    public String username;
    public double money;
    public Monster monster;
    public Map<String,Integer> inventory;   //{ItemID, Amount}
    public double startingSteps;
    public List<String> leaderboards; //LeaderboardIDs


    public Player(HashMap statistics, String email, String username, double money, List<String> leaderboards, Map inventory, int currentSysSteps){

        this.statistics=statistics;
        this.email=email;
        this.username=username;
        this.money=money;
        this.leaderboards = leaderboards;
        this.inventory = inventory;
        startingSteps = currentSysSteps;
    }

    public Player(){
        statistics = new HashMap<>();
        email = "";
        username = "";
        money = 0;
        leaderboards = new ArrayList<>();
        inventory = new HashMap<>();
        startingSteps = 0;
    }

    public Map<String, Object> getStatistics() {
        return statistics;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public double getMoney() {
        return money;
    }

    public Monster getMonster() {
        return monster;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public double getStartingSteps() {
        return startingSteps;
    }

    public List<String> getLeaderboards() {
        return leaderboards;
    }
}

