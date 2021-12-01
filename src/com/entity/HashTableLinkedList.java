package com.entity;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTableLinkedList {
	
	private static class ListNode {
		LinkedList<String> node = new LinkedList<>();
		int something;
	}
	
	static ListNode [] table;
	
	public HashTableLinkedList(int size) {
		table = new ListNode[size];
	}
	
	public int hash(int key) {
		return Math.abs(key % table.length);
	}
	
	public void addWords(String [] words) {
		for (String word : words) {
			put(0, word);
		}
	}

	public void put(int key, String value) {
		int bucket = hash(key);
		
		if(table[bucket] == null) 
			table[bucket] = new ListNode();
			
		table[bucket].node.add(value);
	}
	
	public void countWords(String str) {
		addWords(str.toLowerCase().split(" "));
		ArrayList<String> tempArray = new ArrayList<String>();
		int count = 1;
		for (String word : table[0].node) {
			count = 0;
			if(tempArray.indexOf(word) == -1)
				tempArray.add(word);
			else 
				continue;
			for (String iterateWord : table[0].node) {
				if (word.equals(iterateWord)) {
					count++;
				}
			}
			System.out.println(" " + word + ": " + count );
			word = " ";
		}
	}
	
	public void display() {
		System.out.println(" ----Displaying hash table---- ");
		for (ListNode listNode : table) {
			if(listNode == null)
				System.out.println("null");
			else
				System.out.println(listNode.node);
		}
	}
	
}
