# Array to ArrayList

1. Arrays.asList()
```
String[] geeks = {"Rahul", "Utkarsh", "Shubham", "Neelam"}; 
List<String> al = new ArrayList<String>(Arrays.asList(geeks)); 
```
2. Collections.addAll();
```
String[] geeks = {"Rahul", "Utkarsh", "Shubham", "Neelam"}; 

List<String> al = new ArrayList<String>(); 

 //adding elements of array to arrayList. 
Collections.addAll(al, geeks);
```

3.for loop

```
String[] geeks = {"Rahul", "Utkarsh", "Shubham", "Neelam"}; 
List<String> al = new ArrayList<String>(); 
for(String s : geeks){
  al.add(s);
}
```

# ArrayList to Array

1.Object 必须使用抽象类 不能实体化

```
List<Integer> al = new ArrayList<Integer>(); 
al.add(10); 
al.add(20); 
al.add(30); 
al.add(40); 

Integer[] objects = al.toArray();
```

2. T[] toArray(T[] arr)
```
List<Integer> al = new ArrayList<Integer>(); 
al.add(10); 
al.add(20); 
al.add(30); 
al.add(40); 

Integer[] arr = new Integer[al.size()]; 
arr = al.toArray(arr); 
```

3. for loop
