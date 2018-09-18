package com.capgemini;

public class DistrictContestant extends Contestant {

    public DistrictContestant(Gender gender, int contestantNumber, int attackBonus, int defenceBonus, int health){
        super(gender, contestantNumber, attackBonus, defenceBonus, health);
        //As a District contestant, you get a boosted defenceBonus.
        setDefence(getDefence()+2);
    }

    public String toString(){
        return "This contestant has the following information: \n" +
                "Is a District contestant \n"+ super.toString();
    }
}
