import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Альберт on 31.10.2016.
 */
public class stock {

    //Показать список складов
    public static ArrayList showStocs(Connection connection) {
        String selectTableSQL = "SELECT ID, NAME, ADDRESS, CAPACITY from STOCKS";
        ArrayList<String[]> arList = new ArrayList<>();

        try {
            //Connection dbConnection = connection;
            Statement statement = null;
            statement = connection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает

            while (rs.next()) {

                String[] inArList = new String[3];

                inArList[0] = rs.getString("name");
                inArList[1] = rs.getString("ADDRESS");
                inArList[2] = rs.getString("CAPACITY");
                arList.add(inArList);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arList;
    }

    //Показать список товаров
    public static ArrayList showGoods(Connection connection) {
        String selectTableSQL = "SELECT ID, MODEL, SIZE, WEIGHT,TYPE, MANUFACTURER from GOODS";
        ArrayList<String[]> arList = new ArrayList<>();

        try {
            //Connection dbConnection = connection;
            Statement statement = null;
            statement = connection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает

            while (rs.next()) {

                String[] inArList = new String[5];
                inArList[0] = rs.getString("TYPE");
                inArList[1] = rs.getString("MANUFACTURER");
                inArList[2] = rs.getString("MODEL");
                inArList[3] = rs.getString("SIZE");
                inArList[4] = rs.getString("WEIGHT");
                arList.add(inArList);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arList;
    }


    //Добавить новый склад
    public static void addStocs(Connection connection) {

        String insertTableSQL = "INSERT INTO public.stocks (name, address, capacity) VALUES ('Восточный', 'Мамадыш', '10000')";

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

    //Удалить склад. С переносом остатков в другой склад??
    public static void delStocs(Connection connection) {

        String deleteTableSQL = "DELETE FROM public.stocks WHERE (id='3')";
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

    //Выдать список товаров на складе
    public static void showRemnantsStock(Connection connection) {
        String selectTableSQL = "SELECT name,model,REMNANTS from remnants, stocks, goods  WHERE stock_id=stocks.id AND goods_id=goods.id AND stock_id = 2";
        //String selectTableSQL = "SELECT NAME,MODEL,REMNANTS from remnants, stocks, goods WHERE stock_id=stocks.id, goods_id=goods.id;";

        try {
            //Connection dbConnection = connection;
            Statement statement = null;
            statement = connection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);
            //ResultSet rs = statement.

            // И если что то было получено то цикл while сработает
            System.out.println("Remnants:");

            while (rs.next()) {
                //  String name = rs.getString("NAME");
                //  String model = rs.getString("MODEL");
                String name = rs.getString("name");
                String model = rs.getString("model");
                String remnants = rs.getString("REMNANTS");

                System.out.println("Stock : " + name + " / Model : " + model + " / Remnants : " + remnants);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //Выдать список товаров на всех складах
    public static ArrayList showRemnants(Connection connection) {
        String selectTableSQL = "SELECT name,model,REMNANTS from remnants, stocks, goods  WHERE stock_id=stocks.id AND goods_id=goods.id";

        ArrayList<String[]> arList = new ArrayList<>();


        try {
            //Connection dbConnection = connection;
            Statement statement = null;
            statement = connection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает

            while (rs.next()) {
                String[] inArList = new String[3];

                inArList[0] = rs.getString("name");
                inArList[1] = rs.getString("model");
                inArList[2] = rs.getString("REMNANTS");
                arList.add(inArList);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arList;

    }


}
