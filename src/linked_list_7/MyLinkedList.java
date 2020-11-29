package linked_list_7;

public class MyLinkedList<T> {

	Node<T> head;
	Node<T> tail;
	int count;
	
	public MyLinkedList()
	{
		head = null;
		count = 0;
		tail = null;
	}


	public void addFirst(T data)
	{
		Node<T> add = new Node<T>(data);

		if (tail == null)
		{	
			head = tail = add;
		}
		else 
		{
			add.next = head;
			head = add;
		}

		count++;
	}	

	public void addLast(T data) 
	{
		Node<T> add = new Node<T>(data);

		if (tail == null) 
		{
			head = tail = add;
		}
		else 
		{
			tail.next = add;
			tail = tail.next;
		}

		count++;
	}

	public void add(int index, T data)
	{
		// index can be equal to 0: add new node at the beginning of the list
		// index can be equal to the count of nodes: add new node at the end of the list - note "index > count"
		if (index < 0 || index > count)
		{	
			throw new IndexOutOfBoundsException();
		}

		if (index == 0)
		{
			addFirst(data);
			return;
		}
		
		if (index == count)
		{
			addLast(data);
			return;
		}

        Node<T> current = head, add = new Node<T>(data);
        
		for(int i = 0; i < count; i++)
		{
			if (i == index - 1)
			{
				break;
			}
			current = current.next;
		}

		add.next = current.next;
		current.next = add;
		
		count++;
	}

	public T removeFirst()
	{
		if (count <= 0)
		{
			throw new IndexOutOfBoundsException();
		}

		Node<T> item = head;
		head = head.next;
		count--;
		
		if (count == 0)
		{
			tail = null;
		}
		
		return item.data;
	}
	
	public T remove(int index) 
	{
		// index can be equal to 0: delete the node at the beginning of the list
		// index can be equal to the count-1: delete the end of the list  - note "index >= count"
		if (index < 0 || index >= count)
		{	
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0)
		{
			return removeFirst();
		}
		
        Node<T> current = head, prev = null;
        
		for(int i = 0; i < count; i++)
		{
			if (i == index)
			{
				break;
			}
			prev = current;
			current = current.next;
		}

		prev.next = current.next;
		
		if (index == count - 1)
		{
			tail = prev.next;
		}

		count--;
		
		return current.data;
	}
	
	
	public T get(int index)
	{
		if (index < 0 || index >= count)
		{
			throw new IndexOutOfBoundsException();
		}

		Node<T> current = head;

		for(int i = 0; i < count; i++)
		{
			if (i == index)
			{
				break;
			}
			current = current.next;
		}

		return current.data;
	}
	
	public void clear()
	{
		head = null;
		tail = null;
		count = 0;
	}
	
	public int size()
	{
		return count;
	}
	
	public String toString()
	{
		String str = "";
		Node<T> current = head;
		
		while(current != null)
		{
			str += current.toString();
			if (current.next != null)
			{
				str += "\n";
			}
			current = current.next;
		}

		return str;
	}
}

class Node<T>
{
	public T data;
	public Node<T> next;

	public Node()
	{
		data = null;
		next = null;
	}

	public Node(T data)
	{
		this.data = data;
		next = null;
	}

	public String toString()
	{
		String res = data.toString();
		return res;
	}
}
