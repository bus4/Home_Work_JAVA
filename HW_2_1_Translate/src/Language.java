/**
 * Created by Альберт on 21.10.2016.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

/**
 * вызываем метод выбора языка. Пользователь вводит имя файла.
 * Если файла нет, то ловим exeption
 * метод собирает данные из файла и складывает в MAP   HashMap
 * выдает слова и проверяет правильно ли перевел пользователь
 * сохраняет статистику. Осваиваем структуры данных !!
 * выход по кодовым словам
 * При выходе вывод статистики.  +++ Сохранить в файл по желанию.
 * java. IO
 * Лямбды можно использовать.
 * switch case тоже
 */

public class Language {


    public static int choseLanguage() throws IOException {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = new String(reader.readLine());
            if (fileName.equals("esc")) return 0;
            String fileAddress = "C:\\Users\\Альберт\\IdeaProjects\\Proper\\src\\" + fileName + ".properties";
            //   String fileAddress = "C:\\Users\\Альберт\\IdeaProjects\\Proper\\src\\English.properties";
            Properties property = new Properties();

            FileReader fr = new FileReader(fileAddress);
            property.load(fr);

            HashMap<String, String> haMap = new HashMap<String, String>();
            ArrayList<String> arList = new ArrayList<String>();

            for (final String name : property.stringPropertyNames())
                haMap.put(name, property.getProperty(name));

            for (final String name : property.stringPropertyNames())
                arList.add(name);

            Random rand = new Random();
            int m = arList.size();
            double rigT = 0;
            double notRigT = 0;
            String rezult;
            String ke;
            System.out.println("Вводите перевод слов. Для завершения введите esc. ");

            for (int i = 0; i < m; i++) {
                int pozOld = rand.nextInt(arList.size());
                System.out.println(arList.get(pozOld));

                String answer = new String(reader.readLine());
                if (answer.equals("esc")) {
                    i = m + 1;
                } else if (answer.equals(haMap.get(arList.get(pozOld)))) {
                    rezult = "Правильно";
                    rigT++;
                    System.out.println(rezult);
                    System.out.println();
                } else {
                    rezult = "Не Правильно";
                    notRigT++;
                    System.out.println(rezult + " - " + haMap.get(arList.get(pozOld)));
                    System.out.println();
                }

                arList.remove(pozOld);
            }
            double r = (rigT / (rigT + notRigT)) * 100;
            if (Double.isNaN(r)) r = 0;
            System.out.println("Вы правильно ответили на " + rigT + " вопросов, что составило " + r + " %");

        } catch (IOException e) {
            System.out.println("Неправильное название файла. Попробуйте еще раз, либо для завершения введите esc");
            return 1;
        }
        return 0;
    }

}
