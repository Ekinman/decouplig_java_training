package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long guessingNumber;
    private boolean answer = true;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long guessingNumber) {
        this.guessingNumber = guessingNumber;
    }

    /**
     * @return true if the player has guessed the right number
     */
    private boolean nextRound() {
        long number = this.player.askNextGuess();

        if(number == this.guessingNumber){
            this.logger.log("You found it !");
            answer = false;
            return true;
        }else{
            if(number > this.guessingNumber){
                this.player.respond(true);
                return false;
            }else if(number < this.guessingNumber){
                this.player.respond(false);
                return false;
            }
        }
        this.logger.log("Lost");
        return false;
    }

    public void loopUntilPlayerSucceed(long number_iter) {
        int trial = 0;
        boolean found = false;
        long firstTime = System.currentTimeMillis();
        while(trial < number_iter){
            found = this.nextRound();
            if(found){
                break;
            }else{
                trial++;
            }

        }
        if(!found){
            this.logger.log("Lost ! The number was : " + guessingNumber);
        }
        long secondTime = System.currentTimeMillis();

        this.logger.log("Time spent : " + (secondTime-firstTime) + " ms");
    }
}
