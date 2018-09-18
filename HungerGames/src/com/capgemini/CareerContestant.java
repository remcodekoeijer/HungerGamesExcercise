package com.capgemini;

public class CareerContestant extends Contestant {

    public CareerContestant(Gender gender, int attackBonus, int defenceBonus, int health){
        super(gender, attackBonus, defenceBonus, health);
        //As a Career contestant, you get a battle item to start with.
        giveBattleItem(5, 0);
    }
}
