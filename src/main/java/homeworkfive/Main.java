package homeworkfive;

public class Main {
    public static void main(String[] args) {


        Person[] persons = new Person[5];
        persons[0] = new Person("Семен Семеныч", "Прораб","Sem@mail.ru",89991112222L,500000,43);
        persons[1] = new Person("Иван Иваныч", "Маляр","IV@mail.ru",89991112223L,400000,21);
        persons[2] = new Person("Сан Саныч", "Штукатур","San@mail.ru",89991112224L,300000,35);
        persons[3] = new Person("Петр Петрович", "Плотник","Pet@mail.ru",89991112225L,200000,56);
        persons[4] = new Person("Пал Палыч", "Сантехник","Paul@mail.ru",89991112226L,100000,19);

        for (Person pers: persons
             ) {
            if (pers.getAge() > 40){
                pers.info();
            }
        }
    }
}
