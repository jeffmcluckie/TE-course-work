package com.company;

public class Ghost extends Monster implements Scary, Tricky {
    public Ghost(String monsterName, String realName, int age, int scaryRating) {
        super(monsterName, realName, age, scaryRating);
    }

    @Override
    public String getScarySound() {
        return "boo";
    }

    @Override
    public String isScary() {
        return "yes";
    }

    @Override
    public String doTrick() {
        return "disappears";
    }
}
