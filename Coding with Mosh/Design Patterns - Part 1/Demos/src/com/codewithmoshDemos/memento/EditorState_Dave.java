package com.codewithmoshDemos.memento;


public class EditorState_Dave<T> {
	private final T content;
	
	public EditorState_Dave(T content) {
		this.content = content;
	}

	public T getContent() {
		return content;
	}
}
