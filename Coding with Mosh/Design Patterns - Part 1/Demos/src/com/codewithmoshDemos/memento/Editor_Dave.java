package com.codewithmoshDemos.memento;

public class Editor_Dave<T> {
	private T content;
	
	public EditorState_Dave<T> createState(){
		return new EditorState_Dave<T>(content);
	}
	
	public void restore(EditorState_Dave<T> state) {
		content = state.getContent();
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
