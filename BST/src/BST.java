import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] elementos = scan.nextLine().split(" ");
		BFS bfs = new BFS();
		
		int[] arvore = new int[elementos.length];
		for(int i = 0; i < elementos.length; i++) {
			arvore[i] = Integer.parseInt(elementos[i]);
			bfs.add(arvore[i]);
		}

		System.out.println(bfs.bfs());
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
	
	 public String bfs() {
	
	        String retorno = "";
	        Deque<Node> queue = new LinkedList<Node>();
	        queue.addLast(this.root);

	        while (!queue.isEmpty()) {
	            
	        	Node n = queue.removeFirst();
	        	if(n.value == max()) 
	        		retorno += n.value;
	        	
	        	else
	        		retorno += n.value + " ";
	            
	        	if (n.left != null) 
	        		queue.addLast(n.left);
	               	
	                    
	            
	        	if (n.right != null) 
	             	queue.addLast(n.right);
	                
	            }   
	        return retorno;
	    }

	
	public boolean isEmpty() {
		return root == null;
	}
	
	private int max() {
		Node aux = root;

		while(aux.right != null) {
			aux = aux.right;
		}
		return aux.value;
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
