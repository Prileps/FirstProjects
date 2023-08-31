package ObjectsAndClasses_Encapsulation;

public class Goods {
    private final double mass;
    private final String address;
    private final boolean isTurningOver;
    private final String registNumber;
    private final boolean isFragile;
    private final Dimensions dimensions;


    public Goods(Dimensions dimensions, double mass, String adress, boolean isTurningOver, String registNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.address = adress;
        this.isTurningOver = isTurningOver;
        this.registNumber = registNumber;
        this.isFragile = isFragile;
    }

    public Goods setDimensions(Dimensions dimensions) {
        return new Goods(dimensions, mass, address, isTurningOver, registNumber, isFragile);
    }

    public Goods setMass(double mass) {
        return new Goods(dimensions, mass, address, isTurningOver, registNumber, isFragile);
    }

    public Goods setAdress(String adress) {
        return new Goods(dimensions, mass, adress, isTurningOver, registNumber, isFragile);
    }

    public Goods setTurningOver(boolean isTurningOver) {
        return new Goods(dimensions, mass, address, isTurningOver, registNumber, isFragile);
    }

    public Goods setRegistNumber(String registNumber) {
        return new Goods(dimensions, mass, address, isTurningOver, registNumber, isFragile);
    }

    public Goods setIsFragile(boolean isFragile) {
        return new Goods(dimensions, mass, address, isTurningOver, registNumber, isFragile);
    }


    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getMass() {
        return mass;
    }

    public String getAdress() {
        return address;
    }

    public boolean getIsTurningOver() {
        return isTurningOver;
    }

    public String getRegistNumber() {
        return registNumber;
    }

    public boolean getIsFragile() {
        return isFragile;
    }

    public String toString() {
        return (dimensions + "\n" +
                        mass + "\n" +
                        address + "\n" +
                        isTurningOver + "\n" +
                        registNumber + "\n" +
                isFragile);
    }
}
