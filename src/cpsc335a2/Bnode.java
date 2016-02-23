package cpsc335a2;

public class Bnode {

	int keys[];
	Bnode pointers[];
	int numEntries;
	
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
			// Move values
			for(int j = numEntries - 1; j >= i && j >= 0; j--)
				keys[j + 1] = keys[j];
			keys[i] = key;
			
			numEntries++;
			return true;
		}
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
