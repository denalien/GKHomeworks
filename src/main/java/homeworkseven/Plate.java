package homeworkseven;

public class Plate {

    private int maxVolume;
    private int quantity;

    public Plate(int maxVolume) {
        this.maxVolume = maxVolume;
        System.out.println("Вы покупаете новую миску, думая, что теперь-то наверняка хватит на день.");
    }

    void refill(){
        quantity = maxVolume;
        System.out.println("Вы насыпаете корма в миску доверха.");
    }
    void lookAtPlate() {
        System.out.println("Вы смотрите на миску.");
        if (quantity > 0){
            System.out.println("Похоже там еще " + quantity + " корма.");
        } else {
            System.out.println("Миска пуста.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
