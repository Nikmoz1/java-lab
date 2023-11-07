import java.util.ArrayList;
import java.util.List;

// Базовий клас для файлів
class File {
    protected String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Перевизначення методу toString для виводу назви файлу
    @Override
    public String toString() {
        return name;
    }
}

// Клас, який представляє текстовий файл
class TextFile extends File {
    private StringBuilder content;

    public TextFile(String name) {
        super(name);
        content = new StringBuilder();
    }

    // Метод для запису вмісту у текстовий файл
    public void writeContent(String text) {
        content.append(text);
    }

    // Метод для виводу вмісту файлу на консоль
    public void displayContent() {
        System.out.println("Content of file " + name + ":");
        System.out.println(content.toString());
    }
}

// Клас, який представляє директорію
class Directory {
    private String name;
    private List<File> files;

    public Directory(String name) {
        this.name = name;
        files = new ArrayList<>();
    }

    // Метод для створення файлу у директорії
    public void createFile(String fileName) {
        TextFile file = new TextFile(fileName);
        files.add(file);
    }

    // Метод для перейменування файлу в директорії
    public void renameFile(String oldName, String newName) {
        for (File file : files) {
            if (file.getName().equals(oldName)) {
                file.name = newName;
                return;
            }
        }
    }

    // Метод для виводу списку файлів у директорії на консоль
    public void listFiles() {
        System.out.println("Files in directory " + name + ":");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    // Метод для видалення файлу з директорії
    public void deleteFile(String fileName) {
        files.removeIf(file -> file.getName().equals(fileName));
    }
}

public class Main {
    public static void main(String[] args) {
        Directory directory = new Directory("MyFiles");

        TextFile file1 = new TextFile("document.txt");
        file1.writeContent("This is the content of the file.");

        TextFile file2 = new TextFile("report.txt");
        file2.writeContent("A sample report.");

        directory.createFile("notes.txt");

        directory.listFiles();

        file1.displayContent();

        directory.renameFile("notes.txt", "important-notes.txt");

        directory.listFiles();

        directory.deleteFile("report.txt");

        directory.listFiles();
    }
}
