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

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

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
            book.setAuthor(newName);
        }

        System.out.println("New author [" + book.getAuthor() + "]: ");
        String newAuthor = scanner.nextLine();
        if(!newAuthor.isEmpty()){
            book.setAuthor(newAuthor);
        }


        System.out.println("New age [" + book.getAge() + "]: ");
        String newAgeInput = scanner.nextLine();
        if (!newAgeInput.isEmpty()){
            try{
                int newAge = Integer.parseInt(newAgeInput);
                book.setAge(newAge);
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
}