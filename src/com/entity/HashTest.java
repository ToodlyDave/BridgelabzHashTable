package com.entity;

public class HashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "To be or not to be";
		String words[] = str.split(" ");
		HashTable hash = new HashTable(words.length);
		for (String word : words) {
			hash.put(word.toLowerCase());
		}
		System.out.println(" end of program");
		
	}

}
