package lesson5;

public class lesson5 {
    public static void main(String[] args) {
        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Ivsnov Ivan", "engineer", "a@a.ru", "89002009090", 20000, 28);
        employeesArray[1] = new Employee("Ivsnov Vasya", "sale", "aa@a.ru", "89002009091", 20000, 41);
        employeesArray[2] = new Employee("Petrov Vasya", "builder", "aaa@a.ru", "89002009092", 50000, 46);
        employeesArray[3] = new Employee("Petrov Nickolay", "builder", "aaaa@a.ru", "89002009022", 50000, 22);
        employeesArray[4] = new Employee("Sidorov Nickolay", "programmer", "aaaaa@a.ru", "89002009026", 550000, 19);

        for (int i = 0; i < employeesArray.length ; i++) {
            if (employeesArray[i].age > 40) {
                employeesArray[i].info();
            }
        }
    }
}

class Employee {
    String fio;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void info() {
        System.out.println("ФИО " + fio + "; Должность " + position + "; Email " + email + "; Телефон " + phone + "; Зарплата " + salary + "; Возраст " + age);
    }
}
