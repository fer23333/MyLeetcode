```
//    new一次就是在堆中创建一个新的对象。不new的话aaa直接在字符串常量中取值;
//    String s2 = "aaa"; 先在内存中寻找aaa，如果有，则将aaa的内存首地址指向了s1，
      如果没有则在堆中中创建一个新的对象。

//    String s1 = new String("aaa");//  
//    不管"aaa"在内存中是否存在，都会在堆中开辟新空间，将字符串"aaa"的内存首地址指向s1。


String a = "aaa";//   aaa在常量池中创建一个对象，将内存首地址指向了a
String b = "aaa";//    直接aaa已经存在的内存首地址指向b。
String c = new String("aaa");// 不管存在与否，在堆中创建1个空间，内存首地址与常量池中的地址完全不同
System.out.println(a==b);// true
System.out.println(a==c);// false
```
