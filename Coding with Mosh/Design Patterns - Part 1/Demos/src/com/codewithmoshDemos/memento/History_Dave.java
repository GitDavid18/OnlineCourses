package com.codewithmoshDemos.memento;

import java.util.ArrayList;
import java.util.List;

public class History_Dave<T> {
	List<EditorState_Dave<T>> states = new ArrayList<>();
	
	public void push(EditorState_Dave<T> state){
		states.add(state);
	}
	
	public EditorState_Dave<T> pop() {
		EditorState_Dave<T> ret = states.get(states.size() - 1);
		states.remove(ret);
		return ret;
	}

}
