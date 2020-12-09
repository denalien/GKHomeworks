package parttwo.homeworkthree;

public class Start {
    public static void main(String[] args) {
        ContactList phoneBook = new ContactList();
        phoneBook.add(11111111111L,"Vasyli4");
        phoneBook.add(22222222222L,"Vasyli4");
        phoneBook.add(33333333333L,"Semeni4");

        System.out.println(phoneBook.get("Vasyli4"));
        System.out.println(phoneBook.get("Semeni4"));
    }
}
