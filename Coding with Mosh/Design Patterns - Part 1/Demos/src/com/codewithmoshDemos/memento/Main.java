package com.codewithmoshDemos.memento;

public class Main {
	public static void main (String args[]) {
		Editor_Dave<String> edi = new Editor_Dave<String>();
		var history = new History_Dave<String>();
		
		edi.setContent("A");
		history.push(edi.createState());
		
		edi.setContent("b");
		history.push(edi.createState());
		edi.setContent("cc");
		
		edi.restore(history.pop());
		edi.restore(history.pop());
		
		System.out.println(edi.getContent());
		
	}

}
