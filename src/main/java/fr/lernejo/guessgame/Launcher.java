package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {

        if (args[0].equals("-interactive")) {
            HumanPlayer humanPlayer = new HumanPlayer();
            Simulation simulation = new Simulation(humanPlayer);

            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextLong(1, 101);

            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if ((args[0].equals("-auto")) && (args[1].matches("-?\\d+(\\.\\d+)?"))) {
            ComputerPlayer computerPlayer = new ComputerPlayer();
            Simulation simulation = new Simulation(computerPlayer);
            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed(10);
        } else {
            System.out.println("Two ways to start the program : ");
            System.out.println("-interactive");
            System.out.println("Or");
            System.out.println("-auto 'Number'");

        }
    }
}
