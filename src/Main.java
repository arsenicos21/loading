import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        File src = new File("Games//src");
        if (src.mkdir())
            System.out.println("Каталог src успешно создан");
        stringBuilder.append("Создан каталог " + src).append("\n");

        File res = new File("Games//res");
        if (res.mkdir())
            System.out.println("Каталог res успешно создан");
        stringBuilder.append("Создан каталог " + res).append("\n");

        File savegames = new File("Games//savegames");
        if (savegames.mkdir())
            System.out.println("Каталог savegames успешно создан");
        stringBuilder.append("Создан каталог " + savegames).append("\n");

        File temp = new File("Games//temp");
        if (temp.mkdir())
            System.out.println("Каталог temp успешно создан");
        stringBuilder.append("Создан каталог " + temp).append("\n");

        File main = new File("Games//src//main");
        if (main.mkdir())
            System.out.println("Каталог main успешно создан");
        stringBuilder.append("Создан каталог " + main).append("\n");

        File test = new File("Games//src//test");
        if (test.mkdir())
            System.out.println("Каталог test успешно создан");
        stringBuilder.append("Создан каталог " + test).append("\n");

        File drawables = new File("Games//res//drawables");
        if (drawables.mkdir())
            System.out.println("Каталог drawables успешно создан");
        stringBuilder.append("Создан каталог " + drawables).append("\n");

        File vectors = new File("Games//res//vectors");
        if (vectors.mkdir())
            System.out.println("Каталог vectors успешно создан");
        stringBuilder.append("Создан каталог " + vectors).append("\n");

        File icons = new File("Games//res//icons");
        if (icons.mkdir())
            System.out.println("Каталог icons успешно создан");
        stringBuilder.append("Создан каталог " + icons).append("\n");

        File mainFile = new File("Games//src//main//Main.java");
        try {
            if (mainFile.createNewFile())
                System.out.println("Файл Main.java успешно создан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stringBuilder.append("Создан файл " + mainFile).append("\n");

        File utils = new File("Games//src//main//Utils.java");
        try {
            if (utils.createNewFile())
                System.out.println("Файл Utils.java успешно создан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stringBuilder.append("Создан файл " + utils).append("\n");

        File tempFile = new File("Games//temp//temp.txt");
        try {
            if (tempFile.createNewFile())
                System.out.println("Файл temp.txt успешно создан");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stringBuilder.append("Создан файл " + tempFile).append("\n");

        String result = stringBuilder.toString();
        try (FileOutputStream fos = new FileOutputStream("Games//temp//temp.txt")) {
            byte[] bytes = result.getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
