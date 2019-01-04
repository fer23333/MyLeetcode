```Java
Java中默认的 equals方法实现如下：public boolean equals(Object obj) {
    return (this == obj);
}
而String类则覆写了这个方法,直观的讲就是比较字符是不是都相同。public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = count;
        if (n == anotherString.count) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = offset;
            int j = anotherString.offset;
            while (n-- != 0) {
                if (v1[i++] != v2[j++])
                    return false;
            }
            return true;
        }
    }
    return false;
}
```

1. 如果比较对象是值变量：只用==，equals()是不存在的。为毛？通俗点讲呢，equals()是个函数啊亲，
因为基本类型int float不是对象，根本就没有函数啊摔。再通俗点，int. equals(),这个写法你感受一下。。

2. 如果比较对象是引用型变量：就是我上面说的那个情况了。我觉得题主就是问这个的。     
==：比较两个引用是不是指向同一个对象实例。     
equals：那啥，所有的对象都是继承自Object这个大家都知道吧。然后equals()就是这里面的一个函数，然后那啥，

3. Object里的equals的实现就是直接调用了==操作。
所以如果这个时候你自定义了一个类，仅仅继承自Object且没有重写equals方法，那么其equals操作也是与Object类一样，仅仅是直接调用==操作。            
这个时候他俩没啥区别。当然这是废话，尼玛equals里面这时候本来就用的==，
这么说吧，这时候比较自定义类用equals和==是一样一样的，因为这个时候尼玛都是比较句柄地址， 
自定义的类是继承于object，而object中的equals就是用==来实现的。
参见上面那条。

4. 如果一个类重写过equals方法（或者继承自一个重写过equals方法的类，
那么效果与==操作就不一样了。其实我觉得这才是楼主真正要问的地方。这里参见最开始的回答。
另外，那啥，再加一句，instanceof 也是个好东西哇。你可以用他检查引用型变量是否属于某一个Class：
那啥，返回的也是true 或者false，跟c#里的is差不多的说。

举个例子，为某个应用定义一个User类，简单代码如下：
```java
public class User {
    private int id;

    public User(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}

一般在数据库中，用id标识用户的唯一身份。所以理解上ID相同的User为同一个User。如果接下来直接比较两个id相同的User对象，结果应该可以想到：

    User user1 = new User(1);
    User user2 = new User(1);
    System.out.println(user1.equals(user2));
结果是false,原因是没有覆写equals方法，导致使用的Object中默认的实现，通过==进行比较。现在加上覆写的equals方法，结果就是true了。

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    User other = (User) obj;
    if (id != other.id)
        return false;
    return true;
}
```
