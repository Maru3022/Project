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
            System.out.println("6. Update information");
            System.out.print("Enter your choice: ");

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
                    scanner.close();
                    return;

                case 5:
                    ArrayList<Book> books = library.getAllItems();

                    break;

                case 6:
                    System.out.println("=== Edit element ===");
                    System.out.print("Enter element ID to edit: ");

                    try{
                        int idToFind = scanner.nextInt();
                        scanner.nextLine();

                        library.editBookByID(idToFind);
                    }catch (InputMismatchException e){
                        System.out.println("Error: Invalid ID format. Please enter a number.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}