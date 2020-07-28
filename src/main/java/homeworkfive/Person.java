package homeworkfive;

public class Person {
    private String fio;
    private String position;
    private String email;
    private long phone;
    private int zp;
    private int age;

    public Person (String fio, String position, String email, long phone, int zp, int age){
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.zp = zp;
        this.age = age;
    }

    void info () {
        System.out.println("Сотрудник: " + fio +
                "\nДолжность: " + position +
                "\nEmail: " + email +
                "\nТелефон: " + phone +
                "\nЗарплата: " + zp +
                "\nВозраст: " + age +
                '\n');
    }

    public int getAge() {
        return age;
    }
}
