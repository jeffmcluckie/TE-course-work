package com.company;

public class Zombie extends Monster implements Scary{
    public Zombie(String monsterName, String realName, int age, int scaryRating) {
        super(monsterName, realName, age, scaryRating);
    }

    @Override
    public String getScarySound() {
        return "brains";
    }

    @Override
    public String isScary() {
        return "yes";
    }

}
