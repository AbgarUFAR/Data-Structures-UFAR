package homework3.solution2;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
        JsonObject rootJsonObject = jsonElements.get(0).getAsJsonObject();
        Tree tree = new Tree(new Tree.Node(
                rootJsonObject.get("data").getAsInt(),
                rootJsonObject.get("parent_id").getAsInt(),
                rootJsonObject.get("id").getAsInt()
        ));
        tree.buildTree(tree.getRoot(), jsonElements);
    }
}
