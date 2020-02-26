package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	@Test
	//testing that object is created 
	void testSimpleList() 
	{
		SimpleList list = new SimpleList();
		assertNotNull(list);
	}
	
	@Test
	//testing that the initial variables are set correctly
	void testSimpleList2() 
	{
		SimpleList list = new SimpleList();
		assertNotEquals(1,list.count());
	}
	
	@Test
	//testing that elements are added in correct sequence 
	void testAdd() 
	{
		
		SimpleList list = new SimpleList();
		
		//filling list
		list.add(8);	
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		assertEquals("1 2 3 4 5 6 7 8", list.toString());
		
	}
	
	@Test
	//checking if that no all elements will be added
	void testAddFail() 
	{
		
		SimpleList list = new SimpleList();
		
		//filling list
		list.add(12);
		list.add(11);
		list.add(10);
		list.add(9);
		list.add(8);	
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		assertNotEquals("1 2 3 4 5 6 7 8 9 10 11 12", list.toString());
		
	}

	@Test
	//testing removing from beginning end and middle of array
	void testRemove() 
	{
		
		SimpleList list = new SimpleList();
		
		//filling list
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		list.remove(5);
		
		list.remove(10);
		
		list.remove(1);
		
		assertEquals("2 3 4 6 7 8 9", list.toString());
	}
	
	@Test
	//checking that a element can be removed if added back to array
	void testRemoveFail() 
	{
		
		SimpleList list = new SimpleList();

		//filling list
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		
		//removing last added item
		list.remove(5);
		
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		//removing 5 again 
		list.remove(5);
				
		assertNotEquals("1 2 3 4 6 5 7 8 9 10", list.toString());
	}

	@Test
	//checking that the count does not exced 10
	void testCount() 
	{
		
		SimpleList list = new SimpleList();

		//filling list
		list.add(11);
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		assertEquals(10, list.count());
		
	}

	
	@Test
	//checking that the count is updated after removing items 
	void testCountFail() 
	{
		
		SimpleList list = new SimpleList();

		//filling list
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		//removing two items from array
		list.remove(2);
		list.remove(1);
		
		assertNotEquals(10, list.count());
		
	}
	
	@Test
	//testing that a space is not added at the end
	void testToString() 
	{
	
		SimpleList list = new SimpleList();

		//filling list	
		list.add(12);
		list.add(11);
		list.add(10);
		list.add(9);
		list.add(8);
				 
		assertEquals("8 9 10 11 12", list.toString());
	}
	
	@Test
	//test that removed items are not added to string
	void testToStringFail() 
	{
		
		SimpleList list = new SimpleList();

		//filling list	 
		list.add(12);
		list.add(11);		
		list.add(10);		
		list.add(9);		
		list.add(8);			
		list.remove(9);
		
		assertNotEquals("8 9 10 11 12", list.toString());
	}
	
	
	@Test
	//testing that the search send back the correct index
	void testSearch() 
	{
	
		SimpleList list = new SimpleList();

		//filling list	
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		assertEquals(4, list.search(5));
	}

	@Test
	//testing that the search returns fails when element does not exist
	void testSearchFail() 
	{
	
		SimpleList list = new SimpleList();

		//filling list	
		list.add(10);
		list.add(9);
		list.add(8);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		assertNotEquals(8, list.search(11));
	}

}
