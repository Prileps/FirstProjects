package src;

public class Computer {
    private Processor processor;
    private OperativeMemory operativeMemory;
    private CollectorInfo collectorInfo;
    private Screen screen;
    private Keyboard keyboard;
    private final String vendor;
    private final String name;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public OperativeMemory getOperativeMemory() {
        return operativeMemory;
    }

    public CollectorInfo getCollectorInfo() {
        return collectorInfo;
    }

    public Screen getScreen() {
        return screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setOperativeMemory(OperativeMemory operativeMemory) {
        this.operativeMemory = operativeMemory;
    }

    public void setCollectorInfo(CollectorInfo collectorInfo) {
        this.collectorInfo = collectorInfo;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Computer setVendor(String vendor) {
        return new Computer(vendor, name);
    }

    public Computer setName(String name) {
        return new Computer(vendor, name);
    }

    public String toString() {
        return ("Процессор: " + getProcessor() +
                "\n" + "Оперативная память: " + getOperativeMemory() +
                "\n" + "Накопитель памяти: " + getCollectorInfo() +
                "\n" + "Экран: " + getScreen() +
                "\n" + "Клавиатура: " + getKeyboard() +
                "\n" + "Производитель: " + getVendor() +
                "\n" + "Название: " + getName()
        );
    }

    public double getTotalMass() {
        return (processor.getWeight() +
                operativeMemory.getWeight() +
                keyboard.getWeight() +
                collectorInfo.getWeight() +
                screen.getWeight());
    }


}
