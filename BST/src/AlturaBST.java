import java.util.Arrays;
import java.util.Scanner;


public class AlturaBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] elementos = scan.nextLine().split(" ");
		AlturaBST altura = new AlturaBST();
		
		int[] arvore = new int[elementos.length];
		for(int i = 0; i < elementos.length; i++) {
			arvore[i] = Integer.parseInt(elementos[i]);
			altura.add(arvore[i]);
		}
		
		System.out.println(altura.height());
		
	}
	
	private Node root;

	public void add(int elemento) {
		Node newNode = new Node(elemento);
		
		if(isEmpty())
			root = newNode;
		
		else {
			
			Node aux = root;
			while(aux != null) {
			
				if(elemento < aux.value) {	
			
					if(aux.left == null) {
					
						aux.left = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.left;
				}
				
				else {
					
					if(aux.right == null) {
						
						aux.right = newNode;
						newNode.parent = aux;
						return;
					}
					aux = aux.right;
				}
			}
		}
	}
	

	public int height() {
		return this.height(root);
	}

	private int height(Node node) {
		int result = -1;
		if (node != null) {
			result = 1 + Math.max(height(node.left), height(node.right));
		}
		return result;
	}
    
	public boolean isEmpty() {
		return root == null;
	}

	class Node {

	    int value;
	    Node right;
	    Node left;
	    Node parent;

	    Node(int value) {
	    	this.value = value;
	    }
	}
}
