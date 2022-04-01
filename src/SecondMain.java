import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SecondMain {
    static String way = "Games//savegames//";

    public static void main(String[] args) {
        List<String> wayList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            way = "Games//savegames//save" + i + ".dat";
            saveGame(way, new GameProgress(50 * i, 100 - (5 * i), i, 100 * i));
            wayList.add(way);
        }

        zipFiles(way, wayList);

        for (int l = 1; l < 4; l++) {
            way = "Games//savegames//save" + l + ".dat";
            File file = new File(way);
            if (file.delete()) {
                System.out.println("File " + way + " was deleted");
            }
        }
    }

    public static void saveGame(String way, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(way);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void zipFiles(String way, List<String> wayList) {
        way = "Games//savegames//";
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(way + "zip.zip"))) {
            for (int j = 1; j < 4; j++) {
                try (FileInputStream fis = new FileInputStream(wayList.get(j - 1))) {
                    ZipEntry entry = new ZipEntry("save" + j + ".dat");
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
