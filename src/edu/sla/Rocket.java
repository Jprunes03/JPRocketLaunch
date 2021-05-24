package edu.sla;

class Rocket implements Launchable {
    private int launchTime;
    private int id;

    private boolean recursiveMode;

    Rocket(int rocketId, boolean mode) {
        id = rocketId;
        // launchTime is random amount between 2 and 10 seconds
        launchTime = 2 + (int)(Math.random() * 8);
        recursiveMode = mode;
    }

    private void countdownIterative() {
        for (int i = launchTime; i > 0; i--) {
            System.out.println("Rocket " + id + " launching in " + i + " seconds.");
            try {
                // wait 1 second (which is same as 1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void countdownRecursive(int count) {
        if (count > 0) {
            System.out.println("Rocket " + id + " launching in " + count + " seconds.");
            try {
                // wait 1 second (which is same as 1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            countdownRecursive(count - 1);
        }
    }

    private void launch() {
        System.out.println("Rocket " + id + " launching!!!!!!");
        System.out.println("");
    }

    public void run() {
        System.out.println("Rocket " + id + " countdown commence.");
        if (recursiveMode) {
            countdownRecursive(launchTime);
        } else {
            countdownIterative();
        }
        launch();
    }
}
