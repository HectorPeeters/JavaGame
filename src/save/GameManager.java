package save;

import util.TimeUtils;
import world.TileType;
import world.World;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public static void saveGame() {
        try {
            File file = new File("saves/save_" + TimeUtils.getTimeAndDate() + ".sav");
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            for (int y = 0; y < World.WORLD_HEIGHT; y++) {
                for (int x = 0; x < World.WORLD_WIDTH; x++)
                    writer.print(World.getTile(x, y).toString() + ";");
                writer.println();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[] getAllSaves() {
        File folder = new File("saves");
        File[] listOfFiles = folder.listFiles();
        List<String> saves = new ArrayList<>();
        for (File listOfFile : listOfFiles)
            if (listOfFile.isFile())
                saves.add(listOfFile.getName());
        String[] result = new String[saves.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = saves.get(i);
        return result;
    }

    public static void loadLatestGame() {
        String[] saves = getAllSaves();
        if (saves.length > 0)
            loadGame(saves[saves.length - 1]);
    }

    public static void loadGame(String saveName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("saves/" + saveName));
            String line = br.readLine();
            int lineNum = 0;
            while (line != null) {
                String[] split = line.split(";");
                for (int i = 0; i < split.length; i++)
                    World.getTile(i, lineNum).tileType = TileType.valueOf(split[i]);
                line = br.readLine();
                lineNum++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
