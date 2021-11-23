package com.company;


public class Vampire extends Monster implements Scary, Tricky {

    public Vampire(String monsterName, String realName, int age, int scaryRating) {
        super(monsterName, realName, age, scaryRating);
        System.out.println(getRealName() + " is a " + getMonsterName() + " who is " + getAge() + " years old and has " + getScaryRating() + " scary points");
    }

    @Override
    public String getScarySound() {
        return "bite";
    }

    @Override
    public String isScary() {
        return "yes";
    }

    @Override
    public String doTrick() {
        return "sucks blood";
    }
}
