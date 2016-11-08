import javax.swing.*;

/**
 * Created by Альберт on 31.10.2016.
 */
public class ElectPostgreSQL {

    public static void main(String[] args) {

     /*   try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "admin");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

*/


       // stock.showStocs(connection);
      //  stock.addStocs(connection);
      //  stock.delStocs(connection);
       // stock.showStocs(connection);
     //   stock.showRemnants(connection);
    //    goods.delGoods(connection);
        //stock.showRemnants(connection);
   //     ArrayList<ArrayList> arList = stock.showRemnants(connection);

        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameTest.createGUI();
            }
        });


     //   ArrayList raylist = new ArrayList();


     /*   try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/

    }
}
