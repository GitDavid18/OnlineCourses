package com.codewithmosh.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	
	private List<Memento> states = new ArrayList<>(); 

	
	public void push(Memento state) {
		states.add(state);
	}
	
	public Memento pop(){
		Memento ret = states.get(states.size() - 1);
		states.remove(ret);
		
		return ret;
	}
}
