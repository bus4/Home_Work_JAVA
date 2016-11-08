/**
 * Created by Альберт on 20.10.2016.
 */
public class TV extends Product {

    private int diagonal;

    public TV(String name, int p, int w, String colour, int diagonal) {
        super(name, p, w, colour);
        this.diagonal = diagonal;
    }
    // добавить уникальное свойство Диагональ

}
