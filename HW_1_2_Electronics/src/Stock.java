/**
 * Created by Альберт on 20.10.2016.
 */
public abstract class Stock {

    // добавить массив
    public static Product[] arr = new Product[100];

    // добавить счетчик заполнения массива
    public static int stockCount = 0;  // добавить счетчик склада

    // метод добавления продукта TV на склад
    public static void addTV(String name, int p, int w, String colour, int diagonal) {
        TV tv = new TV(name, p, w, colour, diagonal);
        arr[stockCount] = tv;
        stockCount++;
    }

    // метод добавления продукта Washer на склад
    public static void addWasher(String name, int p, int w, String colour, int revolutions) {
        Washer ws = new Washer(name, p, w, colour, revolutions);
        arr[stockCount] = ws;
        stockCount++;
    }

    // метод добавления продукта Washer на склад
    public static void addFridge(String name, int p, int w, String colour, int size) {
        Fridge fr = new Fridge(name, p, w, colour, size);
        arr[stockCount] = fr;
        stockCount++;
    }

    // метод убрать продукт со склада по номеру
    public static void remove(int number) {
        arr[number - 1] = null;

    }

    // метод получить список
    public static void stockList() {
        System.out.println();
        System.out.println("Список товаров на складе: ");
        for (int jj = 0; jj < stockCount; jj++) {
            if (arr[jj] != null) {
                System.out.println("№" + (jj + 1) + " " + arr[jj].getClass() + " " + arr[jj].getName());
            } else {
                System.out.println("№" + (jj + 1) + " удален ");
            }
        }
    }

    // метод количества товаров
    public static void stockCoun() {
        System.out.println();
        System.out.println("Количество товаров на складе: " + stockCount);
    }

    // метод среднего веса всех товаров
    public static void stockWeight() {
        System.out.println();
        int wSum = 0;
        for (int jj = 0; jj < stockCount; jj++) {
            wSum = wSum + arr[jj].getWeight();
        }

        System.out.println("Средний вес товаров на складе: " + wSum / stockCount + " кг");
    }

    // метод получения статистики по цветам товаров (например "красный - 1шт, синий - 2шт")
    public static void stockoClours() {
        int numberOfColurs = 0;
        String[] coloursOf = new String[stockCount];

        System.out.println();
        for (int jj = 0; jj < stockCount; jj++) {
            String actualColour = arr[jj].getColour();

            int actualColourNum = 0;
            //проверяем был ли Был true не был false
            Boolean t = false;
            for (int i = 0; i < numberOfColurs; i++) {
                if (coloursOf[i] == actualColour) {
                    t = true;
                }
            }
            // считаем сколько его
            if (t == false) {
                actualColourNum = 1;

                for (int ii = jj + 1; ii < stockCount; ii++) {
                    if (arr[ii].getColour() == actualColour) {
                        actualColourNum = actualColourNum + 1;

                        coloursOf[numberOfColurs] = actualColour;
                        numberOfColurs = numberOfColurs + 1;
                    }
                }
                System.out.println(actualColour + " " + actualColourNum + " шт.");
            }

        }
    }


}
