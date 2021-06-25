package com.codewithmosh.iterator;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
  private List<Product> products = new ArrayList<>();

  public void add(Product product) {
    products.add(product);
  }

  public IIterator createIterator() {
    return new MyListIterator(this);
  }

  public class MyListIterator implements IIterator {
    private ProductCollection allProducts;
    private int index = 0;

    public MyListIterator(ProductCollection allProds) {
      allProducts = allProds;
    }

    @Override
    public void next() {
      index++;
    }

    @Override
    public boolean hasNext() {
      return index < allProducts.products.size();
    }

    @Override
    public Object current() {
      return allProducts.products.get(index);
    }
  }
}
