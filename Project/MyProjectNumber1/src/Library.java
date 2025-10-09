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

        String author;

        while (true) {
            System.out.print("Author: ");
            author = scanner.nextLine();

            if (author.trim().isEmpty()) {
                System.out.println("Error: Author's name cannot be empty. Please try again.");
                continue;
            }

            if (author.matches(".*[0-9].*")) {
                System.out.println("Error: Author's name cannot contain numbers. Please try again.");
                continue;
            }

            if (author.length() > 100) {
                System.out.println("Error: Author's name is too long (max 100 characters). Please try again.");
                continue;
            }

            break;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = 0;
        try{
            age = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Error. Enter another information format");
            scanner.nextLine();
        }

        System.out.print("Type: ");
        String type = scanner.nextLine();

        System.out.print("isReading (True/False): ");
        boolean isReading = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("isWatching (True/False): ");
        boolean isWatching = scanner.nextBoolean();
        scanner.nextLine();

        Book newBook = new Book(id, author, name, age, type, isReading, isWatching);
        list.add(newBook);
        System.out.print("\nThe book has been successfully added!");
    }

    //This class is responsible for the output of books
    //Этот класс отвечает за вывод книг
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

    public ArrayList<Book> searchByAuthor(String author){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : list){
            if (book.getAuthor().equalsIgnoreCase(author)){
                result.add(book);
            }
        }
        return result;
    }


    public ArrayList<Book> searchByYear(int year){
        ArrayList<Book> result = new ArrayList<>();
        for(Book book : list ){
            if (book.getPublicationYear() == year){
                result.add(book);
            }
        }

        return result;
    }

    //This class is responsible for changing the list
    //Этот класс отвечает за изменение списка
    public void editBookByID(int id){
        Optional<Book> bookOptional = getItemByID(id);
        if(!bookOptional.isPresent()){
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        Book book = bookOptional.get();
        System.out.println("Found book: " + book.toString());
        System.out.println("Enter new values (press Enter to keep current):");

        System.out.println("New name [" + book.getName() + "]: ");
        String newName = scanner.nextLine();
        if(!newName.isEmpty()){
            book.setName(newName);
        }

        System.out.println("New author [" + book.getAuthor() + "]: ");
        String newAuthor = scanner.nextLine();
        if(!newAuthor.isEmpty()){
            book.setAuthor(newAuthor);
        }


        System.out.println("New age [" + book.getPublicationYear() + "]: ");
        String newAgeInput = scanner.nextLine();
        if (!newAgeInput.isEmpty()){
            try{
                int newAge = Integer.parseInt(newAgeInput);
                book.setPublicationYear(newAge);
            }catch(NumberFormatException e){
                System.out.println("Invalid number format. Age not changed.");
            }
        }

        System.out.println("New isReading (True/False) [" + book.isReading() + "]:");
        String newReadingInput = scanner.nextLine();
        if (!newReadingInput.isEmpty()){
            try{
                boolean newReading = Boolean.parseBoolean(newReadingInput);
                book.setReading(newReading);
            }catch (Exception e){
                System.out.println("Invalid boolean format. Use 'True' or 'False'. Watched status not changed" );
            }
        }

        System.out.println("Book updated successfully");
    }

    //This class is responsible for removing list items
    //Этот класс отвечает за удаление элементов списка
    public void DeleteItemByID(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter id to delete: ");
        int delete = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Are you sure(True or False): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("True")){

            boolean removed = list.removeIf(item -> item.getId() == delete);
            if (removed){
                System.out.println("Item with ID " + delete + " deleted successfully");
            }else{
                System.out.println("Item with ID " + delete + " not found");
            }
        }else if(confirmation.equalsIgnoreCase("False")){
            System.out.println("Deletion cancelled");
        }else{
            System.out.println("Invalid input. Please enter 'True' or 'False'");
        }

    }
}