package linked_list_7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListTester
{
	public static void main(String[] args)
	{
		try
		{
			MyLinkedList<Actor> list = new MyLinkedList<Actor>();

			File file = new File("C:\\Users\\Atanas Hristov\\eclipse-workspace\\fhs-java\\src\\linked_list_7\\actors7.txt");
			Scanner scanner = new Scanner(file);
	
			// Part 1: Load 8 names from the file
			for (int i=0; i < 4; i++)
			{
				list.addFirst(new Actor(scanner.nextLine()));
				list.addLast(new Actor(scanner.nextLine()));
			}

			// Part 2: Print data from the list
			System.out.println(list.size());
			System.out.println(list);
			
			// Part 3: manipulate and print the list
			int i = 0;

			// add & remove - first
			i = Integer.parseInt(scanner.nextLine());
			list.add(i, new Actor(scanner.nextLine()));
			
			i = Integer.parseInt(scanner.nextLine());
			list.remove(i);

			// add & remove - second
			i = Integer.parseInt(scanner.nextLine());
			list.add(i, new Actor(scanner.nextLine()));
			
			i = Integer.parseInt(scanner.nextLine());
			list.remove(i);
			
			System.out.println(list.size());
			System.out.println(list);			

			scanner.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
