public class BinaryTreeNode<T> {

    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    T data;
    BinaryTreeNode<T> next;
    public BinaryTreeNode(T data){
        this.data=data;
    }

    public BinaryTreeNode(T data,BinaryTreeNode<T> left,BinaryTreeNode<T> right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

}
