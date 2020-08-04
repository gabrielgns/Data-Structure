import java.util.Scanner;



public class MaxBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] elementos = scan.nextLine().split(" ");
		MaxBST max = new MaxBST();
		
		int[] arvore = new int[elementos.length];
		for(int i = 0; i < elementos.length; i++) {
			arvore[i] = Integer.parseInt(elementos[i]);
			max.add(arvore[i]);
		}
		
		System.out.println(max.max());
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
	
	public String max() {
		Node aux = root;
		String saida = "";
		while(aux != null) {
			if(aux.right == null)
				saida += aux.value;
				
			else
				saida += aux.value + " ";
			aux = aux.right;
		}
		return saida;
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
