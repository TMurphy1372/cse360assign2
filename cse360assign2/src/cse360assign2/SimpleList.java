// Thomas Murphy
// class ID: 249
// Assignment 2
// Class to create and modify an array of integers it is designed to 
// count the number of elements, add elements to array, remove 
// elements from array, search for elements in the array, 
// and entering elements to a string

//github Link: https://github.com/TMurphy1372/cse360assign2

package assign1;

public class SimpleList {

	//declaring array called list
	
	private int[] list;
	
	//declaring integer to count element is array 
	
	private int count; 
	
	//constructor
	
	public SimpleList() 
	{
		list = new int[10];
		count = 0; 
	}
	
	//Adds elements to array if array is full last element is dropped
	
	public void add(int InputInteger) 
	{
		//if the list is empty add first element and increase count by 1 
		
		if(count < 1) 
		{
			list[0] = InputInteger;
			
			count++;
		}
		else 
		{
			
			int[] temp = new int[((int) (count * 2))];
			
			//filling temporary array
			
			for(int index = 0; index <= count - 1; index++) 
			{
				temp[index] = list[index];
			}
			
			
			
			
			//if count is less than max amount in array fills array with all elements in temporary array
			
			if(count < list.length) 
			{
				list[0] = InputInteger;
				for(int index = 0; index < count; index++) 
				{
					list[index + 1] = temp[index];
				}
				
				count++;
			}
			
			//When the count is 10 fills array with all but last element in temporary array 
			
			else 
			{
				list = new int[((int) (count * 1.5))];
				list[0] = InputInteger;
				for(int index = 0; index < count; index++) 
				{
					
					list[index + 1] = temp[index];
				}
				
				count++;
			}
		}
	}
	
	//remove element from array if it exists 
	
	public void remove(int IntegerToRemove) 
	{
		
		int indexToRemove = search(IntegerToRemove);
		
		//checks that the element exists in array 
		
		if(indexToRemove != - 1) 
		{
			//starting at the index of integer to be removed each element is moved 
			//forward by one index
			
			for(int index = indexToRemove; index < count - 1; index++) 
			{
				list[index] = list[index + 1];
			}
						
			count--;
			
			if(list.length > count * 1.25) 
			{
				int[] temp = new int[((int) (count * 2))];
				
				//filling temporary array
				
				for(int index = 0; index <= count; index++) 
				{
					temp[index] = list[index];
				}
				
				list = new int[count];
				
				for(int index = 0; index < count; index++) 
				{
					
					list[index] = temp[index];
				}
			}
		}
	}
	
	//returns value of count 
	
	public int count() 
	{
		
		return count;
	}
	
	//adds all elements of array into string 
	
	public String toString() 
	{
		String stringOfInts = "";
		
		//goes through all elements in the array to add them to a string 
		
		for (int index = 0; index < count; index++) 
		{
			//when adding the last element the space is not added to the string
			
			if(index == count - 1) 
			{
				stringOfInts += list[index];
			}
			else 
			{
				stringOfInts += list[index] + " ";
			}
		}
		
		return stringOfInts;
	}
	
	//looks for an element in the array if it does not exist -1 is returned
	
	public int search(int IntegerToFind) 
	{
		int foundIndex = -1;
		
		
		for(int index = 0; index < count; index++) 
		{
			if(list[index] == IntegerToFind) 
			{
				foundIndex = index;
			}
		}
		
		return foundIndex;
	}
	
	//Adds element to the end of the array 
	public void append(int InputInteger) 
	{
		if(count < 1) 
		{
			list[0] = InputInteger;
			
			count++;
		}
		
		else if (count < list.length - 1) 
		{
			list[count] = InputInteger;
			
			count++;
		}
		else 
		{
			int[] temp = new int[((int) (count * 2))];
			
			//filling temporary array
			
			for(int index = 0; index < count; index++) 
			{
				temp[index] = list[index];
			}
			
			list = new int[((int) (count * 1.5))];
			
			for(int index = 0; index < count; index++) 
			{
				list[index] = temp[index];
			}
			
			list[count] = InputInteger;
			
			count++;
		}
		
	}

	
	//returns the first element in the list 
	public int first() 
	{
		int firstElement = -1;
		
		if(count > 0) 
		{
			firstElement = list[0];
		}
		
		return firstElement;
	}
	
	//returns the last element in the list
	public int last() 
	{
		int lastElement = -1;
		
		if(count > 0) 
		{
			lastElement = list[count - 1];
		}
		
		return lastElement;
		
	}
	
	//returns all the possible locations in the array 
	public int size() 
	{
		return list.length;
	}
}
