package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.Stack;
import edu.grinnell.csc207.linear.LinkedStack;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Mina Bakrac and Leo Goldman
 */ 
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+
    
  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) {
    Stack<Character> parens = new LinkedStack<Character>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(' || ch == '[') {
        try {
          parens.push(ch);
        } catch (Exception e) {
          // Do nothing
        }
      } else if (ch == ')' || ch == ']') {
        char c;
        try {
          c = parens.pop();
        } catch (Exception e) {
          return false;
        }
        if ((c != '(' && ch == ')') || (c != '[' && ch == ']')) {
          return false;
        }
      }
    }
    return parens.isEmpty();
  } // checkMatching
} // class StringUtils    

