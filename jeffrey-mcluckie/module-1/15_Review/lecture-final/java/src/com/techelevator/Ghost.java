package com.techelevator;

public class Ghost extends HalloweenMonster {
    public Ghost(String realName, int age) {
        // Because the HalloweenMonster class has ONLY a constructor that takes 3 inputs
        //    the Ghost class must provide a constructor that calls super() passing in those 3 values.
        // Set a default the monster name for all Ghost instances to "ghost"
        super("ghost", realName, age);
    }

    @Override
    public String getScarySound() {
        return "boo!";
    }

    @Override
    public String doTrick() {
        return "Did a ghostly backflip.";
    }

//    @Override
//    public String toString() {
//        return String.format("Ghost{ realName:%s, age:%d, scarinessRating:%d}",
//                this.getRealName(), this.getAge(), this.getScarinessRating());
//    }

}
