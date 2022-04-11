package homework3.solution1;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

public class Tree {
    private Node root;

    public void add(int parentId, int id, int data) {
        root = add(root, parentId, id, data);
    }

    private Node add(Node root, int parentId, int id, int data) {
        List<Node> list = root.getChildren();
        if (root.getId() == parentId) {
            root.getChildren().add(new Node(data, parentId, id));
            return root;
        }
        if (list.size() == 0) {
            return root;
        }
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i), parentId, id, data);
        }
        return root;
    }

    public void constructTree(JsonArray elements) {
        for (JsonElement element : elements) {
            JsonObject child = element.getAsJsonObject();
            if (child.get("parent_id").getAsInt() == -1) {
                root = new Node(child.get("data").getAsInt(),
                        child.get("parent_id").getAsInt(),
                        child.get("id").getAsInt());
            } else {
                int parentId = child.get("parent_id").getAsInt();
                int id = child.get("id").getAsInt();
                int data = child.get("data").getAsInt();
                add(parentId, id, data);
            }
        }
    }
}
