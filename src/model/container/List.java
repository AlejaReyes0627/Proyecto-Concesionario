package model.container;


public class List<T> 
{
	private Node<T> root;


	public List() 
	{
		this.root = null;
	}



	public void add(T data) 
	{	
		Node<T> parametro = new Node<T>(data);
		if(root == null)
		{
			root = parametro;
			return;
		}
		Node<T> temporal = root;
		while(temporal.getNext() != null)
		{
			temporal = temporal.getNext();
		}
		temporal.setNext(parametro);

	}

	public void remove(T data)
	{

	        Node<T> cabecita = root;
	        Node<T> parametro = new Node<T>(data);
	        while (cabecita != null)
	        {
	            if (cabecita.getNext().getData() == parametro.getData())  ////getValor()
	            {
	                cabecita.setNext(cabecita.getNext().getNext());
	                return;
	            }
	            cabecita=cabecita.getNext();
	        }
	   
	}

	public void clear()
	{
		root = null;
	}

	public T get(int pNumber)
	{
		Node<T> vehicle = root;
		int count = 0;
		if(root != null)
		{
			while(vehicle != null)
			{
				if(count == pNumber)
				{
					break;
				}
				vehicle = vehicle.getNext();
				count++;
			}
		}
		return vehicle.getData();
	}

	public int size()
	{
	    Node<T> temporal = root;
        int contador = 0;

            while(temporal != null)
            {
                temporal = temporal.getNext();
                contador++;
            }

        return contador;
	}		

}


