/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 12-Mar-2010
 * Time: 21:55:31
 * To change this template use File | Settings | File Templates.
 */
public class Product {

    private String itemName;
    private double price;

    public Product(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;

    }

    public String getItemName() {

        return itemName;
    }

    public double getPrice() {

        return price;

    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {

        return itemName + "-  " + price;
    }
}
