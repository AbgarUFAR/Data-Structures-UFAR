package homework3;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int data;
    private int parentId;
    private int id;
    private List<Node> children;

    public Node(int data, int parentId, int id) {
        this.data = data;
        this.parentId = parentId;
        this.id = id;
        this.children = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
