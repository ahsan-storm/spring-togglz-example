package com.example.toggle;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

@RestController
public class BookController {

  private final FeatureManager featureManager;

  public BookController(FeatureManager featureManager) {
    this.featureManager = featureManager;
  }

  @GetMapping("/books")
  public String getBooks() {
    if (featureManager.isActive(TestFeatures.GET_BOOKS_TOGGLE)) {
      return "Return all books";
    } else {
      return "Toggle disabled for returning all books";
    }
  }

  @DeleteMapping("/books")
  public String deleteBook() {
    if (featureManager.isActive(TestFeatures.DELETE_BOOK_TOGGLE)) {
      return "All books deleted";
    } else {
      return "Toggle disabled for deleting all books";
    }
  }
}