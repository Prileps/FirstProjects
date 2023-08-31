public class Main {
    public static void main(String[] args) {
        Company alfa = new Company();

        //Let's hire 180 employees-operators
        for (int i = 0; i < 180; i++) {
            Employee operator = new Operator();
            alfa.hire(operator);
        }

        //Let's hire 80 employees-managers
        for (int i = 0; i < 80; i++) {
            Employee manager = new Manager();
            alfa.hire(manager);
        }

        //Let's hire 10 employees-topmanagers
        for (int i = 0; i < 10; i++) {
            Employee topManager = new TopManager();
            alfa.hire(topManager);
        }

        System.out.println("Добавлено " + alfa.countEmployees() + " сотрудников\nТоп 15 самых высоких зарплат:" );

        for (Employee employee : alfa.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("Топ 30 самый низких зарплат в компании:");

        for (Employee employee : alfa.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }

        //fire 50% staff
        for (int i = 0; i < alfa.countEmployees()/2; i++) {
            int index = (int) (Math.random() * alfa.countEmployees());
            Employee badEmployee = alfa.getEmployees().get(index);
            alfa.fire(badEmployee);
        }

        System.out.println("Уволены 50% всех сотрудников\nТоп 15 самых высоких зарплат:" );

        for (Employee employee : alfa.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("Топ 30 самый низких зарплат в компании:");

        for (Employee employee : alfa.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }

    }
}
