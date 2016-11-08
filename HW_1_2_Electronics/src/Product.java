/**
 * Created by Альберт on 20.10.2016.
 */
public abstract class Product {

    private String name;
    private int price;
    private int weight;
    private String colour;
    private int id;

    public static int count = 0;  // добавить счетчик

    //добавить конструкторы
    public Product(String name, int p, int w, String colour) {
        this.name = name;
        price = p;
        weight = w;
        this.colour = colour;
        id = count;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

    public int getId() {
        return id;
    }


    // добавить методы get и set


}
