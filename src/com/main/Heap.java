package com.main;
import java.util.ArrayList;

/**
 * Generic heap class
 * @author Deron Washington II
 * Last Update: 10/31/19 at 5:00pm
 *
 */
public class Heap < T extends Comparable<T>>
{
	/** private data member */
	private ArrayList <T>heap;

	/** public methods */
	public Heap()
	{
		heap = new ArrayList<T>();
	}

	/**
	 * Method to return size
	 * @return size of heap
	 */
	public int size()
	{
		return heap.size();

	}

	/**
	 * Method to return if heap is empty or not
	 * @return true if empty
	 * 				 false otherwise
	 */
	public boolean isEmpty()
	{
		return heap.isEmpty();

	}

	/**
	 * Method to return current node
	 * @return current node
	 */
	public T getCurrent() 
	{
		return heap.get( 0 );
	}

	/**
	 * Method to get node at index
	 * @param i = index
	 * @return node at index i
	 */
	public T get(int i )
	{
		return heap.get(i);
	}

	/**
	 * Method to return index of parent
	 * @param i = current node
	 * @return index of parent of index i
	 */
	private int getPLoc(int i)
	{
		return (i - 1) / 2;


	}

	/**
	 * Method to return the index of LC
	 * @param i = index of parent node
	 * @return index of LC
	 */
	private int getLCLoc(int i)
	{
		return 2 * i + 1;


	}

	/**
	 * Method to return the index of RC
	 * @param i = index of parent node
	 * @return index of RC
	 */
	private int getRCLoc(int i)
	{
		return 2 * i + 2;

	}

	/**
	 * Method to add Item to the Heap
	 * @param i = node 
	 */
	public void addItem(T i)
	{
		heap.add(i);
		int index = heap.size() - 1;

		while(index > 0 && heap.get(getPLoc(index)).compareTo( i ) > 0 )
		{
			heap.set(index, heap.get(getPLoc(index)));
			index = getPLoc(index);

		}

		heap.set( index, i);

	}

	/**
	 * Method to override toString method
	 */
	@Override
	public String toString( ) 
	{
		//returns string in tree order not sorted orderString 
		String s = "";
		for( int i=0; i<heap.size(); i++ ) 
		{
			s += heap.get( i ) + " ";

		}

		return s;

	}

	/**
	 * Method to remove Item
	 * @return node removed
	 */
	public T removeItem()
	{
		T min = heap.get(0);
		int index = heap.size()-1;
		T last = heap.remove(index);

		if(index > 0)
		{
			heap.set(0, last);
			T root = heap.get(0);
			int end = heap.size()-1;
			index = 0;
			boolean done = false;

			while(!done)
			{
				//check if left exists
				if(getLCLoc(index)<=end)
				{
					T child = heap.get(getLCLoc(index));
					int childLoc = getLCLoc(index);


					//check if right exists
					if(getRCLoc(index)<=end)
					{
						if(heap.get(getRCLoc(index)).compareTo(child) < 0)
						{
							child = heap.get(getRCLoc( index));
							childLoc = getRCLoc(index);
						}

					}

					if(child.compareTo(root) < 0)
					{
						heap.set(index, child);
						index = childLoc;

					}

					else
					{
						done = true;

					}
				}
				else
				{
					//no children
					done = true;
				}

			}
			heap.set(index, root);
		}
		return min;

	}
}


