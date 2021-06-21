package com.codewithmoshDemos;

public class Main {
    public static void main(String[] args) {
    	User user = new User();
    	user.name = "David";
    	
    	System.out.println(user.name);
    	
    	
    	user = new User("Bla");
    	    	
    	System.out.println(user.name);
    	user.sayHello();
    	
    	
    	var account = new Account();
    	
    }
}