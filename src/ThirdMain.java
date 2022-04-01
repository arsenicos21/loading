import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ThirdMain {

    static String way = "Games//savegames//";
    static String wayZip = way + "zip.zip";

    public static void main(String[] args) {

        openZip(wayZip, way);

        openProgress(way, new GameProgress(50, 100, 1, 100));

    }

    public static void openZip(String wayZip, String way) {
        try (ZipInputStream zin = new ZipInputStream(new
                FileInputStream(wayZip))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(way + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void openProgress(String way, GameProgress gameProgress) {
        gameProgress = null;
        for (int i = 1; i < 4; i++) {
            try (FileInputStream fis = new FileInputStream(way + "save" + i + ".dat");
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                gameProgress = (GameProgress) ois.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(gameProgress);
        }
    }
}
