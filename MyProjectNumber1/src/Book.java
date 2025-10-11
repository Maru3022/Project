public class Book {
    private int id;
    private String name;
    private String author;
    private int publicationYear;
    private String type;
    private boolean isReading;
    private boolean isWatched; // если это действительно нужно (например, для аудиокниг/видео)

    // Конструктор
    public Book(int id, String author, String name, int publicationYear,
                String type, boolean isReading, boolean isWatched) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.publicationYear = publicationYear;
        this.type = type;
        this.isReading = isReading;
        this.isWatched = isWatched;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getType() {
        return type;
    }

    public boolean isReading() {
        return isReading;
    }

    public boolean isWatched() {
        return isWatched;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReading(boolean reading) {
        isReading = reading;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    // === CSV сериализация ===
    public String toCSV() {
        // Экранируем запятые заменой на точку с запятой (упрощённый подход)
        return id + "," +
                escapeCSV(author) + "," +
                escapeCSV(name) + "," +
                publicationYear + "," +
                escapeCSV(type) + "," +
                isReading + "," +
                isWatched;
    }

    private static String escapeCSV(String value) {
        return value == null ? "" : value.replace(",", ";");
    }

    // === CSV десериализация ===
    public static Book fromCSV(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException("CSV line is null or empty");
        }
        String[] parts = line.split(",", 7); // разбиваем строго на 7 частей
        if (parts.length != 7) {
            throw new IllegalArgumentException("Invalid CSV format: expected 7 fields, got " + parts.length + " in line: " + line);
        }

        try {
            int id = Integer.parseInt(parts[0].trim());
            String author = unescapeCSV(parts[1]);
            String name = unescapeCSV(parts[2]);
            int publicationYear = Integer.parseInt(parts[3].trim());
            String type = unescapeCSV(parts[4]);
            boolean isReading = Boolean.parseBoolean(parts[5].trim());
            boolean isWatched = Boolean.parseBoolean(parts[6].trim());

            return new Book(id, author, name, publicationYear, type, isReading, isWatched);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in CSV line: " + line, e);
        }
    }

    private static String unescapeCSV(String value) {
        return value == null ? "" : value.replace(";", ",");
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", type='" + type + '\'' +
                ", isReading=" + isReading +
                ", isWatched=" + isWatched +
                '}';
    }
}