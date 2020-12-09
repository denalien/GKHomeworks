package partthree.lesson1;

public class Apple extends Fruit{

    public Apple() {
        super.weightOfOne = 1.0f;
    }

    @Override
    public float getWeightOfOne() {
        return super.getWeightOfOne();
    }
}
