package com.codewithmosh.memento;

public class Exercise_Main {

	public static void main(String[] args) {
		Document doc = new Document();
		var history = new Caretaker();
		
		doc.setContent("This is my content");
		history.push(doc.createState());
		System.out.println(doc.toString());
		
		doc.setFontName("Italic Mimic");
		doc.setFontSize(15);
		
		history.push(doc.createState());
		
		System.out.println(doc.toString());
		
		doc.setContent("It's all new now.");
		
		history.push(doc.createState());
		
		System.out.println(doc.toString());
		
		doc.setFontName("Fresh SAN");
		doc.setFontSize(12);
		
		history.push(doc.createState());
		
		doc.restore(history.pop());
		System.out.println(doc.toString());
		
		doc.restore(history.pop());
		System.out.println(doc.toString());
		doc.restore(history.pop());
		System.out.println(doc.toString());
		doc.restore(history.pop());
		System.out.println(doc.toString());
		
//		doc.restore(history.pop());
		System.out.println(doc.toString());
		

	}

}
