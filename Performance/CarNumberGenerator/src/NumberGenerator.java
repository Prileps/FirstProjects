import java.io.FileOutputStream;

public class NumberGenerator extends Thread {
    private int minRegionCode;
    private int maxRegionCode;
    private String dstFile;
    private long start;

    public NumberGenerator(int minRegionCode, int maxRegionCode, String dstFile, long start) {
        this.maxRegionCode = maxRegionCode;
        this.minRegionCode = minRegionCode;
        this.dstFile = dstFile;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            FileOutputStream writer = new FileOutputStream(dstFile);

            char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

            for (int regionCode = minRegionCode; regionCode <= maxRegionCode; regionCode++) {
                for (int number = 1; number < 1000; number++) {
                    StringBuilder builder = new StringBuilder();
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter);
                                builder.append(padNumber(number, 3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(regionCode, 2));
                                builder.append('\n');
                            }
                        }
                    }
                    writer.write(builder.toString().getBytes());
                }
            }

            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finished in " + (System.currentTimeMillis()- start) + " ms");
    }
    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        StringBuilder builder = new StringBuilder(numberStr);

        for (int i = 0; i < padSize; i++) {
            builder.insert(0, "0");
        }

        return builder.toString();
    }
}
