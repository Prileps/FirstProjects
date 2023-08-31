package src;

public class OperativeMemory {
    private final String type;
    private final double volume;
    private final double weight;

    public OperativeMemory(String type, double volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public OperativeMemory setType(String type) {
        return new OperativeMemory(type, volume, weight);
    }

    public OperativeMemory setVolume(double volume) {
        return new OperativeMemory(type, volume, weight);
    }

    public OperativeMemory setWeight(double weight) {
        return new OperativeMemory(type, volume, weight);
    }

    public String getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return ("Тип: " + getType() + "; " +
                "Объем: " + getVolume() + " ГБ; " +
                "Масса: " + getWeight() + " кг;");
    }
}
