package SWEA;

import java.util.ArrayList;

public class MyStack<T> {
	ArrayList<T> stack = new ArrayList<>();
	T top;

	public void add(T data) {
		stack.add(data);
		top = data;
	}

	public T pop() {
		if (!stack.isEmpty()) {
			T temp = top;
			stack.remove(stack.size()-1);
			if (!stack.isEmpty()) {
				top = stack.get(stack.size() - 1);
			} else {
				top = null;
			}
			return temp;
		} else {
			return null;
		}
	}

	public int size() {
		return stack.size();
	}

	public T peek() {
		return this.top;
	}

	public void clear() {
		stack.clear();
	}

	public boolean isEmpty() {
		if (stack.size() == 0)
			return true;
		else
			return false;
	}
}
