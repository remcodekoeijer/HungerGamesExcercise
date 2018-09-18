package com.capgemini;

public abstract class Contestant {

    private Gender gender;
    private int attackBonus, defenceBonus, health;
    private boolean hasBattleItem;

    public Contestant(Gender gender, int attackBonus, int defenceBonus, int health, boolean hasBattleItem){
        setGender(gender);
        setAttack(attackBonus);
        setDefence(defenceBonus);
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
