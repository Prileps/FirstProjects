package src;

public class Keyboard {
    private final String type;
    private final boolean isLight;
    private final double weight;

    public Keyboard(String type, boolean isLight, double weight) {
        this.type = type;
        this.isLight = isLight;
        this.weight = weight;
    }

    public Keyboard setType(String type) {
        return new Keyboard(type, isLight, weight);
    }

    public Keyboard setLight(boolean isLight) {
        return new Keyboard(type, isLight, weight);
    }

    public Keyboard setWeight(double weight) {
        return new Keyboard(type, isLight, weight);
    }

    public String getType() {
        return type;
    }

    public boolean getIsLight() {
        return isLight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return ("Тип: " + getType() + "; " +
                "Имеется подсветка: " + getIsLight() + "; " +
                "Масса: " + getWeight() + " кг;");
    }
}
