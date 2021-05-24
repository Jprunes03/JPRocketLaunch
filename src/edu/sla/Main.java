package edu.sla;

public class Main {

    public static void main(String[] args) {
        boolean recursiveMode = false;
        int numRockets = 2;

        System.out.println("Will launch " + numRockets + " Rockets" + (recursiveMode ? " recursively." : " iteratively."));
        System.out.println("");

        // Let's launch some rockets
        for (int i = 0; i < numRockets; i++) {
            Launchable rocket = new Rocket(i+1, recursiveMode);
            rocket.run();
        }

        System.out.println("All Rockets launched successfully!");
    }
}
