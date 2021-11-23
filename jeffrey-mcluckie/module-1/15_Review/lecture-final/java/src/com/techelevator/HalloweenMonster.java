package com.techelevator;

/**
 * There should not be any instances of the generic HalloweenMonster,
 * only concrete subclasses which then must implement the getScarySound().
 *
 * HalloweenMonster provides default behavior for Scary interface,
 * BUT it leaves the Tricky interface to the child classes to implement.
 * It can do that because it is abstract.
 */
public abstract class HalloweenMonster implements Scary, Tricky{
    // protected can be seen by subclasses directly - THIS IS NOT A GOOD PRACTICE
    // protected String realName;
    private String realName;

    // Using private for the instance variables & controlling access to them through
    // getter/setter methods is good encapsulation
    private String monsterName;
    private int age;
    private int scarinessRating;

    // Because I've added a constructor to this class, there is no longer a default constructor.
    public HalloweenMonster(String monsterName, String realName, int age) {
        this.monsterName = monsterName;
        this.realName = realName;
        this.age = age;
        // No rating initially, will be judged (set) later
        this.scarinessRating = 0;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScarinessRating() {
        return scarinessRating;
    }

    public void setScarinessRating(int scarinessRating) {
        this.scarinessRating = scarinessRating;
    }

    /**
     * Monsters should be able to make a scary sound...
     *  This is abstract, so child classes MUST implement
     *  this as makes sense for them.
     */

    public abstract String getScarySound();

    /**
     * All HalloweeenMonsters are scary by making their sound
     */
    public String beScary() {
        return this.getScarySound();
    }


    // By putting this in the parent class, we don't repeat this code in Ghost, Vampire & all subclasses
    // This makes the code more DRY (Don't Repeat Yourself!)
    // This is overriding a method - this is ONLY done with a parent class method (in this case parent is Object)
    @Override
    public String toString() {
        return String.format("%s{ realName:%s, age:%d, scarinessRating:%d}", this.getClass(),
                this.getRealName(), this.getAge(), this.getScarinessRating());
    }
}
