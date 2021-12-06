package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("Computer");
    long min = 0;
    long max = 100;
    boolean lowerOrGreater = true;
    boolean FirstHit = true;

    @Override
    public long askNextGuess() {
        long mean = (this.max+this.min)/2;

        if(this.FirstHit){
            this.FirstHit = false;
        }else{
            if(lowerOrGreater){
                this.max = mean - 1;
            }else{
                this.min = mean + 1;
            }
        }
        this.logger.log("Maximum Number : " + this.max);
        this.logger.log("Minimum Number : " + this.min);
        mean = (this.max+this.min)/2;

        this.logger.log("Computrer Number : " + mean);
        return mean;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        this.lowerOrGreater = lowerOrGreater;
        if(lowerOrGreater){
            this.logger.log("Try a lower Number");
        }else{
            this.logger.log("Try a higher Number");
        }
    }
}
