package com.capgemini;

public abstract class Contestant {

    private Gender gender;
    private int contestantNumber, attackBonus, defenceBonus, health;
    private boolean hasBattleItem;
    private boolean alive;
    BattleItem battleItem;

    public Contestant(Gender gender, int contestantNumber, int attackBonus, int defenceBonus, int health){
        setGender(gender);
        setContestantNumber(contestantNumber);
        setAttack(attackBonus);
        setDefence(defenceBonus);
        setHealth(health);
        this.hasBattleItem = false;
        this.alive = true;
    }

    protected void setGender(Gender gender){
        this.gender = gender;
    }
    protected Gender getGender(){
        return gender;
    }

    protected void setContestantNumber(int contestantNumber){
        this.contestantNumber = contestantNumber;
    }
    protected int getContestantNumber(){
        return contestantNumber;
    }

    protected void setAttack(int attack){
        this.attackBonus = attack;
    }
    protected int getAttack(){
        return attackBonus;
    }

    protected void setDefence(int defence){
        this.defenceBonus = defence;
    }
    protected int getDefence(){
        return defenceBonus;
    }

    protected void setHealth(int health){
        this.health = health;
    }
    protected int getHealth(){
        return health;
    }

    protected void giveBattleItem(int attackBoost, int defenceBoost){
        if(hasBattleItem){
            return;
        }
        else{
            hasBattleItem = true;
            battleItem = new BattleItem(attackBoost, defenceBoost);
        }
    }
    protected boolean isHasBattleItem(){
        return hasBattleItem;
    }

    protected void die(){
        alive = false;
    }
    protected boolean isAlive(){
        return alive;
    }


    public String toString(){
        return  "Contestant number: " + contestantNumber + "\n" +
                "AttackBonus: " + attackBonus + "\n" +
                "DefenceBonus: " + defenceBonus + "\n" +
                "Health: " + health + "\n" +
                "Has a battle item: " + hasBattleItem + "\n";
    }

}
