public class Manager implements Employee {
    private static final int FIX_SALARY = 150_000;
    public final double earnForComp = (Math.random() * 20_000) + 115_000;

    public int getMonthSalary() {
        return FIX_SALARY + (int) (earnForComp * 0.05);
    }
}