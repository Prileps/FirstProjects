import java.util.*;
public class Company {
    protected static int income = 15_000_000;
    protected ArrayList<Employee> allEmployeesList = new ArrayList<>();

    public void hire(Employee employee) {
        allEmployeesList.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        allEmployeesList.addAll(employees);
    }

    public void fire(Employee employee) {
        allEmployeesList.remove(employee);
    }

    public static int getIncome() {
        return income;
    }

    private ArrayList<Employee> getFilteredLimitedList(int count, Comparator<Employee> comparator) {
        ArrayList<Employee> secondList = new ArrayList<Employee>(allEmployeesList);
        Collections.sort(secondList, comparator);
        ArrayList<Employee> result = new ArrayList<Employee>();
        for (int i = 0; i < count; i++) {
            result.add(secondList.get(i));
        }
        return result;
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }
        });
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }
        });
    }

    public int countEmployees() {
        return allEmployeesList.size();
    }

    public ArrayList<Employee> getEmployees() {
        return allEmployeesList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}