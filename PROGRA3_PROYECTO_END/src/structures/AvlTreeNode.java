package structures;

public class AvlTreeNode<T> {
	
	private T data;
	private int balanceFactor;
	private AvlTreeNode<T> right;
	private AvlTreeNode<T> left;
	
	public AvlTreeNode(T data) {
		this.data= data;
		this.balanceFactor =0;
	}

	public T getData() {
		return data;
	}

	public AvlTreeNode<T> getRight() {
		return right;
	}
	
	public AvlTreeNode<T> getLeft() {
		return left;
	}

	public void setRight(AvlTreeNode<T> rigth) {
		this.right = rigth;
	}
	
	public void setLeft(AvlTreeNode<T> left) {
		this.left = left;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}
	public int getBalanceFactor() {
		return balanceFactor;
	}
	
	

}
