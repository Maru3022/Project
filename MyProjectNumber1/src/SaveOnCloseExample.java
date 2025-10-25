import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveOnCloseExample {

    // Main program that shows a window and saves data on close
    // Основная программа, которая показывает окно и сохраняет данные при закрытии
    public static void main(String[] args) {
        // This list holds data during program runtime
        // Этот список хранит данные во время работы программы
        List<String> dataList = new ArrayList<>();

        // Adds sample data to the list for demonstration
        // Добавляет пример данных в список для демонстрации
        dataList.add("Первая строка в списке");
        dataList.add("Вторая строка");
        dataList.add("Что-то еще...");

        // Creates the main application window
        // Создаёт главное окно приложения
        JFrame frame = new JFrame("Пример сохранения при выходе");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null); // Centers window on screen
        // Окно по центру экрана

        // Creates input field and button to add items to the list
        // Создаёт поле ввода и кнопку для добавления элементов в список
        JTextField inputField = new JTextField();
        JButton addButton = new JButton("Добавить в список");
        addButton.addActionListener(e -> {
            String text = inputField.getText();
            if (!text.isEmpty()) {
                dataList.add(text);
                inputField.setText("");
                System.out.println("Добавлено: " + text);
                System.out.println("Всего в списке: " + dataList.size());
            }
        });

        // Arranges UI components in a panel
        // Размещает элементы интерфейса на панели
        JPanel panel = new JPanel();
        panel.add(new JLabel("Введите текст:"));
        panel.add(inputField);
        panel.add(addButton);
        frame.add(panel);

        // Disables default window closing behavior
        // Отключает стандартное поведение при закрытии окна
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Adds a listener to handle window closing event
        // Добавляет обработчик события закрытия окна
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Shows confirmation dialog before exit
                // Показывает диалог подтверждения перед выходом
                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Хотите сохранить список в файл перед выходом?",
                        "Подтверждение выхода",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                // Handles user's choice from the dialog
                // Обрабатывает выбор пользователя в диалоге
                if (result == JOptionPane.YES_OPTION) {
                    saveListToFile(dataList);
                    frame.dispose();
                    System.exit(0);
                } else if (result == JOptionPane.NO_OPTION) {
                    frame.dispose();
                    System.exit(0);
                }
                // If user cancels, do nothing and stay in app
                // Если пользователь отменил — ничего не делаем, остаёмся в программе
            }
        });

        // Makes the window visible to the user
        // Делает окно видимым для пользователя
        frame.setVisible(true);
    }

    // Saves the list of strings to a text file
    // Сохраняет список строк в текстовый файл
    private static void saveListToFile(List<String> list) {
        String filename = "saved_list.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("--- Ваш сохраненный список ---");
            writer.newLine();

            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }

            writer.write("--- Конец списка ---");
            writer.newLine();

            System.out.println("Файл '" + filename + "' успешно сохранен!");
            JOptionPane.showMessageDialog(null, "Файл '" + filename + "' сохранен!");

        } catch (IOException e) {
            // Handles file writing errors
            // Обрабатывает ошибки записи файла
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
            JOptionPane.showMessageDialog(
                    null,
                    "Произошла ошибка при сохранении: " + e.getMessage(),
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}