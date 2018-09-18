package com.capgemini;

import java.util.Random;

public class GamesController {

    int numberOfTotalContestants = 24;
    int numberOfAliveContestants = numberOfTotalContestants;
    Contestant[] contestants = new Contestant[numberOfTotalContestants];

    Gender gender;
    int attackBonus, defenceBonus, health;

    Random random = new Random();

    public GamesController(){

        for (int i = 0; i < numberOfTotalContestants; i++){
            //For now half of the contestants are Career and the other half is District
            if(i % 2 == 0){
                gender = randomGender();
                attackBonus = getRandomNumberInRange(2,4);
                defenceBonus = getRandomNumberInRange(8, 13);
                health = getRandomNumberInRange(15, 30);

                contestants[i] = new CareerContestant(gender, i, attackBonus, defenceBonus, health);
            }
            else{
                gender = randomGender();
                attackBonus = getRandomNumberInRange(2,4);
                defenceBonus = getRandomNumberInRange(8, 13);
                health = getRandomNumberInRange(15, 30);

                contestants[i] = new DistrictContestant(gender, i, attackBonus, defenceBonus, health);
            }
        }

        for (Contestant c : contestants) {
            System.out.println(c.toString());
        }
    }

    private Gender randomGender(){
        if(Math.random() >= 0.5d){
            return Gender.MALE;
        }
        else
            return Gender.FEMALE;
    }

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            System.out.println("Max must be greater than min in GamesController.getRandomNumberIntRange. " +
                    "For now these values are switched.");
            int temp = max;
            max = min;
            min = temp;
        }
        //Normally the bound random runs from 0 to bound-1. Therefore the +1 is added.
        return random.nextInt((max - min) + 1) + min;
    }

}
