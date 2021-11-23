/*
Author:      Christian Johansson (cjohansson@muhlenberg.edu)
Date:        10/30/2021
Instructor:  Professor Silveyra
Description: The Stack interface provided by professor Silveyra
*/

public interface StackInterface<T>{
  public void push(T number);
  public T pop();
  public T peek();
  public boolean isEmpty();
  public boolean isFull();
}
