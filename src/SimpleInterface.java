import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class SimpleInterface extends JFrame {






    public SimpleInterface() {
        setTitle("Программа");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Создание кнопок
        JButton button1 = new JButton("Добавить");
        JButton button2 = new JButton("Изменить/удалить");
        JButton button3 = new JButton("Поиск");
        JButton button4 = new JButton("Отчёт");

        // Добавление кнопок на окно
        add(button1);
        add(button2);
        add(button3);
        add(button4);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWindow addWindow = new addWindow();
                addWindow.setVisible(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeWindow changeWindow = new changeWindow();
                changeWindow.setVisible(true);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWindow showWindow = new showWindow();
                showWindow.setVisible(true);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportWindow reportWindow = new reportWindow();
                reportWindow.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            SimpleInterface si = new SimpleInterface();
            si.setVisible(true);
        });
    }
}

class addWindow extends JFrame {

    private static final String url = "jdbc:mysql://localhost:3306/sys";
    private static final String user = "root";
    private static final String password = "Gfhjkm00!2";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    private JTextField categoryField;
    private JTextField brandField;
    private JTextField nameField;
    private JTextField serialNumberField;
    private JTextField descriptionField;
    private JTextField marketPriceField;
    private JTextField purchasePriceField;

    public addWindow() {

        setTitle("Добавить");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));


        // Добавление меток и текстовых полей
        add(new JLabel("Категория:"));
        categoryField = new JTextField();
        add(categoryField);

        add(new JLabel("Брэнд:"));
        brandField = new JTextField();
        add(brandField);

        add(new JLabel("Название:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Серийный номер:"));
        serialNumberField = new JTextField();
        add(serialNumberField);

        add(new JLabel("Описание:"));
        descriptionField = new JTextField();
        add(descriptionField);

        add(new JLabel("Рыночная цена:"));
        marketPriceField = new JTextField();
        add(marketPriceField);

        add(new JLabel("Закупочная цена:"));
        purchasePriceField = new JTextField();
        add(purchasePriceField);

        //Кнопка Изменить
        JButton updateButton = new JButton("Добавить");
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String category = categoryField.getText();
                String brand = brandField.getText();
                String name = nameField.getText();
                String serialNumber = serialNumberField.getText();
                String description = descriptionField.getText();
                double marketPrice = Double.parseDouble(marketPriceField.getText());
                double purchasePrice = Double.parseDouble(purchasePriceField.getText());

                if (description.isEmpty()){
                    description = "NULL";
                }

                System.out.println("Категория: " + category);
                System.out.println("Брэнд: " + brand);
                System.out.println("Название: " + name);
                System.out.println("Серийный номер: " + serialNumber);
                System.out.println("Описание: " + description);
                System.out.println("Рыночная цена: " + marketPrice);
                System.out.println("Закупочная цена: " + purchasePrice);

                String query = "INSERT INTO Equipment (Category, Line, Title, SerialNumber, `Description`, MarketPrice, PurchasePrice)" +
                        "VALUES (" +
                        category + ", " +
                        brand + ", " +
                        name + ", " +
                        serialNumber + ", " +
                        description + ", " +
                        marketPrice + ", " +
                        purchasePrice +
                        ")";



                try {
                    // opening database connection to MySQL server
                    con = DriverManager.getConnection(url, user, password);

                    // getting Statement object to execute query
                    stmt = con.createStatement();

                    // executing SELECT query
                    stmt.executeQuery(query);


                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                } finally {
                    //close connection ,stmt and resultset here
                    try { con.close(); } catch(SQLException se) { /*can't do anything */ }
                    try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
                    try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
                }


            }
        });
    }
}

//Экран изменить обновить
class changeWindow extends JFrame {
    public changeWindow (){
        setTitle("Изменить");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

//экран простмотра
class showWindow extends JFrame {
    public showWindow (){
        setTitle("Просмотр");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

//Экран отчётов
class reportWindow extends JFrame {
    public reportWindow (){
        setTitle("Отчёты");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
