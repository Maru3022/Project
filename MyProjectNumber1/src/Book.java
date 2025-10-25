public class Book {
    private int id;
    private String name;
    private String author;
    private int publicationYear;
    private String type;
    private boolean isReading;

    // Creates an empty book object (default constructor)
    // Создаёт пустой объект книги (конструктор по умолчанию)
    public Book() {
    }

    // Creates a book with all fields initialized
    // Создаёт книгу со всеми заполненными полями
    public Book(int id, String author, String name, int publicationYear,
                String type, boolean isReading) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.publicationYear = publicationYear;
        this.type = type;
        this.isReading = isReading;
    }

    // Returns the unique ID of the book
    // Возвращает уникальный ID книги
    public int getId() {
        return id;
    }

    // Returns the title of the book
    // Возвращает название книги
    public String getName() {
        return name;
    }

    // Returns the author's name
    // Возвращает имя автора
    public String getAuthor() {
        return author;
    }

    // Returns the year the book was published
    // Возвращает год публикации книги
    public int getPublicationYear() {
        return publicationYear;
    }

    // Returns the book's category or genre
    // Возвращает категорию или жанр книги
    public String getType() {
        return type;
    }

    // Returns whether the book is currently being read
    // Возвращает, читается ли книга в данный момент
    public boolean isReading() {
        return isReading;
    }

    // Sets a new ID for the book
    // Устанавливает новый ID для книги
    public void setId(int id) {
        this.id = id;
    }

    // Sets a new title for the book
    // Устанавливает новое название книги
    public void setName(String name) {
        this.name = name;
    }

    // Sets a new author name
    // Устанавливает новое имя автора
    public void setAuthor(String author) {
        this.author = author;
    }

    // Sets a new publication year
    // Устанавливает новый год публикации
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Sets a new book type or genre
    // Устанавливает новый тип или жанр книги
    public void setType(String type) {
        this.type = type;
    }

    // Sets the reading status (true = currently reading)
    // Устанавливает статус чтения (true = сейчас читается)
    public void setReading(boolean reading) {
        isReading = reading;
    }

    // Converts the book to a CSV-compatible string
    // Преобразует книгу в строку, совместимую с форматом CSV
    public String toCSV() {
        return id + "," +
                escapeCSV(author) + "," +
                escapeCSV(name) + "," +
                publicationYear + "," +
                escapeCSV(type) + "," +
                isReading;
    }

    // Replaces commas with semicolons to avoid CSV format errors
    // Заменяет запятые на точки с запятой, чтобы избежать ошибок в CSV
    private static String escapeCSV(String value) {
        return value == null ? "" : value.replace(",", ";");
    }

    // Creates a Book object from a CSV line
    // Создаёт объект Book из строки в формате CSV
    public static Book fromCSV(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException("CSV line is null or empty");
        }
        String[] parts = line.split(",", 6);
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid CSV format: expected 6 fields, got " + parts.length + " in line: " + line);
        }

        try {
            int id = Integer.parseInt(parts[0].trim());
            String author = unescapeCSV(parts[1]);
            String name = unescapeCSV(parts[2]);
            int publicationYear = Integer.parseInt(parts[3].trim());
            String type = unescapeCSV(parts[4]);
            boolean isReading = Boolean.parseBoolean(parts[5].trim());

            return new Book(id, author, name, publicationYear, type, isReading);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in CSV line: " + line, e);
        }
    }

    // Restores original commas from escaped CSV values
    // Восстанавливает исходные запятые из экранированных значений CSV
    private static String unescapeCSV(String value) {
        return value == null ? "" : value.replace(";", ",");
    }

    // Returns a human-readable string representation of the book
    // Возвращает удобочитаемое текстовое представление книги
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", type='" + type + '\'' +
                ", isReading=" + isReading +
                '}';
    }
}