import java.util.ArrayList;

/**
 * Created by Альберт on 04.11.2016.
 */
public class main {

    public static void main(String[] args) {

        MyArrayList hz = new MyArrayList();

        //  hz.add("Привет");
        //  System.out.println(hz.size());
        //   System.out.println(hz.get(0));
        for (int i = 0; i < 100; i++) {
            hz.add(i);
            System.out.println(hz.get(i));
        }
        System.out.println();

        System.out.println("Размер листа = " + hz.size());
        System.out.println();
        //     hz.remove(5);
        hz.add(95, 55555);

        for (int i = 0; i < hz.size(); i++) {
            System.out.println(hz.get(i));
        }
        System.out.println();
        System.out.println("Размер листа = " + hz.size());
        System.out.println(hz.get(95));


        new Thread(() -> {
            int ii = 0;
            while (ii < 1000) {
                hz.add(4, 55555);
                //  hz.remove(5);
                ii++;
            }
            System.out.println("Finish 1");
            System.out.println("Размер листа = " + hz.size());

        }).start();

        new Thread(() -> {
            int i = 0;
            while (i < 1000) {
                //   hz.add(95, 55555);
                if (hz.size() > 5) {
                    hz.remove(5);
                }
                i++;
            }
            System.out.println("Finish 2");
            System.out.println("Размер листа = " + hz.size());

        }).start();


    }
}
