package practice;

import java.util.*;
class Main {
    public static void main(String[] args) {
        int HealthOfA, HealthOfB,StrengthOfA, StrengthOfB, AttackOfA, AttackOfB, AttackDamage,DefenceStrength;
        
        int Attackflag=0; // 1 if A is attacker, 0 if A is defender

        int attackDice, defenceDice;
        
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player A's Health, Strength, Attack with space seperated");
        HealthOfA = sc.nextInt();
        StrengthOfA = sc.nextInt();
        AttackOfA = sc.nextInt();
        System.out.println("Enter Player B's Health, Strength, Attack with space seperated");
        HealthOfB = sc.nextInt();
        StrengthOfB = sc.nextInt();
        AttackOfB = sc.nextInt();
        
        if(HealthOfA < HealthOfB){
            Attackflag=1;
        }
        
        while(HealthOfA >0 && HealthOfB > 0 ){ // loop will execute until any one of their healths become less than zero

            //Rolling dices
            attackDice = rand.nextInt(6)+1;
            defenceDice = rand.nextInt(6)+1;
            System.out.println( "Attack Dice value: "+attackDice+" Defence Dice Value "+defenceDice);
            
            
            if(Attackflag==1){ // A is attacking

                AttackDamage = AttackOfA*attackDice;
                System.out.println("Attack Damage of A "+ AttackDamage);
                DefenceStrength = StrengthOfB*defenceDice;
                System.out.println("Defense Strength of B "+ DefenceStrength);
                if( DefenceStrength < AttackDamage){
                    HealthOfB = HealthOfB - (AttackDamage - DefenceStrength);
                }
                Attackflag=0;

            }
            
            else{ // B is attacking

                AttackDamage = AttackOfB*attackDice;
                System.out.println("Attack Damage of B "+ AttackDamage);
                DefenceStrength = StrengthOfA*defenceDice;
                System.out.println("Defense Strength of A "+ DefenceStrength);
                if( DefenceStrength < AttackDamage){
                    HealthOfA = HealthOfA - (AttackDamage - DefenceStrength);
                }
                Attackflag=1;

            }
         
            System.out.println("Health of A " + HealthOfA +"  Health of B "+ HealthOfB);
            
        }
        if(HealthOfA<=0){
            System.out.println("Player A lost the Game");
        }
        else{
            System.out.println("Player B lost the Game");
        }
        
    }
}