
public class DoubleLinkedList {
	
	private Node head;

	public void addLast(int elemento) {
		
		if(isEmpty())
			this.head = new Node(elemento);
	
		else
			addLast(head, elemento);
	}
	
	private void addLast(Node node, int elemento) {
		
		if (node.next == null) {
			
			Node newNode = new Node(elemento);
			node.next = newNode;
			newNode.prev = node;
		
		} else 
			addLast(node.next, elemento);
		
	}

	public int size() {
		
		if(isEmpty())
			return 0;
		else
			return this.size() + 1;
	}

	public int soma() {
		return soma(head);
	}
	
	private int soma(Node node) {
		
		if(node == null) 
			return 0;
		
		else 
			return node.value + soma(node.next);
		
	}

	public boolean isSorted() {
	
		if(isEmpty())
			return true;
		
		else
			return isSorted(head);
	}
	
	private boolean isSorted(Node node) {
		
		if(node.next == null)
			return true;
		
		else if(node.next.value < node.value)
			return false;
		
		else
			return isSorted(node.next);
	}

	public void add(int index, int elemento) {
		
		if(index >= 0) {
			Node newNode = new Node(elemento);
			
			if(isEmpty())
				this.head = newNode;
			
			else if(index == 0) {
				head.prev = newNode;
				newNode.next = head;
				head = newNode;
			}
		
			else {
				int i = 1;
				Node aux = head;
				
				while(i < index) {
					aux = aux.next;
					i++;
				}
				
				newNode.next = aux.next;
				newNode.prev = aux;
				aux.next.prev = newNode;
				aux.next = newNode;
			}
		}
		
	}
	
	public void remove(int index) {
		
		if(!isEmpty() && index < size()) {
			
			if(index == 0) {
				this.head = head.next;
				head.prev = null;
			}
			
			else if(index == size()) {
				Node aux = head;
				
				while(aux.next != null)
					aux = aux.next;
				
				aux.prev.next = null;
			}
			else {
				int i = 1;
				Node aux = head;
				
				while(i < index) {
					aux = aux.next;
					i++;
				}
				
				aux.next = aux.next.next;
				aux.next.prev = aux;
			}
		}
	}
	
	private boolean isEmpty() {
		return head == null;
	}
}

class Node{
	
	protected int value;
	protected Node next;
	protected Node prev;
	
	Node(int value){
		this.value = value;
	}
	
}