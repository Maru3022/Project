import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

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
            System.out.println("8. Find some element");
            System.out.println("9. Exit with code 9");
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

                case 8:

                    System.out.println("=== Search some element ===");

                    System.out.print("Choose a search method (1-by ID,2-by author,3-by year) : ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch(searchChoice){

                        //Search for a book by ID
                        //Поиск книги по ID
                        case 1:

                            System.out.print("Enter the search ID: ");
                            int idToSearch1 = scanner.nextInt();
                            scanner.nextLine();

                            Optional<Book> foundBook = library.getItemByID(idToSearch1);

                            if(foundBook.isPresent()){
                                System.out.println("Book found: " + foundBook.get());
                            }else {
                                System.out.println("Book with ID " + idToSearch1 + " not found.");
                            }
                            break;

                        //Search for a book by author
                        //Поиск книги по автору
                        case 2:

                            System.out.print("Enter the author to search:");
                            String authorToSearch = scanner.nextLine();

                            ArrayList<Book> booksByAuthor = library.searchByAuthor(authorToSearch);

                            if (!booksByAuthor.isEmpty()){
                                System.out.println("Found " + booksByAuthor.size() + " book(s) by author " + authorToSearch + ":");
                                for (Book book : booksByAuthor){
                                    System.out.println(book);
                                }
                            }else{
                                System.out.print("No books found by author: " + authorToSearch);
                            }
                            break;

                        //Search for a book by year of publication
                        //Поиск книги по году издания
                        case 3:
                            System.out.print("You have selected a search by year of publication. Enter the year: ");

                            System.out.print("Enter the year to search: ");
                            int ageToSearch = scanner.nextInt();
                            scanner.nextLine();

                            ArrayList<Book> booksByYear = library.searchByYear(ageToSearch);

                            if (!booksByYear.isEmpty()){
                                System.out.println("Found " + booksByYear.size() + "book(s) by year " + booksByYear + ":" );
                            }else{
                                System.out.println("No books found by year: " + booksByYear);
                            }
                            break;
                    }

                    break;

                //This code closes the program
                //Этот код закрывает программу
                case 9:
                    System.out.println("Invalid with code...");
                    scanner.close();
                    return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}