import java.util.*;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Creates an endless cycle
        // Создаёт бесконечный цикл
        while (true) {

            // Selection of the operation to be performed
            System.out.println("\nLibrary Menu: ");
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. Find Book by ID");
            System.out.println("4. Exit");
            System.out.println("5. Show all the books");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.addItem();
                    break;
                case 2:
                    library.getAllItems();
                    break;
                case 3:
                    System.out.println("Enter Book ID to search: ");
                    int idToSearch = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Book> bookOptional = library.getItemByID(idToSearch);

                    //Checks if there is a book in bookOptional
                    //Проверяет, есть ли книга в bookOptional
                    if (bookOptional.isPresent()) {
                        Book book = bookOptional.get();

                        System.out.println(book.toString());

                    } else {
                        System.out.println("Book with ID " + idToSearch + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                case 5:
                    ArrayList<Book> books = library.getAllItems();

                    if (books == null) {
                        System.out.println("Error!");
                        break;
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }
}