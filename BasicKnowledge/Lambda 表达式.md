```
ist.forEach((String s) -> System.out.println("*" + s + "*"));  可以省略 string这个定义

List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
int factor = 2;
primes.forEach(element -> { System.out.println(factor*element); }); 
```

多条件排序
```

humans.sort((lhs, rhs) -> {
    if (lhs.getName().equals(rhs.getName())) {
        return lhs.getAge() - rhs.getAge();
    } else {
        return lhs.getName().compareTo(rhs.getName());
    }
});

humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
        
```

