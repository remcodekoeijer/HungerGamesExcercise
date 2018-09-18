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

        System.out.println(contestants[0]);
        System.out.println(contestants[1]);
        battleVictor(contestants[0], contestants[1]);

        //Printing all the created contestants to the console.
        /*for (Contestant c : contestants) {
            System.out.println(c.toString());
        }*/
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

    // This method simulates the fight between 2 contestants and returns the victor.
    // c1 is the contestant that strikes first.
    public Contestant battleVictor(Contestant c1, Contestant c2){
        System.out.println("Battle between contestant #" + c1.getContestantNumber() + " and #" + c2.getContestantNumber());

        Contestant attacker = c1;
        Contestant defender = c2;
        Contestant previousAttacker;
        int attackRoll;
        int defence;
        int damage;

        while(c1.isAlive() && c2.isAlive()){
            System.out.println("The attacker is #" + attacker.getContestantNumber());
            // Get the attackRoll by rolling a D20 and adding attack modifier from either battle item or contestant itself.
            if(attacker.isHasBattleItem()) {
                attackRoll = (random.nextInt(20) + 1) + attacker.battleItem.getAttackBoost();
                damage = (random.nextInt(8) + 1) + 3;
                System.out.println("attackRoll + battleItem = " + attackRoll + " and possible damage is: " + damage);
            }
            else {
                attackRoll = (random.nextInt(20) + 1) + attacker.getAttack();
                damage = random.nextInt(6) + 1;
                System.out.println("attackRoll = " + attackRoll + " and possible damage is: " + damage);
            }

            // If the attackRoll is strictly higher than the defence of the defender, there is a hit!
            // Otherwise the attack is fully blocked/dodged and no damage is done.
            if(defender.isHasBattleItem())
                defence = defender.getDefence() + defender.battleItem.getDefenceBoost();
            else
                defence = defender.getDefence();

            if(attackRoll > defence) {
                defender.setHealth(defender.getHealth() - damage);
                System.out.println("The attackRoll is higher than #" + defender.getContestantNumber() + "'s defence of " + defence);
                System.out.println("Damage is dealt.");
            }
            else
                System.out.println("The attack is blocked/dodged.");

            if(defender.getHealth() <= 0) {
                defender.die();
                System.out.println("Contestant #" + defender.getContestantNumber() + " has died.");
            }
            else
                System.out.println("Contestant #" + defender.getContestantNumber() + " has " + defender.getHealth() + " health left.");

            previousAttacker = attacker;
            attacker = defender;
            defender = previousAttacker;
            System.out.println("Attacker and defender are now switched. \n");
        }
        System.out.println("Contestant #" + attacker.getContestantNumber() + " is the victor!");
        return attacker;
    }

}
