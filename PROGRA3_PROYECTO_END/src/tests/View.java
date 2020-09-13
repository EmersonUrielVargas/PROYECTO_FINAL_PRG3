package tests;

import models.PartialNote;
import structures.NodeAVL;

public class View {
	
	public void showTreeInOrder(NodeAVL<PartialNote> auxiliar) {
		
		if(auxiliar!=null) {
			showTreeInOrder(auxiliar.getLeft());
			System.out.println(auxiliar.getData().toString());
			showTreeInOrder(auxiliar.getRigth());
		}
	}
	
	public void showTreeInOrder1(NodeAVL<String> auxiliar) {
		
		if(auxiliar!=null) {
			showTreeInOrder1(auxiliar.getLeft());
			System.out.println(auxiliar.getData().toString());
			showTreeInOrder1(auxiliar.getRigth());
		}
	}
	
	public void showTreePreOrder(NodeAVL<Integer> auxiliar) {
		
		if(auxiliar!=null) {
			System.out.println(auxiliar.getData().toString());
			showTreePreOrder(auxiliar.getLeft());
			showTreePreOrder(auxiliar.getRigth());
		}
	}
	
	public void showTreePostOrder(NodeAVL<Integer> auxiliar) {
		
		if(auxiliar!=null) {
			showTreePostOrder(auxiliar.getLeft());
			showTreePostOrder(auxiliar.getRigth());
			System.out.println(auxiliar.getData().toString());
		}
	}
}
