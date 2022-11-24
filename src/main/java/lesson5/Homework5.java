package lesson5;

public class Homework5 {
    public static void main(String[] args) {

        Employee[] arr = new Employee[5]; //
        arr[0] = new Employee("Иванов Иван Иванович", "менеджер", "ivanov@gmail.com","+79219219099", 75000,45);
        arr[1] = new Employee("Кузнецов Святогор Игнатьевич", "менеджер", "kyzia@gmail.com", "+79008876565", 65000, 35);
        arr[2] = new Employee("Матвеев Евстигней Робертович", "менеджер по подбору персонала", "vstigney@ya.ru", "+79636333636", 50000, 28);
        arr[3] = new Employee("Любимова Ульяна Давыдовна", "директор", "super@mail.com", "+79895444547", 150000, 45);
        arr[4] = new Employee("Трубочкин Петр Аристархович", "замдиректора", "truba@mail.com", "+79205865254", 80000, 40);

        for (Employee employee : arr) {
            if (employee.getAge() >= 40) {
                employee.info();
            }
        }
    }
}
