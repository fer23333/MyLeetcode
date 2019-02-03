# Heap

*heap remove是O(n) 寻找该数需要O(n) 但使用一个hashmap key: key, value: node value就可以*
heap构建需要o(n) 边new 边heapy 


Java Heap space is used by java runtime to allocate memory to Objects and JRE classes. 

Whenever we create any object, it’s always created in the Heap space.

Garbage Collection runs on the heap memory to free the memory used by objects that doesn’t have any reference. 

Any object created in the heap space has global access and can be referenced from anywhere of the application.

# stack

Java Stack memory is used for execution of a thread. 

They contain method specific values that are short-lived and references to other objects in the heap that are getting referred from the method.

Stack memory is always referenced in LIFO (Last-In-First-Out) order. 

Whenever a method is invoked, a new block is created in the stack memory for the method to hold local primitive values and reference to other objects in the method.

As soon as method ends, the block becomes unused and become available for next method.

Stack memory size is very less compared to Heap memory.


```
public class Memory {

	public static void main(String[] args) { // Line 1
		int i=1; // Line 2
		Object obj = new Object(); // Line 3
		Memory mem = new Memory(); // Line 4
		mem.foo(obj); // Line 5
	} // Line 9

	private void foo(Object param) { // Line 6
		String str = param.toString(); //// Line 7
		System.out.println(str);
	} // Line 8

}
```

<img src="https://cdn.journaldev.com/wp-content/uploads/2014/08/Java-Heap-Stack-Memory.png" alt="hi" class="inline"/>

# difference

1. Heap memory is used by all the parts of the application whereas stack memory is used only by one thread of execution.

2. Whenever an object is created, it’s always stored in the Heap space and stack memory contains the reference to it. Stack memory only contains local primitive variables and reference variables to objects in heap space.

3. Objects stored in the heap are globally accessible whereas stack memory can’t be accessed by other threads.

4. Memory management in stack is done in LIFO manner whereas it’s more complex in Heap memory because it’s used globally. Heap memory is divided into Young-Generation, Old-Generation etc, more details at Java Garbage Collection.

5 .Stack memory is short-lived whereas heap memory lives from the start till the end of application execution.

6. We can use -Xms and -Xmx JVM option to define the startup size and maximum size of heap memory. We can use -Xss to define the stack memory size.

7. When stack memory is full, Java runtime throws java.lang.StackOverFlowError whereas if heap memory is full, it throws java.lang.OutOfMemoryError: Java Heap Space error.
8. Stack memory size is very less when compared to Heap memory. Because of simplicity in memory allocation (LIFO), stack memory is very fast when compared to heap memory.
