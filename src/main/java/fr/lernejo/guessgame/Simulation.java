package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final HumanPlayer player;
    private long guessingNumber;
    private boolean answer = true;

    public Simulation(Player player) {
        this.player = (HumanPlayer) player;
        this.initialize(this.guessingNumber);
    }

    public void initialize(long guessingNumber) {
        this.guessingNumber = guessingNumber;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long nb = this.player.askNextGuess();

        if(nb == this.guessingNumber){
            this.logger.log("You found it !");
            answer = false;
            return true;
        }else{
            if(nb > this.guessingNumber){
                this.logger.log("Try a lower number");
                //this.player.respond(true);
                return false;
            }else if(nb < this.guessingNumber){
                //this.player.respond(false);
                this.logger.log("Try a higher number");
                return false;
            }
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        while(answer){
            this.nextRound();
        }
    }
}
