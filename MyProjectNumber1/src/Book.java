//In this class, all getters and setters for the whole project
// этом классе все геттеры и сеттеры для всего проекта

public class Book {
    private int id;
    private String name;
    private String author;
    private int age;
    private String type;
    private boolean isReading;
    private boolean isWatched;

    public Book(int id, String author, String name, int age, String type, boolean isReading, boolean isWatched) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.age = age;
        this.type = type;
        this.isReading = isReading;
        this.isWatched = isWatched;
    }

    public int getAge() {
        return age;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public boolean isReading() {
        return isReading;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public String getName() {
        return name;
    }

    public String getType() {
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