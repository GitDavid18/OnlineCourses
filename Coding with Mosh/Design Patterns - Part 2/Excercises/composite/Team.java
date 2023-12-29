package com.codewithmosh.composite;

import java.util.ArrayList;
import java.util.List;

public class Team implements IResource {
  private List<IResource> resources = new ArrayList<>();

  public void add(IResource resource) {
    resources.add(resource);
  }

  public void deploy() {
    for (var resource : resources) {
        resource.deploy();
    }
  }
}
