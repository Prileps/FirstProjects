public class Loader {
    private final static int MAX_REGION = 100;
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        int processorsNumber = runtime.availableProcessors();

        int threadsNumber = MAX_REGION / processorsNumber;
        int regionsInThread = MAX_REGION / threadsNumber;
        int flag = 1;

        for (int i = 1; i < threadsNumber; i++) {
            new NumberGenerator(flag, flag + regionsInThread - 1, ("res/numbers" + i + ".txt"), System.currentTimeMillis()).start();
            flag += regionsInThread;
        }


        new  NumberGenerator(flag, MAX_REGION, ("res/numbers" + threadsNumber + ".txt"), System.currentTimeMillis()).start();

//        new NumberGenerator(1, MAX_REGION, "res/oneThread.txt", System.currentTimeMillis()).start();

    }
}