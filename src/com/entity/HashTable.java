package com.entity;

public class HashTable {

	private static class ArrayNode {
		Object value;
		ArrayNode next;
	}
	
	ArrayNode[] table;
	
	int count;
	
	public HashTable(int initialSize) {
		// TODO Auto-generated constructor stub
		table = new ArrayNode[initialSize];
	}
	
	public void put(Object value) {
		
		int bucket = hash(value);
		ArrayNode arrayNode = table[bucket];
		System.out.println(" inserting \"" + value + "\" at " + bucket);
		if (arrayNode != null) {
			while(arrayNode.next != null) {
				arrayNode = arrayNode.next;
			}
			ArrayNode node = new ArrayNode();
			node.value = value;
			arrayNode.next = node;
		}
		else {
			arrayNode = new ArrayNode();
			arrayNode.value = value;
			arrayNode.next = null;
			table[bucket] = arrayNode;
		}
		
		display();
			
	}
	
	public int hash(Object key) {	
		System.out.println(" the hash: " + key.hashCode() + " " + key.hashCode() % table.length);
		return Math.abs(key.hashCode()) % table.length;
	}
	
	public void display() {
		for (ArrayNode arrayNode : table) {
			if(arrayNode == null)
				System.out.println(" null");
			else {
				while(arrayNode != null) {
					System.out.print(" " + arrayNode.value);
					arrayNode = arrayNode.next;
				}
				System.out.println();
			}
		}
		System.out.println();
	}
}
