package org.example;

public class SimpleStack implements Stack {

    private Item[] stack;

    public SimpleStack() {
        stack = new Item[0];
    }


    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return this.stack.length == 0;
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return this.stack.length;
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(Item item) {
        Item[] newStack = new Item[this.stack.length + 1];
        for (int i = 0; i < this.stack.length; i++) {
            newStack[i] = this.stack[i];
        }
        newStack[this.stack.length] = item;
        this.stack = newStack;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stack[this.stack.length - 1];
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Item[] newStack = new Item[this.stack.length - 1];
        for (int i = 0; i < this.stack.length - 1; i++) {
            newStack[i] = this.stack[i];
        }
        Item item = this.stack[this.stack.length - 1];
        this.stack = newStack;
        return item;
    }
}
