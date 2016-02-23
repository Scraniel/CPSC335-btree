package cpsc335a2;

public class Bnode {

	int keys[];
	int numEntries;
	Bnode pointers[];
	Bnode parent;
	
	
	public Bnode()
	{
		keys = new int[4];
		pointers = new Bnode[5];
		numEntries = 0;
	}
	
	public boolean insert(int key)
	{
		if(numEntries == 5)
			return false;
		
		// Find next biggest key
		int i;
		for(i = 0; i < numEntries; i++)
		{
			if(key < keys[i])
				break;
		}
		
		// Move down tree until we're at a leaf
		if(pointers[0] != null)
		{
			return pointers[i].insert(key);
		}
		// We're at a leaf, so insert
		else
		{
			shiftDown(keys, i);
			keys[i] = key;
			numEntries++;
			return true;
		}
	}
	
	private void shiftDown(int keys[], int start)
	{
		// Move values
		for(int j = numEntries - 1; j >= start && j >= 0; j--)
			keys[j + 1] = keys[j];
	}
	
	// Split the child node and move a key up
	public void overflow(int key)
	{
		int values[] = new int[5];
		int i;
		boolean inserted = false;
		for(i = 0; i < numEntries; i++)
		{
			if(key < keys[i] && !inserted)
			{
				values[i] = key;
				inserted = true;
				i--;
			}
			else
				values[i] = keys[i];
		}
		
		//index 0 and 1 go in left, 2 moves up, 3 and 4 go right.
		// HOW THE SHIT DO I CONNECT THE POINTERS
		
	}
	
	
	
	public void print()
	{
		print(0);
	}
	private void print(int layer)
	{
		for(int i = 0; i < pointers.length; i++)
		{
			if(pointers[i] != null)
				pointers[i].print(layer++);
			if(i < pointers.length - 1)
			{
				for(int j = 0; j < layer; j++)
					System.out.print("\n\t");
				System.out.print(keys[i]);
			}
		}
	}
}
