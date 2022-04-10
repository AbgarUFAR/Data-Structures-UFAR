package homework3;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        String str = new String(
                Files.readAllBytes(Paths.get(
                        "C:\\Users\\User\\UfarProjects\\Data Structures\\src\\main\\resources\\data_json.txt"
                ))
        );
        Gson gson = new Gson();
        JsonArray jsonElements = gson.fromJson(str, JsonArray.class);
        Tree tree = new Tree();
        tree.constructTree(jsonElements);
    }
}
