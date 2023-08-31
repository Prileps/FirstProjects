package src;

public class CollectorInfo {
    private final CollectorInfoType type;
    private final double volume;
    private final double weight;

    public CollectorInfo(CollectorInfoType type, double volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public CollectorInfo setType(CollectorInfoType type) {
        return new CollectorInfo(type, volume, weight);
    }

    public CollectorInfo setVolume(double volume) {
        return new CollectorInfo(type, volume, weight);
    }

    public CollectorInfo setWeight(double weight) {
        return new CollectorInfo(type, volume, weight);
    }

    public CollectorInfoType getType() {
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
                "Объем памяти: " + getVolume() + " ГБ; " +
                "Масса: " + getWeight() + " кг;");
    }
}
