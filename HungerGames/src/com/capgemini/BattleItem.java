package com.capgemini;

public class BattleItem {

    private int attackBoost, defenceBoost;
    public BattleItem(int attackBoost, int defenceBoost){
        this.attackBoost = attackBoost;
        this.defenceBoost = defenceBoost;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public int getDefenceBoost() {
        return defenceBoost;
    }
}
