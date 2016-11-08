/**
 * Created by Альберт on 21.10.2016.
 */

import java.io.IOException;


public class Proper {

    public static void main(String[] args) throws IOException {


        System.out.println("Введите название файла с языком для тестирования");

        while (Language.choseLanguage() == 1) {
            Language.choseLanguage();
        }


    }
}
