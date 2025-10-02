import java.util.*;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Creates an endless cycle
        // Создаёт бесконечный цикл
        while (true) {

            System.out.println("\nLibrary Menu: ");
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. Find Book by ID");
            System.out.println("4. Exit");
            System.out.println("5. Show all the books");
            System.out.println("6. Update information");
            System.out.println("7. Delete element");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            //Selecting a number to operate on the list
            //Выбор номера для операции над списком
            switch (choice) {

                //add an element to the list
                //добавить элемент в список
                case 1:
                    library.addItem();
                    break;

                //Getting an element from a list
                //Получение элемента из списка
                case 2:
                    library.getAllItems();
                    break;

                 //Searching for an element by ID
                 //Поиск элемента по ID
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

                //Exit from the cycle
                //Выход из цикла
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                //Get all element
                //Получение всех элементов из списка
                case 5:
                    ArrayList<Book> books = library.getAllItems();
                    break;

                //Edit some element by ID
                //Изменение некоторых элементов по ID
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

                //Delete element by ID
                //Удаление элементов по ID
                case 7:
                    System.out.println("=== Delete element by ID ===");
                    System.out.print("Enter element ID to delete: ");

                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();

                    library.DeleteItemByID();

                    break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}