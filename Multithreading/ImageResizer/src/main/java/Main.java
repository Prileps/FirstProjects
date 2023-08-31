import java.io.File;

public class Main {
    private static final int NEW_WIDTH = 300;

    public static void main(String[] args) {
        String srcFolder = "/users/egor/Desktop/src";
        String dstFolder = "/users/egor/Desktop/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        Runtime runtime = Runtime.getRuntime();

        int numberOfProcessors = runtime.availableProcessors();

        File[] files = srcDir.listFiles();

        assert files != null;

        int imagesInOneThread = files.length / numberOfProcessors;

        int flag = 0;

        File[] filesInOneThread = new File[imagesInOneThread];

        for (File file : files) {

            filesInOneThread[flag++] = file;

            if (flag == imagesInOneThread) {

                new Resizer(filesInOneThread, NEW_WIDTH, dstFolder, start).start();
                filesInOneThread = new File[imagesInOneThread];
                flag = 0;

            }
        }
    }
}
