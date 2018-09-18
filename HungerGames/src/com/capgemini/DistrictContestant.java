package com.capgemini;

public class DistrictContestant extends Contestant {

    public DistrictContestant(Gender gender, int attackBonus, int defenceBonus, int health, boolean hasBattleItem){
        super(gender, attackBonus, defenceBonus, health);
        //As a District contestant, you get a boosted defenceBonus.
        setDefence(getDefence()+2);
    }
}
