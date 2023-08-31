package src;

public class Processor {
    private final double herc;
    private final int cores;
    private final String proizv;
    private final double weight;

    public Processor(double herc, int yader, String proizv, double weight){
        this.herc = herc;
        this.cores = yader;
        this.proizv = proizv;
        this.weight = weight;
    }


    public double getHerc() {
        return herc;
    }

    public int getCores() {
        return cores;
    }

    public String getProizv() {
        return proizv;
    }

    public double getWeight() {
        return weight;
    }


    public Processor setHerc(double herc) {
        return new Processor(herc, cores, proizv, weight);
    }

    public Processor setCores(int cores) {
        return new Processor(herc, cores, proizv, weight);
    }

    public Processor setProizv(String proizv) {
        return new Processor(herc, cores, proizv, weight);
    }

    public Processor setWeight(double weight) {
        return new Processor(herc, cores, proizv, weight);
    }


    public String toString() {
        return ("Частота: " + getHerc() + " кГц; " +
                "Количество ядер: " + getCores() + "; " +
                "Производитель: " + getProizv() + "; " +
                "Масса " + getWeight() + "кг;");
    }
}
