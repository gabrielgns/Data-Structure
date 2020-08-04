import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BuscaBST {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] elementos = scan.nextLine().split(" ");
		int procurado = scan.nextInt();
		BuscaBST busca = new BuscaBST();
		
		int[] arvore = new int[elementos.length];
		for(int i = 0; i < elementos.length; i++) {
			arvore[i] = Integer.parseInt(elementos[i]);
			busca.add(arvore[i]);
		}
		
		System.out.println(Arrays.toString(busca.search(procurado)));
		
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
	
	public Object[] search(int element) {
		
		Node aux = root;
		List<Integer> retorno = new ArrayList<Integer>();
	
		while(aux != null) {
			
			if(aux.value == element) {
				retorno.add(aux.value);
				break;
			}
			
			else if(element < aux.value) {
				retorno.add(aux.value);
				aux = aux.left;
			}
			
			else if(element > aux.value) {
				retorno.add(aux.value);
				aux = aux.right;
			}
		}
		
		return retorno.toArray();
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
