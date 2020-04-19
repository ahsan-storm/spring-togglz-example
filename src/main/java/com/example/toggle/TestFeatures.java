package com.example.toggle;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum TestFeatures implements Feature {
  @Label("Toggle for getting all books")
  GET_BOOKS_TOGGLE,

  @Label("Toggle for deleting all books")
  DELETE_BOOK_TOGGLE
}
