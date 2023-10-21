package src.main.java.topicwise.binary.trees;

// todo need to optimize more
public class SerializeAndDeserializeBinaryTree {

    StringBuilder dataBuilder = new StringBuilder();
    int index = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        serializeAndDeserializeBinaryTree.deserialize(serializeAndDeserializeBinaryTree.serialize(root));
    }

    public String serialize(TreeNode root) {
        return createSerializableObject(root);
    }

    private String createSerializableObject(TreeNode root) {
        if (root == null) {
            dataBuilder.append(" " + "N");
            return dataBuilder.toString().trim();
        }
        dataBuilder.append(" " + root.val);
        createSerializableObject(root.left);
        createSerializableObject(root.right);
        return dataBuilder.toString().trim();
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        return deserializeObject(arr);
    }

    private TreeNode deserializeObject(String[] arr) {
        if (arr[index].equals("N")) {
            index = index + 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(arr[index]));
        index = index + 1;
        node.left = deserializeObject(arr);
        node.right = deserializeObject(arr);
        return node;
    }
}
