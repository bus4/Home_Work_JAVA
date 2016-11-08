import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Альберт on 31.10.2016.
 */
public class goods {

    //Создание новой товарной позиции
    public static void addGoods(Connection connection) {

        String insertTableSQL = "INSERT INTO public.goods (model, size, weight, type, manufacturer) VALUES ('Z200', '1.5', '40', 'Fridge', 'Indezit')";

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate(insertTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Удаление товарной позиции
    public static void delGoods(Connection connection) {

        String deleteTableSQL = "DELETE FROM public.goods WHERE (id='4')";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute(deleteTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Приход товара на склад. Надо проверять наличие ID!!!! Метод не доделан!!!
    public static void incomeGoods(Connection connection) {

        String insertTableSQL = "INSERT INTO public.remnants (stock_id, goods_id, remnants) VALUES ('1', '3', '40')";

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate(insertTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Расход товара со склада

    //Перемещение товара на другой склад



}
