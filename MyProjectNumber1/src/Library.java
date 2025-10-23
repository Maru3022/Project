import javax.swing.*;
import java.io.*;
import java.util.*;

public class Library {

    ArrayList<Book> list = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static Set<Integer> existingIds = new HashSet<>();

    private int generateUniqueID() {
        int newID;
        int attempts = 0;
        do {
            newID = random.nextInt(10000) + 1;
            attempts++;
            if (attempts > 10000) {
                throw new RuntimeException("Unable to generate a unique ID after 10000 attempts.");
            }
        } while (existingIds.contains(newID));
        existingIds.add(newID);
        return newID;
    }

    public void addItem() {
        System.out.println("ADD NEW BOOK: " +
                "\n-----------------------------------------------------------");

        int id = generateUniqueID();
        System.out.println("Generated ID: " + id);

        String author;
        while (true) {
            System.out.print("Author: ");
            author = scanner.nextLine();

            if (author.trim().isEmpty()) {
                System.out.println("Error: Author's name cannot be empty. Please try again.");
                continue;
            }

            if (author.length() > 100) {
                System.out.println("Error: Author's name is too long (max 100 characters). Please try again.");
                continue;
            }
            break;
        }

        String name;
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                System.out.println("Error: Name cannot be empty. Please try again.");
                continue;
            }

            if (name.length() > 100) {
                System.out.println("Error: Name is too long (max 100 characters). Please try again.");
                continue;
            }
            break;
        }

        int publicationYear = 0;
        while (true) {
            System.out.print("Publication year: ");
            String publicationYearInput = scanner.nextLine();
            if (publicationYearInput.isEmpty()) {
                System.out.println("Error: Year cannot be empty. Please try again.");
                continue;
            }
            try {
                publicationYear = Integer.parseInt(publicationYearInput);
                if (publicationYear < 0 || publicationYear > 2025) {
                    System.out.println("Error: Year must be between 0 and 2025.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number for the year.");
            }
        }

        String type;
        while (true) {
            System.out.print("Type: ");
            type = scanner.nextLine();

            if (type.trim().isEmpty()) {
                System.out.println("Error: Type cannot be empty. Please try again.");
                continue;
            }

            if (type.length() > 100) {
                System.out.println("Error: Type is too long (max 100 characters). Please try again.");
                continue;
            }
            break;
        }

        boolean isReading;
        while (true) {
            System.out.print("isReading (true/false): ");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("true")) {
                isReading = true;
                break;
            } else if (line.equalsIgnoreCase("false")) {
                isReading = false;
                break;
            } else {
                System.out.println("Incorrect input! Please enter 'true' or 'false'.");
            }
        }

        Book newBook = new Book(id, author, name, publicationYear, type, isReading);
        list.add(newBook);
        System.out.println("\nThe book has been successfully added!");
    }

    public ArrayList<Book> getAllItems() {
        System.out.println("\nList of all books: ");
        if (list.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            for (Book book : list) {
                System.out.println(book.toString());
            }
        }
        return list;
    }

    public Optional<Book> getItemByID(int id) {
        return list.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : list) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : list) {
            if (book.getPublicationYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public void editBookByID(int id) {
        Optional<Book> bookOptional = getItemByID(id);
        if (!bookOptional.isPresent()) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        Book book = bookOptional.get();
        System.out.println("Found book: " + book.toString());
        System.out.println("Enter new values (press Enter to keep current):");

        System.out.print("New name [" + book.getName() + "]: ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            book.setName(newName);
        }

        System.out.print("New author [" + book.getAuthor() + "]: ");
        String newAuthor = scanner.nextLine();
        if (!newAuthor.isEmpty()) {
            book.setAuthor(newAuthor);
        }

        System.out.print("New publication year [" + book.getPublicationYear() + "]: ");
        String newAgeInput = scanner.nextLine();
        if (!newAgeInput.isEmpty()) {
            try {
                int newAge = Integer.parseInt(newAgeInput);
                book.setPublicationYear(newAge);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Year not changed.");
            }
        }

        System.out.print("New isReading (true/false) [" + book.isReading() + "]: ");
        String newReadingInput = scanner.nextLine();
        if (!newReadingInput.isEmpty()) {
            if (newReadingInput.equalsIgnoreCase("true") || newReadingInput.equalsIgnoreCase("false")) {
                book.setReading(Boolean.parseBoolean(newReadingInput));
            } else {
                System.out.println("Invalid boolean format. Use 'true' or 'false'. isReading not changed.");
            }
        }

        System.out.println("Book updated successfully");
    }

    public void DeleteItemByID() {
        System.out.print("Enter id to delete: ");
        int delete = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you sure (true/false): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("true")) {
            boolean removed = list.removeIf(item -> item.getId() == delete);
            if (removed) {
                System.out.println("Item with ID " + delete + " deleted successfully");
            } else {
                System.out.println("Item with ID " + delete + " not found");
            }
        } else if (confirmation.equalsIgnoreCase("false")) {
            System.out.println("Deletion cancelled");
        } else {
            System.out.println("Invalid input. Please enter 'true' or 'false'");
        }
    }

    public void saveToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Book book : list) {
                writer.println(book.toCSV());
            }
            System.out.println("The data has been successfully saved to a file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving to CSV: " + e.getMessage());
        }
    }

    public void loadFromCSV(String filename) {
        List<Book> loadedBooks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    Book book = Book.fromCSV(line);

                    if (!existingIds.contains(book.getId())) {
                        loadedBooks.add(book);
                        existingIds.add(book.getId());
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Error in line " + lineNumber + ": " + e.getMessage());
                }
            }

            list.clear();
            list.addAll(loadedBooks);

            System.out.println("Data successfully loaded from file: " + filename);
            System.out.println("Books loaded: " + loadedBooks.size());

        } catch (IOException e) {
            System.err.println("Error when loading from CSV: " + e.getMessage());
        }
    }

    public void displayAllItemsCSV() {
        System.out.println("\nList of all books in CSV format:");
        System.out.println("ID,Author,Name,PublicationYear,Type,isReading");
        System.out.println("--------------------------------------------------");

        if (list.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            for (Book book : list) {
                System.out.println(book.toCSV());
            }
        }
    }

    public void displayItemByIDCSV(int id) {
        Optional<Book> bookOptional = getItemByID(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            System.out.println("\nBook found in CSV format:");
            System.out.println("ID,Author,Name,PublicationYear,Type,isReading");
            System.out.println("--------------------------------------------------");
            System.out.println(book.toCSV());
        } else {
            System.out.println("Book with ID " + id + " not found");
        }
    }

    public void displayItemByAuthorCSV(String author) {
        ArrayList<Book> result = searchByAuthor(author);
        if (!result.isEmpty()) {
            System.out.println("\nFound " + result.size() + " books by author " + author + " in CSV format:");
            System.out.println("ID,Author,Name,PublicationYear,Type,isReading");
            System.out.println("--------------------------------------------------");
            for (Book book : result) {
                System.out.println(book.toCSV());
            }
        } else {
            System.out.println("No books found by author: " + author);
        }
    }

    public void displaySortedByAuthor() {
        List<Book> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparing(
                book -> extractLastName(book.getAuthor()),
                String.CASE_INSENSITIVE_ORDER
        ));

        System.out.println("\nBooks sorted by author's LAST NAME:");
        if (sortedList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Book book : sortedList) {
                System.out.println(book);
            }
        }
    }

    public void displaySortedByName() {
        List<Book> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparing(Book::getName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\nBooks sorted by name:");
        if (sortedList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Book book : sortedList) {
                System.out.println(book);
            }
        }
    }

    public void displaySortedByNameCSV() {
        List<Book> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparing(Book::getName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\nBooks sorted by name (CSV format):");
        System.out.println("ID,Author,Name,PublicationYear,Type,isReading");
        System.out.println("--------------------------------------------------");
        if (sortedList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Book book : sortedList) {
                System.out.println(book.toCSV());
            }
        }
    }

    public void displaySortedByAuthorCSV() {
        List<Book> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparing(
                book -> extractLastName(book.getAuthor()),
                String.CASE_INSENSITIVE_ORDER
        ));

        System.out.println("\nBooks sorted by author's LAST NAME (CSV format):");
        System.out.println("ID,Author,Name,PublicationYear,Type,isReading");
        System.out.println("--------------------------------------------------");
        if (sortedList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Book book : sortedList) {
                System.out.println(book.toCSV());
            }
        }
    }

    public void displayByYearCSV(int year) {
        ArrayList<Book> result = searchByYear(year);
        if (!result.isEmpty()) {
            System.out.println("\nFound " + result.size() + " books from year " + year + " in CSV format:");
            System.out.println("ID,Author,Name,PublicationYear,Type,isReading");
            System.out.println("--------------------------------------------------");
            for (Book book : result) {
                System.out.println(book.toCSV());
            }
        } else {
            System.out.println("No books found from year: " + year);
        }
    }

    public static String extractLastName(String author) {
        if (author == null || author.trim().isEmpty()) {
            return "";
        }
        String[] parts = author.trim().split("\\s+");
        return parts[parts.length - 1]; // последнее слово — фамилия
    }
}