package com.capgemini;

public class CareerContestant extends Contestant {

    public CareerContestant(Gender gender, int contestantNumber, int attackBonus, int defenceBonus, int health){
        super(gender, contestantNumber, attackBonus, defenceBonus, health);
        //As a Career contestant, you get a battle item to start with.
        giveBattleItem(5, 0);
    }
    public String toString(){
        return "This contestant has the following information: \n" +
                "Is a Career contestant \n"+ super.toString();
    }
}
