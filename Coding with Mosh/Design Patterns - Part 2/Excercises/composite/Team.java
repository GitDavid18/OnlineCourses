package com.codewithmosh.composite;

import java.util.ArrayList;
import java.util.List;

public class Team {
  private List<Object> resources = new ArrayList<>();

  public void add(Object resource) {
    resources.add(resource);
  }

  public void deploy() {
    for (var resource : resources) {
      if (resource instanceof Truck)
        ((Truck)resource).deploy();
      else if (resource instanceof HumanResource)
        ((HumanResource)resource).deploy();
      else
        ((Team)resource).deploy();
    }
  }
}
