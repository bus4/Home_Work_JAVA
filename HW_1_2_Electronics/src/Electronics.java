/**
 * Created by Альберт on 20.10.2016.
 */
public class Electronics {


    public static void main(String[] args) {

        // добавляем неколько товаров переделать в вызов метода
        Stock.addTV("Philips", 26000, 17, "Gray", 40);
        Stock.addTV("Sony", 31000, 19, "Black", 40);
        Stock.addWasher("LG", 17000, 25, "White", 1200);
        Stock.addFridge("Indezit", 15000, 60, "White", 350);


        // вызываем список и другие методы склада
        Stock.stockList();
        Stock.stockCoun();
        Stock.stockWeight();
        Stock.stockoClours();
        // удаляем один товар по номеру !!!
        //    Stock.remove (2);

        // вызываем список и другие методы склада
        //     Stock.stockList ();

    }
}
