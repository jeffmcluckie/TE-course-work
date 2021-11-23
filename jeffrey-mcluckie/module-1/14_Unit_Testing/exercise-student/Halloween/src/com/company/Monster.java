package com.company;

public abstract class Monster {
    private String monsterName;
    private String realName;
    private int age;
    private int scaryRating;

    public Monster(String monsterName, String realName, int age, int scaryRating) {
        this.monsterName = monsterName;
        this.realName = realName;
        this.age = age;
        this.scaryRating = scaryRating;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public String getRealName() {
        return realName;
    }

    public int getAge() {
        return age;
    }

    public int getScaryRating() {
        return scaryRating;
    }

    public abstract String getScarySound();
}
