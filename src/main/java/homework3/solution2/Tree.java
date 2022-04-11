package homework3.solution2;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    static class Node {
        private int data;
        private int parentId;
        private int id;
        private List<Node> children;

        Node(int data, int parentId, int id) {
            this.data = data;
            this.parentId = parentId;
            this.id = id;
            children = new ArrayList<>();
        }
    }

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void buildTree(Node parent, JsonArray jsonElements) {
        jsonElements.forEach(jsonElement -> checkForChildAndAdd(parent, jsonElement));
        parent.children.forEach(child -> buildTree(child, jsonElements));
    }

    private void checkForChildAndAdd(Node parent, JsonElement jsonElement) {
        JsonObject currentNode = jsonElement.getAsJsonObject();
        if (currentNode.get("parent_id").getAsInt() == parent.id) {
            parent.children.add(new Node(
                    currentNode.get("data").getAsInt(),
                    currentNode.get("parent_id").getAsInt(),
                    currentNode.get("id").getAsInt()
            ));
        }
    }
}
