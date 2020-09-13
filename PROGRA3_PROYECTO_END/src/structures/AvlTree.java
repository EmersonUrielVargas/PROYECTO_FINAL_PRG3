package structures;

import java.util.ArrayList;
import java.util.Comparator;

public class AvlTree<T>{
	
	private AvlTreeNode<T> root;
	private Comparator<T> comparator;
	
	public AvlTree(Comparator<T> comparator) {
		this.root= null;
		this.comparator = comparator; 
		
	}
	
	public T insert(T data) {
		AvlTreeNode<T> newNode = new AvlTreeNode<T>(data);
		if (isEmpty()) {
			this.root = newNode;
		}else if (!exist(data)) {
			insert(newNode, root);
		}else{
			return null;
		}
		return newNode.getData();
	}
	
	private T insert(AvlTreeNode<T> newNode, AvlTreeNode<T> node) {
		if (comparator.compare(node.getData(), newNode.getData()) == -1) {
			if (node.getRight() == null) {
				System.out.println(newNode.getData().toString());
				node.setRight(newNode);
				refreshBalaceFactor(node);
			}else {
				System.out.println(newNode.getData().toString());
				insert(newNode, node.getRight());
			}
		} else if (comparator.compare(node.getData(), newNode.getData()) == 1) {
			if (node.getLeft() == null) {
				node.setLeft(newNode);
				refreshBalaceFactor(node);
			}else {
				insert(newNode, node.getLeft());
			}
		}
		return newNode.getData();
	}
	
	
	public boolean exist(T data){
		boolean exist = false;
		AvlTreeNode<T> node = root;
		while (node != null) {
			if (comparator.compare(data, node.getData())==0) {
				exist = true;
				node = null;
			}else {
				if (comparator.compare(data, node.getData()) == 1) {
					node = node.getRight();
				}else {
					node= node.getLeft();
				}
			}
		}
		return exist;
	}
	
	public T getData(T data){
		AvlTreeNode<T> node = root;
		T dataGet = null;
		while (node != null) {
			if (comparator.compare(data, node.getData())==0) {
				dataGet = node.getData();
				node = null;
			}else {
				if (comparator.compare(data, node.getData()) == 1) {
					node = node.getRight();
				}else {
					node= node.getLeft();
				}
			}
		}
		return dataGet;
	}
	
	private void refreshBalaceFactor(AvlTreeNode<T> node) {
		if(node != null) {
			int heightLeft= calculateHeight(node.getLeft());
			int heightRight= calculateHeight(node.getRight());
			node.setBalanceFactor(heightRight - heightLeft);
			if (-1 > node.getBalanceFactor() || 1> node.getBalanceFactor()) {
				checkBalanceFactor(node);
			}
		}
		
	}
	
	private void checkBalanceFactor(AvlTreeNode<T> node){
		if (node.getBalanceFactor() == 2) {
			if (node.getRight().getBalanceFactor() == 0) {
				simpleRotateRight(node);
			}else {
				DoubleRotateLeft(node);
			}
		}else if (node.getBalanceFactor() == -2) {
			if (node.getRight().getBalanceFactor() == 0) {
				simpleRotateLeft(node);
			}else {
				DoubleRotateRight(node);
			}
		}
	}
	
	
	private int calculateHeight(AvlTreeNode<T> node) {
		int height = 0;
		return calculateHeight(node, height);
		
	}
	
	private int calculateHeight(AvlTreeNode<T> node, int height) {
		if(node != null) {
			height++;
			int heightLeft= 0;
			int heightRight= 0;
			heightLeft= calculateHeight(node.getLeft(), heightLeft);
			heightRight= calculateHeight(node.getRight(), heightRight);
			height= (height+Math.max(heightLeft, heightRight));
			height= height--;
		}
		return height;
	}
	
	public AvlTreeNode<T> simpleRotateLeft(AvlTreeNode<T> node){
		AvlTreeNode<T> nodeAux = node.getLeft();
		node.setLeft(nodeAux.getRight());
		nodeAux.setRight(node);
		node = nodeAux;
		refreshBalaceFactor(node);
		refreshBalaceFactor(nodeAux);
		
		return nodeAux;
	}
	
	public AvlTreeNode<T> simpleRotateRight(AvlTreeNode<T> node){
		AvlTreeNode<T> nodeAux = node.getRight();
		node.setRight(nodeAux.getLeft());
		nodeAux.setLeft(node);
		node = nodeAux;
		refreshBalaceFactor(node);
		refreshBalaceFactor(nodeAux);
		
		return nodeAux;
	}
	
	public AvlTreeNode<T> DoubleRotateRight(AvlTreeNode<T> node){
		AvlTreeNode<T> node1 = node.getLeft();
		AvlTreeNode<T> node2 = node.getRight();
		node.setLeft(node2.getRight());
		node2.setRight(node); 
		node1.setRight(node2.getLeft());
		node2.setLeft(node1);
		node = node2;
		
		refreshBalaceFactor(node1);
		refreshBalaceFactor(node2);
		refreshBalaceFactor(node);
		
		
		return node2;
	}
	
	public AvlTreeNode<T> DoubleRotateLeft(AvlTreeNode<T> node){
		AvlTreeNode<T> node1 = node.getRight();
		AvlTreeNode<T> node2 = node.getLeft();
		node.setRight(node2.getLeft());
		node2.setLeft(node); 
		node1.setLeft(node2.getRight());
		node2.setRight(node1);
		node = node2;
		
		refreshBalaceFactor(node);
		refreshBalaceFactor(node1);
		refreshBalaceFactor(node2);
		
		return node2;
	}
	
	
	
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	
	public T remove(T dataRemove){
		T dataEliminate = null;
		if (exist(dataRemove)) {
			dataEliminate = dataRemove;
			AvlTreeNode<T> node = root;
			remove(node,dataRemove);
		}
		return dataEliminate;
	}

	private AvlTreeNode<T> remove(AvlTreeNode<T> node, T dataRemove){
		if (comparator.compare(node.getData(), dataRemove) == -1) {
			AvlTreeNode<T> right = remove(node.getRight(), dataRemove);
			//node.setRight(right);
		} else if (comparator.compare(node.getData(), dataRemove) == 1) {
			AvlTreeNode<T> left = remove(node.getLeft(), dataRemove);
			//node.setLeft(left);
		} else {
			AvlTreeNode<T> equal = node;
			if (equal.getLeft() == null) {
				node = equal.getRight();
			}else if (equal.getRight() == null) {
				node = equal.getLeft();
			}else {
				equal = replace(equal);
			}
		}
		refreshBalaceFactor(node);
		return node;
	}

	private AvlTreeNode<T> replace(AvlTreeNode<T> node) {
		AvlTreeNode<T> father = node;
		AvlTreeNode<T> majorNode = node.getLeft();
		while (majorNode.getRight() != null) {
			father = majorNode;
			majorNode = majorNode.getRight();
		}
		node.setData(majorNode.getData());
		if (comparator.compare(father.getData(), node.getData()) == 0)
			father.setLeft(majorNode.getLeft());
		else
			father.setRight(majorNode.getLeft());
		return majorNode;
	}
	
	
	public ArrayList<T> getDataInOrder() {
		return getDataInOrder(root);
	}
	
	private ArrayList<T> getDataInOrder(AvlTreeNode<T> node) {
		ArrayList<T> listInOrder = new ArrayList<>();
		if (node != null) {
			getDataInOrder(node.getLeft());
			listInOrder.add(node.getData());
			getDataInOrder(node.getRight());
		}
		for (int i = 0; i < listInOrder.size(); i++) {
			System.out.println(listInOrder.get(i).toString());
		}
		return listInOrder;
	}
	
	
}