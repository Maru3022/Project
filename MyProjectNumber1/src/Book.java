public class Book {

    private static int id;
    private static String name;
    private static String author;
    private static int age;
    private static String type;
    private static boolean isReading;
    private static boolean isWatched;

    public Book(int id, String author, String name, int age, String type, boolean isReading, boolean isWatched) {
        this.age = age;
        this.author = author;
        this.id = id;
        this.isReading = isReading;
        this.isWatched = isWatched;
        this.name = name;
        this.type = type;
    }

    public static int getAge() {
        return age;
    }

    public static String getAuthor() {
        return author;
    }

    public static int getId() {
        return id;
    }

    public static boolean isReading() {
        return isReading;
    }

    public static boolean isWatched() {
        return isWatched;
    }

    public static String getName() {
        return name;
    }

    public static String getType() {
        return type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReading(boolean reading) {
        isReading = reading;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", isReading=" + isReading +
                ", isWatched=" + isWatched +
                ']';
    }
}