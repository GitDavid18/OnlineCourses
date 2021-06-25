package com.codewithmosh.iterator;

public class Iterator_Main {

    public static void main(String[] args) {
        ProductCollection prods = new ProductCollection();

        var collection = new ProductCollection();
        collection.add(new Product(1, "a"));
        collection.add(new Product(2, "b"));
        collection.add(new Product(3, "c"));


        var iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.current().toString());
            iterator.next();
        }

    }

}
