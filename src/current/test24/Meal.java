package current.test24;

/**
 * Created by stormaroon on 16-10-5.
 */
public class Meal {

    private int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal(" + orderNum + ")";
    }

}
