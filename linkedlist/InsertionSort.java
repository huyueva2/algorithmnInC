package linkedList;

import java.util.Random;

public class InsertionSort {
	public static Node sort(Node origin) {
		Node sortedList = new Node();
		sortedList.setNext(null);
		Node oriNode,oriNext,targetNode = null;
		for (oriNode  = origin.getNext(); oriNode != null; oriNode = oriNext) {
			oriNext = oriNode.getNext();
			for (targetNode = sortedList; targetNode.getNext() != null; targetNode = targetNode.getNext()) {
				if (oriNode.getItem() < targetNode.getNext().getItem()) {
					break;
				}
			}
				oriNode.setNext(targetNode.getNext());
				targetNode.setNext(oriNode);
		}
		return sortedList;
	}
	
	public static void main(String args[]) {
		Node origin = new Node();
		origin.setNext(new Node());
		Node lastNode = origin.getNext();
		lastNode.setNext(null);
		for (int i = 0; i < 20; i++) {
			lastNode.setItem(new Random().nextInt(30));
			Node newNode = new Node();
			lastNode.setNext(newNode);
			newNode.setNext(null);
			lastNode = newNode;
		}
		for (Node currentNode = origin; currentNode.getNext() != null; currentNode = currentNode.getNext()) {
			System.out.print(currentNode.getNext().getItem() + ",");
		}
		System.out.println();
		for (Node currentNode = sort(origin); currentNode.getNext() != null; currentNode = currentNode.getNext()) {
			System.out.print(currentNode.getNext().getItem() + ",");
		}
	}
}
