import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class JFrameTest
{
    public static void createGUI()
    {

        try {
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



        // Данные для таблицы Остатки
        ArrayList<String[]> arList = stock.showRemnants(connection);

        Object[][] array = new String[arList.size()][3];
        for (int i = 0; i < arList.size() ; i++) {
            array [i] = arList.get(i);
        }
        // Заголовки столбцов Остатки
        Object[] columnsHeader = new String[] {"Склад", "Модель",
                "Количество"};



        // Данные для таблицы Склады
        ArrayList<String[]> arListStocks = stock.showStocs(connection);

        Object[][] arrayStocks = new String[arListStocks.size()][3];
        for (int i = 0; i < arListStocks.size() ; i++) {
            arrayStocks [i] = arListStocks.get(i);
        }
        // Заголовки столбцов Склады
        Object[] columnsHeaderStocks = new String[] {"Имя Склада", "Адрес",
                "Емкость"};



        // Данные для таблицы Товары
        ArrayList<String[]> arListGoods = stock.showGoods(connection);

        Object[][] arrayGoods = new String[arListGoods.size()][3];
        for (int i = 0; i < arListGoods.size() ; i++) {
            arrayGoods [i] = arListGoods.get(i);
        }
        // Заголовки столбцов Склады
        Object[] columnsHeaderGoods = new String[] {"Вид Товара", "Производитель",
                "Модель", "Объем", "Вес"};


        JFrame frame = new JFrame("Stock managment app");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.PLAIN, 12);
        Font font2 = new Font("Verdana", Font.PLAIN, 10);

        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(font);


        JTable tablRem = new JTable(array, columnsHeader);
        JTable tablRemStocks = new JTable(arrayStocks, columnsHeaderStocks);
        JTable tablRemGoods = new JTable(arrayGoods, columnsHeaderGoods);

     //  JPanel mp = new JPanel(tablRemGoods);
        JScrollPane sp = new JScrollPane(tablRemStocks);
     //   mp.setLayout(new BorderLayout());
      //  mp.add(tablRemGoods);
       // mp.setSize(1024,1000);
       // mp.setVisible(true);
//        sp.add(tablRemStocks, ScrollPaneLayout.VERTICAL_SCROLLBAR);

        tabbedPane.add("Остатки Товаров" , new JScrollPane(tablRem));
        tabbedPane.add("Список Складов" , sp);
        tabbedPane.add("Номенклатура Товаров" , new JScrollPane(tablRemGoods));

        System.out.println(tabbedPane.getTabComponentAt(0));



        JButton butt = new JButton("Добавить Склад");
        butt.setFont(font2);
        butt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.addTab("Вкладка ", new JPanel());
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(butt);


        JTextField tf1 = new JTextField("Название Склада");
        tf1.setFont(font2);
        tf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.addTab("Вкладка ", new JPanel());
            }
        });

        JPanel textF = new JPanel();
        textF.add(tf1);





        frame.add(buttons, BorderLayout.SOUTH);
        frame.add(tabbedPane, BorderLayout.NORTH);
        frame.add(textF, BorderLayout.CENTER);
        tabbedPane.setVisible(true);
    //    frame.setPreferredSize(new Dimension(1024, 768));
        frame.setLocation(100,50);
        frame.pack();
        frame.setVisible(true);


        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}