package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {

        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test peek on an empty stack ")
    public void testPeekEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        //when we peek the stack, should throws an  EmptyStackException.
        assertThrows(EmptyStackException.class, stack::peek, "");

    }

    @Test
    @DisplayName("test pop on an stack ")
    public void testPop() {

        // Given an empty stack and   7 item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();
        Item item2 = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);
        stack.push(item2);


        //when we pop the stack
        try{
            assertEquals(item2,stack.pop(),"");
            assertEquals(1,stack.getSize(),"");
        }catch(EmptyStackException e){
            System.err.println(e);
        }

    }

    @Test
    @DisplayName("Test popping elements until stack is empty")
    public void testPopUntilEmpty() throws EmptyStackException {
        // Given a stack with multiple elements
        Stack stack = new SimpleStack();
        Item item1 = new SimpleItem();
        Item item2 = new SimpleItem();

        stack.push(item1);
        stack.push(item2);

        // When popping all elements
        assertEquals(item2, stack.pop(), "First pop should return last pushed item");
        assertEquals(item1, stack.pop(), "Second pop should return first pushed item");

        // Then the stack should be empty
        assertTrue(stack.isEmpty(), "Stack should be empty after popping all elements");
        assertEquals(0, stack.getSize(), "Stack size should be 0 after popping all elements");

        // And trying to pop should throw an exception
        assertThrows(EmptyStackException.class, stack::pop, "Popping an empty stack should throw exception");
    }

    @Test
    @DisplayName("Test peek after multiple push and pop operations")
    public void testPeekAfterOperations() throws EmptyStackException {
        // Given a stack with multiple elements
        Stack stack = new SimpleStack();
        Item item1 = new SimpleItem();
        Item item2 = new SimpleItem();

        stack.push(item1);
        stack.push(item2);

        // When peeking after multiple operations
        assertEquals(item2, stack.peek(), "Peek should return the last pushed item");

        stack.pop(); // Remove item2

        assertEquals(item1, stack.peek(), "Peek should now return the second last pushed item");
    }

    @Test
    @DisplayName("Test size updates correctly after push and pop")
    public void testStackSize() throws EmptyStackException {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When pushing items
        stack.push(new SimpleItem());
        assertEquals(1, stack.getSize(), "Stack size should be 1 after one push");

        stack.push(new SimpleItem());
        assertEquals(2, stack.getSize(), "Stack size should be 2 after two pushes");

        // When popping items
        stack.pop();
        assertEquals(1, stack.getSize(), "Stack size should be 1 after one pop");

        stack.pop();
        assertEquals(0, stack.getSize(), "Stack size should be 0 after popping all items");
    }

    @Test
    @DisplayName("Test pushing null item into the stack")
    public void testPushNullItem() throws EmptyStackException {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When pushing null
        stack.push(null);

        // Then the stack should contain one element, which is null
        assertFalse(stack.isEmpty(), "Stack should not be empty after pushing null");
        assertEquals(1, stack.getSize(), "Stack size should be 1 after pushing null");
        assertNull(stack.peek(), "The top element should be null");
    }


}