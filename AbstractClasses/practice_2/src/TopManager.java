public class TopManager implements Employee {
    private static final int FIX_SALARY = 300_000;

    public int getMonthSalary() {
        if (Company.getIncome() > 10_000_000) {
            return FIX_SALARY + (int) (FIX_SALARY * 1.5);
        } else {
            return FIX_SALARY;
        }
    }
}
