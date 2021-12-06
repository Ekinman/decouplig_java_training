package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("Player");
    @Override
    public long askNextGuess(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number:");
        return scanner.nextLong();
    }

    @Override
    public void respond (boolean lowerOrGreater){
        if (lowerOrGreater){
            this.logger.log("Failed : Try a lower number");
        }else{
            this.logger.log("Failed : Try a greater number");
        }
    }
}
