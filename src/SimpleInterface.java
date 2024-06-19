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
                addWindow newWindow = new addWindow();
                newWindow.setVisible(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeWindow changeWindow = new changeWindow();
                changeWindow.setVisible(true);
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

//Экран добавить
class addWindow extends JFrame{
    public addWindow () {
        setTitle("Добавить");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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