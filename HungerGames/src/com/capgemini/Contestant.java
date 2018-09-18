package com.capgemini;

public abstract class Contestant {

    protected Gender gender;
    protected int attack, defence, health;
    protected boolean hasBattleItem;

    public Contestant(Gender gender, int attack, int defence, int health, boolean hasBattleItem){
        setGender(gender);
        setAttack(attack);
        setDefence(defence);
        setHealth(health);
        this.hasBattleItem = hasBattleItem;
    }

    protected void setGender(Gender gender){
        this.gender = gender;
    }
    protected Gender getGender(){
        return gender;
    }

    protected void setAttack(int attack){
        this.attack = attack;
    }
    protected int getAttack(){
        return attack;
    }

    protected void setDefence(int defence){
        this.defence = defence;
    }
    protected int getDefence(){
        return defence;
    }

    protected void setHealth(int health){
        this.health = health;
    }
    protected int getHealth(){
        return health;
    }

    protected void giveBattleItem(){
        if(hasBattleItem){
            System.out.println("Battle item given, but already had battle item. TODO");
            return;
        }
        else
            hasBattleItem = true;
    }
    protected boolean isHasBattleItem(){
        return hasBattleItem;
    }

}
