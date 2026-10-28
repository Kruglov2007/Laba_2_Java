import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Formula extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 450;
    private Double sum = 0.0;
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    private JTextField textFieldResult;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hboxVariables = Box.createHorizontalBox();
    // Идентификатор выбранной формулы
    private int formulaId = 1;
    // Формула №1 для рассчѐта
    public Double calculate1(Double x, Double y, Double z) {
        // (sin y + y^2 + e^(cos y))
        double base1 = Math.sin(y) + y * y + Math.exp(Math.cos(y));

        // (ln(z^2) + sin(pi * x^2))
        double base2 = Math.log(z * z) + Math.sin(Math.PI * x * x);

        // Квадратный корень из (base1^2 + base2^3)
        return Math.sqrt(Math.pow(base1, 2) + Math.pow(base2, 3));
    }
    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y, Double z) {
        // 3 * z^x
        double numerator = 3 * Math.pow(z, x);

        // sqrt(1 + y^3)
        double denominator = Math.sqrt(1 + Math.pow(y, 3));

        // sqrt(y) * (числитель / знаменатель)
        return Math.sqrt(y) * (numerator / denominator);
    }
    // buttonName – текст рядом с кнопкой, formulaId – идентификатор формулы
    private void addRadioButton(String buttonName, final int formulaId) {
// Создать экземпляр радио-кнопки с заданным текстом
        JRadioButton button = new JRadioButton(buttonName);
// Определить и зарегистрировать обработчик
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                // Который будет устанавливать идентификатор выбранной
// формулы в классе Formula равным formulaId
                Formula.this.formulaId = formulaId;
            }
        });
// Добавить радио-кнопку в группу
        radioButtons.add(button);
// Добавить радио-кнопку в контейнер
// Для этого ссылка на контейнер сделана полем данных класса
        hboxFormulaType.add(button);
    }
   Formula(){
       super("Вычисление формулы");
       setSize(WIDTH, HEIGHT);
       Toolkit kit = Toolkit.getDefaultToolkit();
       // Центрировать окно приложения на экране
       setLocation((kit.getScreenSize().width - WIDTH)/2,
               (kit.getScreenSize().height - HEIGHT)/2);
       // Добавить «клей» C1-H1 с левой стороны
       hboxFormulaType.add(Box.createHorizontalGlue());
// Создать радио-кнопку для формулы 1
       addRadioButton("Формула 1", 1);
// Создать радио-кнопку для формулы 2
       addRadioButton("Формула 2", 2);
// Установить выделенной 1-ую кнопку из группы
       radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
// Добавить «клей» C1-H2 с правой стороны
       hboxFormulaType.add(Box.createHorizontalGlue());
// Задать рамку для коробки с помощью класса BorderFactory
       hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
       // Создать подпись “X:” для переменной X
       JLabel labelForX = new JLabel("X:");
// Создать текстовое поле для ввода значения переменной X,
// (по умолчанию 0)
       textFieldX = new JTextField("0", 10);
// Установить макс размер = желаемому для предотвращения масштабирования
       textFieldX.setMaximumSize(textFieldX.getPreferredSize());
// Создать подпись “Y:” для переменной Y
       JLabel labelForY = new JLabel("Y:");
// Создать текстовое поле для ввода значения переменной Y,
// (по умолчанию 0)
       textFieldY = new JTextField("0", 10);
// Установить макс размер = желаемому для предотвращения масштабирования
       textFieldY.setMaximumSize(textFieldY.getPreferredSize());
// Создать контейнер «коробка с горизонтальной укладкой»
// Задать рамку для коробки с помощью класса BorderFactory
       hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
// Добавить в контейнер ряд объектов:
// Добавить «клей» C2-H1 – для максимального удаления от левого края
       hboxVariables.add(Box.createHorizontalGlue());



       // Создать подпись “Y:” для переменной Y
       JLabel labelForZ = new JLabel("Z:");
// Создать текстовое поле для ввода значения переменной Y,
// (по умолчанию 0)
       textFieldZ = new JTextField("0", 10);
// Установить макс размер = желаемому для предотвращения масштабирования
       textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());



// Добавить подпись для переменной Х
       hboxVariables.add(labelForX);
// Добавить «распорку» C2-H2 шириной 10 пикселов для отступа между
// надписью и текстовым полем для ввода значения X
       hboxVariables.add(Box.createHorizontalStrut(10));
// Добавить само текстовое поле для ввода Х
       hboxVariables.add(textFieldX);
// Добавить «распорку» C2-H3 шириной 100 пикселов для отступа между
// текстовым полем для ввода X и подписью для Y
       hboxVariables.add(Box.createHorizontalStrut(60));
// Добавить подпись для переменной Y
       hboxVariables.add(labelForY);
       // Добавить «распорку» C2-H4 шириной 10 пикселов для отступа между
       // надписью и текстовым полем для ввода значения Y
       hboxVariables.add(Box.createHorizontalStrut(10));
// Добавить само текстовое поле для ввода Y
       hboxVariables.add(textFieldY);
       hboxVariables.add(Box.createHorizontalStrut(60));


       // Добавить подпись для переменной Z
       hboxVariables.add(labelForZ);
// Добавить «распорку» C2-H2 шириной 10 пикселов для отступа между
// надписью и текстовым полем для ввода значения X
       hboxVariables.add(Box.createHorizontalStrut(10));
// Добавить само текстовое поле для ввода Х
       hboxVariables.add(textFieldZ);



// Добавить «клей» C2-H5 для максимального удаления от правого края
       hboxVariables.add(Box.createHorizontalGlue());
       // Создать подпись для поля с результатом
       JLabel labelForResult = new JLabel("Результат:");
// Создать текстовое поле для вывода результата, начальное значение - 0
       textFieldResult = new JTextField("0", 15);
       textFieldResult.setEditable(false);
// Создать контейнер «коробка с горизонтальной укладкой»
       Box hboxResult = Box.createHorizontalBox();
// Добавить в контейнер ряд объектов
// Добавить «клей» C3-H1 для отступа от левого края
       hboxResult.add(Box.createHorizontalGlue());
// Добавить подпись для результата
       hboxResult.add(labelForResult);
// Добавить «распорку» C3-H2 в 10 пикселов между подписью и полем
// результата
       hboxResult.add(Box.createHorizontalStrut(10));
// Добавить текстовое поле для вывода результата
       hboxResult.add(textFieldResult);
// Добавить «клей» C3-H3 справа
       hboxResult.add(Box.createHorizontalGlue());
// Задать рамку для контейнера
       hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
       // Создать кнопку «Вычислить»
       JButton buttonCalc = new JButton("Вычислить");
// Определить и зарегистрировать обработчик нажатия на кнопку
       buttonCalc.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ev) {
// Преобразование введенных строк в числа с плавающей точкой может
// спровоцировать исключительную ситуацию при неправильном формате чисел,
// поэтому необходим блок try-catch
               try {
// Получить значение X
                   Double x = Double.parseDouble(textFieldX.getText());
// Получить значение Y
                   Double y = Double.parseDouble(textFieldY.getText());
                   Double z=Double.parseDouble(textFieldZ.getText());
                   Double result;
// Вычислить результат
                   if (formulaId==1)
                       result = calculate1(x, y, z);
                   else
                       result = calculate2(x, y, z);
                   if (result.isNaN() || result.isInfinite()) {
                       throw new ArithmeticException("Недопустимые значения переменных (деление на 0 или некорректный корень/логарифм)!");
                   }
                   // Установить текст надписи равным результату
                   textFieldResult.setText(result.toString());
               } catch (NumberFormatException ex) {
// В случае исключительной ситуации показать сообщение
                   JOptionPane.showMessageDialog(Formula.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                           JOptionPane.WARNING_MESSAGE);
               } catch (ArithmeticException ex) { // ИСПРАВЛЕНО: Добавлен перехват сгенерированного исключения
                   JOptionPane.showMessageDialog(Formula.this, ex.getMessage(), "Математическая ошибка",
                           JOptionPane.ERROR_MESSAGE);
               }
           }
       });
       // Создать кнопку «Очистить поля»
       JButton buttonReset = new JButton("Очистить поля");
// Определить и зарегистрировать обработчик нажатия на кнопку
       buttonReset.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ev) {
               textFieldX.setText("0");
               textFieldY.setText("0");
               textFieldZ.setText("0");
               textFieldResult.setText("0");
           }
       });
       // Создать коробку с горизонтальной укладкой
       Box hboxButtons = Box.createHorizontalBox();
// Добавить «клей» C4-H1 с левой стороны
       hboxButtons.add(Box.createHorizontalGlue());
// Добавить кнопку «Вычислить» в компоновку
       hboxButtons.add(buttonCalc);
// Добавить распорку в 30 пикселов C4-H2 между кнопками
       hboxButtons.add(Box.createHorizontalStrut(30));
// Добавить кнопку «Очистить поля» в компоновку
       hboxButtons.add(buttonReset);
// Добавить «клей» C4-H3 с правой стороны
       hboxButtons.add(Box.createHorizontalGlue());
       // --- ДОБАВЛЕНИЕ КНОПОК ПАМЯТИ «MC» и «M+» (Пункт б) ---
       JButton buttonMC = new JButton("MC");
       buttonMC.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               sum = 0.0;
               textFieldResult.setText("0");
           }
       });
       JButton buttonMPlus = new JButton("M+");
       buttonMPlus.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               try {
                   Double currentResult = Double.parseDouble(textFieldResult.getText());
                   sum += currentResult;
                   textFieldResult.setText(sum.toString());
               } catch (NumberFormatException ex) {
                   JOptionPane.showMessageDialog(Formula.this, "В поле результата нет корректного числа!", "Ошибка памяти",
                           JOptionPane.ERROR_MESSAGE);
               }
           }
       });
       // Создаем горизонтальный контейнер для кнопок памяти
       Box hboxMemoryButtons = Box.createHorizontalBox();
       hboxMemoryButtons.add(Box.createHorizontalGlue());
       hboxMemoryButtons.add(buttonMC);
       hboxMemoryButtons.add(Box.createHorizontalStrut(30));
       hboxMemoryButtons.add(buttonMPlus);
       hboxMemoryButtons.add(Box.createHorizontalGlue());
       hboxMemoryButtons.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));

// Задать рамку для контейнера
       hboxButtons.setBorder(BorderFactory.createLineBorder(Color.GREEN));
       // Создать контейнер «коробка с вертикальной укладкой»
       Box contentBox = Box.createVerticalBox();
// Добавить «клей» V1 сверху
       contentBox.add(Box.createVerticalGlue());
// Добавить контейнер с выбором формулы
       contentBox.add(hboxFormulaType);
// Добавить контейнер с переменными
       contentBox.add(hboxVariables);
// Добавить контейнер с результатом вычислений
       contentBox.add(hboxResult);
// Добавить контейнер с кнопками
       contentBox.add(hboxButtons);
       contentBox.add(Box.createVerticalStrut(10));
       contentBox.add(hboxMemoryButtons);
// Добавить «клей» V2 снизу
       contentBox.add(Box.createVerticalGlue());

// Установить «вертикальную коробку» в область содержания главного окна
       getContentPane().add(contentBox, BorderLayout.CENTER);

   }




}


