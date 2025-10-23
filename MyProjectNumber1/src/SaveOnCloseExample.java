import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveOnCloseExample {

    // Это твой список, который будет "жить" во время работы программы
    private static List<String> dataList = new ArrayList<>();

    public static void main(String[] args) {
        // Для примера добавим в список какие-то данные
        dataList.add("Первая строка в списке");
        dataList.add("Вторая строка");
        dataList.add("Что-то еще...");

        // 1. Создаем основное окно
        JFrame frame = new JFrame("Пример сохранения при выходе");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null); // Окно по центру экрана

        // Добавим в окно текстовое поле, чтобы можно было
        // добавлять новые элементы в список во время работы
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

        // Просто для компоновки элементов в окне
        JPanel panel = new JPanel();
        panel.add(new JLabel("Введите текст:"));
        panel.add(inputField);
        panel.add(addButton);
        frame.add(panel);


        // 2. ЭТО ГЛАВНАЯ ЧАСТЬ: Отключаем стандартное закрытие
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // 3. Добавляем "слушателя"
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 4. Показываем диалог ДА/НЕТ
                int result = JOptionPane.showConfirmDialog(
                        frame, // Родительское окно
                        "Хотите сохранить список в файл перед выходом?", // Сообщение
                        "Подтверждение выхода", // Заголовок
                        JOptionPane.YES_NO_OPTION, // Тип кнопок
                        JOptionPane.QUESTION_MESSAGE // Иконка
                );

                // 5. Анализируем ответ
                if (result == JOptionPane.YES_OPTION) {
                    // Пользователь нажал "Да"
                    saveListToFile(dataList); // Вызываем метод сохранения
                    frame.dispose(); // Закрываем окно
                    System.exit(0); // Полностью завершаем программу
                } else if (result == JOptionPane.NO_OPTION) {
                    // Пользователь нажал "Нет"
                    frame.dispose();
                    System.exit(0);
                }
                // Если пользователь нажал "Cancel" или закрыл диалог,
                // то result будет другим, и мы просто ничего не делаем,
                // оставаясь в программе.
            }
        });

        // Делаем окно видимым
        frame.setVisible(true);
    }

    /**
     * Метод, который "скачивает" (сохраняет) список в текстовый файл.
     * @param list Список строк для сохранения
     */
    private static void saveListToFile(List<String> list) {
        // Имя файла (он появится в той же папке, где запущена программа)
        String filename = "saved_list.txt";

        // Используем try-with-resources, чтобы файл
        // гарантированно закрылся, даже если будет ошибка
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            writer.write("--- Ваш сохраненный список ---");
            writer.newLine();

            for (String item : list) {
                writer.write(item); // Записываем каждый элемент
                writer.newLine();   // С новой строки
            }

            writer.write("--- Конец списка ---");
            writer.newLine();

            System.out.println("Файл '" + filename + "' успешно сохранен!");
            // Можно показать сообщение об успехе
            JOptionPane.showMessageDialog(null, "Файл '" + filename + "' сохранен!");

        } catch (IOException e) {
            // Если произошла ошибка (например, нет прав на запись)
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