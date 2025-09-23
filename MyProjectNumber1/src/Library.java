import java.util.*;

public class Library {

    ArrayList<Book> list = new ArrayList<>();

    //Makes this Scanner work only within this class
    //Делает так, чтобы этот Scanner работал только в пределах этого класса
    private Scanner scanner = new Scanner(System.in);

    // Generate the constant value of ID
    //Создаёт случайный постоянный ID
    private static final Random random = new Random();

    // Set the constant value of ID
    // Устанавливает постоянный ID
    private static Set<Integer> existingIds = new HashSet<>();


    private int generateUniqueID() {
        int newID;
        do {
            newID = random.nextInt(10000) + 1;
        }
        //If the IDs are unique, set this value, otherwise it generates a new value
        //Если ID уникальные, устанавливает это значение, иначе генерирует новое значение
        while (existingIds.contains(newID));
        existingIds.add(newID);
        return newID;

    }

    //This class adds objects to the list
    // Этот класс добавляет объекты в список
    public void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ADD NEW BOOK: " +
                "\n-----------------------------------------------------------");

        int id = generateUniqueID();
        System.out.println("Generated ID: " + id);

        System.out.println("Author: ");
        String author = scanner.nextLine();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Type: ");
        String type = scanner.nextLine();

        System.out.println("isReading (True/False): ");
        boolean isReading = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("isWatching (True/False): ");
        boolean isWatching = scanner.nextBoolean();
        scanner.nextLine();

        Book newBook = new Book(id, author, name, age, type, isReading, isWatching);
        list.add(newBook);
        System.out.println("\nThe book has been successfully added!");
    }

    public ArrayList<Book> getAllItems() {
        System.out.println("\nList of all books: ");
        if (list.isEmpty()) {
            System.out.println("The list is empty");
        }else{
            for (Book book : list) {
                System.out.println(book.toString());
            }
        }

        return list;
    }


    //This class is responsible for the output of books by ID
    //Этот класс отвечает за вывод книг по ID
    public Optional<Book> getItemByID(int id) {

        return list.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }
}