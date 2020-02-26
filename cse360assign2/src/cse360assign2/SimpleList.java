// Thomas Murphy
// class ID: 249
// Assignment 1
// Class to create and modify an array of integers it is designed to 
// count the number of elements, add elements to array, remove 
// elements from array, search for elements in the array, 
// and entering elements to a string

package cse360assign2;

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
			
			int[] temp = new int[10];
			
			//filling temporary array
			
			for(int index = 0; index <= count - 1; index++) 
			{
				temp[index] = list[index];
			}
			
			
			list[0] = InputInteger;
			
			//if count is less than 10 fills array with all elements in temporary array
			
			if(count < 10) 
			{
				for(int index = 0; index < count; index++) 
				{
					list[index + 1] = temp[index];
				}
				
				count++;
			}
			
			//When the count is 10 fills array with all but last element in temporary array 
			
			else 
			{
				for(int index = 0; index < count - 1; index++) 
				{
					list[index + 1] = temp[index];
				}
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
	
	
}
