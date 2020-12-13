import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final String ROOT_PATH = "F://Netology.Games";
    static final String LOG_PATH = "//temp";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        List<String> pathNames = initPathNames();
        List<String> fileNames = initFileNames();

        for (String pathName : pathNames) {
            File dir = new File(ROOT_PATH + pathName);
            if (dir.mkdir()) {
                sb.append("Директория '" + pathName + "' успешно создана.\n");
            } else {
                sb.append("Не удалось создать директорию '" + pathName + "'\n");
            }
        }

        for (String fileName : fileNames) {
            File file = new File(ROOT_PATH + "//src//main" + fileName);
            try {
                if (file.createNewFile()) sb.append("Файл " + file.getPath() + " успешно записан.");
            } catch (IOException ex) {
                sb.append(ex.getMessage());
            }
        }

        writeLog(sb);
    }

    private static ArrayList<String> initPathNames() {
        ArrayList<String> pathNames = new ArrayList<>();
        pathNames.add("//src");
        pathNames.add("//res");
        pathNames.add("//savegames");
        pathNames.add(LOG_PATH);
        pathNames.add("//src//main");
        pathNames.add("//src//test");
        pathNames.add("//res//drawables");
        pathNames.add("//res//vectors");
        pathNames.add("//res//icons");
        return pathNames;
    }

    private static void writeLog(StringBuilder sb) {
        try (FileWriter fileWriter = new FileWriter(ROOT_PATH + LOG_PATH + "//temp.txt", false)) {
            fileWriter.write(sb.toString());
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println("Не удалось записать лог!");
        }
    }

    private static ArrayList<String> initFileNames() {
        ArrayList<String> fileNames = new ArrayList<>();
        fileNames.add("//Main.java");
        fileNames.add("//Utils.java");
        return fileNames;
    }
}
