package src;

public class Main {
    public static void main(String[] args) {
        Processor processor1 = new Processor(1.7, 2, "Canada Industries", 5);
        OperativeMemory operativeMemory1 = new OperativeMemory("DDR2", 8.0, 0.5);
        CollectorInfo collectorInfo1 = new CollectorInfo(CollectorInfoType.HDD, 8.7, 1);
        Screen screen1 = new Screen(10, ScreenType.TN, 4);
        Keyboard keyboard1 = new Keyboard("Membrane", false, 2);
        Computer computer1 = new Computer("CanadaIndustries", "MacPro");
        computer1.setProcessor(processor1);
        computer1.setOperativeMemory(operativeMemory1);
        computer1.setCollectorInfo(collectorInfo1);
        computer1.setScreen(screen1);
        computer1.setKeyboard(keyboard1);

        System.out.println("Компьютер1:");
        System.out.println(computer1);
        System.out.println("Общая масса компьютера1 равна: " +
                computer1.getTotalMass() + " кг \n");


        Processor processor2 = new Processor(1.7, 2, "Japan Industries", 10);
        OperativeMemory operativeMemory2 = new OperativeMemory("DDR", 8.0, 1);
        CollectorInfo collectorInfo2 = new CollectorInfo(CollectorInfoType.SSD, 8.7, 2);
        Screen screen2 = new Screen(10, ScreenType.VA, 8);
        Keyboard keyboard2 = new Keyboard("Membrane", true, 4);
        Computer computer2 = new Computer("CanadaIndustries", "WindowsPro :-)");
        computer2.setProcessor(processor2);
        computer2.setOperativeMemory(operativeMemory2);
        computer2.setCollectorInfo(collectorInfo2);
        computer2.setScreen(screen2);
        computer2.setKeyboard(keyboard2);

        System.out.println("Компьютер2:");
        System.out.println(computer2);
        System.out.println("Общая масса компьютера2 равна: " +
                computer2.getTotalMass() + " кг \n");
    }
}
