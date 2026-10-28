import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.*;

public class Main {
    public static void main(String[] args){
        // Конструируем экземпляр фрейма
        Formula frame = new Formula();
        // Задаём реакцию на нажатие кнопки закрытия фрейма
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}