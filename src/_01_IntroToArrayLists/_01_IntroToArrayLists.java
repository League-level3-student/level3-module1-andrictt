package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
ArrayList <String> things = new ArrayList<String>();
		//2. Add five Strings to your list
things.add("a");
things.add("b");
things.add("c");
things.add("d");
things.add("e");
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < things.size(); i++) {
			String s = things.get(i);
			System.out.print(s);
		}
		System.out.println();
		//4. Print all the Strings using a for-each loop
		for (String s: things) {
			System.out.print(s);
		}
		System.out.println();
		//5. Print only the even numbered elements in the list.
		for (int i = 1; i < things.size(); i+= 2) {
			String s = things.get(i);
			System.out.print(s);
		}
		System.out.println();
		//6. Print all the Strings in reverse order.
		for (int i = things.size() - 1; i > 0; i--) {
			String s = things.get(i);
			System.out.print(s);
		}
		System.out.println();
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < things.size(); i++) {
			
			String s = things.get(i);
			if(s.contains("e")) {
			System.out.print(s);
			}
		}
		
	}
}
