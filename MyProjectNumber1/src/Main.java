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
            System.out.println("2. List All Books (normal format)");
            System.out.println("3. List All Books (CSV format)");
            System.out.println("4. Find Book by ID (normal format)");
            System.out.println("5. Find Book by ID (CSV format)");
            System.out.println("6. Edit Book");
            System.out.println("7. Delete Book");
            System.out.println("8. Search Books (normal format)");
            System.out.println("9. Search Books (CSV format)");
            System.out.println("10. Save to CSV file");
            System.out.println("11. Load from CSV file");
            System.out.println("12. List Books Sorted by Name");
            System.out.println("13. List Books Sorted by Author");
            System.out.println("14. List Books Sorted by Name (CSV format)");
            System.out.println("15. List Books Sorted by Author (CSV format)");
            System.out.println("16. Exit");

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

                //CSV output of all books
                //CSV вывод всех книг
                case 3:
                    library.displayAllItemsCSV();
                    break;

                //Search book by ID
                //Поиск книги по ID
                case 4:
                    System.out.print("Enter Book ID to search: ");
                    int idToSearch = scanner.nextInt();
                    scanner.nextLine();
                    Optional<Book> bookOptional = library.getItemByID(idToSearch);
                    if (bookOptional.isPresent()) {
                        System.out.println(bookOptional.get().toString());
                    } else {
                        System.out.println("Book with ID " + idToSearch + " not found.");
                    }
                    break;

                //Search book by ID in CSV format
                //Поиск книги по ID в формате CSV
                case 5:
                    System.out.println("Enter Book by ID to search (CSV): ");
                    int idToSearchCSV = scanner.nextInt();
                    scanner.nextLine();
                    library.displayItemByIDCSV(idToSearchCSV);
                    break;

                //Edit some element by ID
                //Изменение некоторых элементов по ID
                case 6:
                    System.out.println("=== Edit element ===");
                    System.out.print("Enter element ID to edit: ");

                    try {
                        int idToFind = scanner.nextInt();
                        scanner.nextLine();

                        library.editBookByID(idToFind);
                    } catch (InputMismatchException e) {
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

                    System.out.println("=== Search some book ===");

                    System.out.print("Choose a search method (1-by ID,2-by author,3-by year) : ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchChoice) {

                        //Search for a book by ID
                        //Поиск книги по ID
                        case 1:

                            System.out.print("Enter the search ID: ");
                            int idToSearch1 = scanner.nextInt();
                            scanner.nextLine();

                            Optional<Book> foundBook = library.getItemByID(idToSearch1);

                            if (foundBook.isPresent()) {
                                System.out.println("Book found: " + foundBook.get());
                            } else {
                                System.out.println("Book with ID " + idToSearch1 + " not found.");
                            }
                            break;

                        //Search for a book by author
                        //Поиск книги по автору
                        case 2:

                            System.out.print("Enter the author to search:");
                            String authorToSearch = scanner.nextLine();

                            ArrayList<Book> booksByAuthor = library.searchByAuthor(authorToSearch);

                            if (!booksByAuthor.isEmpty()) {
                                System.out.println("Found " + booksByAuthor.size() + " book(s) by author " + authorToSearch + ":");
                                for (Book book : booksByAuthor) {
                                    System.out.println(book);
                                }
                            } else {
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

                            if (!booksByYear.isEmpty()) {
                                System.out.println("Found " + booksByYear.size() + " book(s) by year " + booksByYear + ":");
                            } else {
                                System.out.println("No books found by year: " + booksByYear);
                            }
                            break;
                    }

                    break;

                //This code closes the program
                //Этот код закрывает программу
                case 9:
                    handleSearchMenu(library, scanner, true);
                    break;

                case 10:
                    System.out.println("Enter filename to save: ");
                    String saveFilename = scanner.nextLine();
                    library.saveToCSV(saveFilename);
                    break;

                case 11:
                    System.out.println("Enter filename to load: ");
                    String loadFilename = scanner.nextLine();
                    library.loadFromCSV(loadFilename);
                    break;

                case 12:
                    library.displaySortedByName();
                    break;

                case 13:
                    library.displaySortedByAuthor();
                    break;

                case 14:
                    library.displaySortedByNameCSV();
                    break;

                case 15:
                    library.displaySortedByAuthorCSV();
                    break;

                case 16:
                    System.out.println("Do you want to save the library data before exiting? (yes/no): ");
                    String saveChoice = scanner.nextLine().trim().toLowerCase();

                    if (saveChoice.equals("yes") || saveChoice.equals("y")) {
                        System.out.print("Enter filename to save (e.g., library.csv): ");
                        String filename = scanner.nextLine().trim();
                        if (filename.isEmpty()) {
                            filename = "library.csv"; // значение по умолчанию
                        }
                        library.saveToCSV(filename);
                    } else if (!saveChoice.equals("no") && !saveChoice.equals("n")) {
                        System.out.println("Unrecognized input. Data will not be saved.");
                    }

                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleSearchMenu(Library library, Scanner scanner, boolean csvFormat) {
        System.out.println("\n=== Book Search ===");
        System.out.println("Choose search type (1-by author,2-by year): ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1:
                System.out.println("Enter author to search: ");
                String authorToSearch = scanner.nextLine();

                if (csvFormat) {
                    library.displayItemByAuthorCSV(authorToSearch);
                } else {
                    ArrayList<Book> booksByAuthor = library.searchByAuthor(authorToSearch);
                    if (!booksByAuthor.isEmpty()) {
                        System.out.println("Found " + booksByAuthor.size() + " book(s) by author " + authorToSearch + ":");
                        for (Book book : booksByAuthor) {
                            System.out.println(book);
                        }
                    } else {
                        System.out.println("No books found by author: " + authorToSearch);
                    }
                }
                break;
            case 2:
                System.out.println("Enter year to search: ");
                int yearToSearch = scanner.nextInt();
                scanner.nextLine();
                if (csvFormat) {
                    library.displayByYearCSV(yearToSearch);
                } else {
                    ArrayList<Book> booksByYear = library.searchByYear(yearToSearch);
                    if (!booksByYear.isEmpty()) {
                        System.out.println("Found " + booksByYear.size() + " book(s) from year " + yearToSearch + ":");
                        for (Book book : booksByYear) {
                            System.out.println(book);
                        }
                    } else {
                        System.out.println("No books found from year: " + yearToSearch);
                    }
                }
                break;
            default:
                System.out.println("Invalid search type choice.");
        }
    }
}