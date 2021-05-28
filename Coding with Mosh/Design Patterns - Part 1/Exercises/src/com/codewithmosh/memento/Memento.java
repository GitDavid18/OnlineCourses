package com.codewithmosh.memento;

public class Memento {
	
	private final String content;
	private final String font;
	private final int fontSize;
	
	public Memento(String content, String font, int fontSize) {
		super();
		this.content = content;
		this.font = font;
		this.fontSize = fontSize;
	}

	
	public String getContent() {
		return content;
	}

	public String getFont() {
		return font;
	}

	public int getFontSize() {
		return fontSize;
	}

	
}
