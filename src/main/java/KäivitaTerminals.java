import java.io.IOException;

public class KäivitaTerminals {
    public static void main(String[] args) {
        String praeguneKaust = System.getProperty("user.dir");
        try {
            String gradleKäsk = "gradlew.bat -q run";
            String käsk = "cmd /c start cmd.exe /K \"cd \"" + praeguneKaust + "\" && " + gradleKäsk + "\"";
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", käsk);
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}