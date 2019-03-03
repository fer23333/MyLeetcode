# replace和replaceAll 区别

replace() 和replaceAll() 都是查找出所有匹配字符并替换之。不同点是replaceAll() 的参数是正则表达式，而replace() 是普通字符。

replace的参数是char和CharSequence,即可以支持字符的替换,也支持字符串的替换(CharSequence即字符串序列的意思,也就是字符串);

replaceAll的参数是regex,即基于正则表达式的替换,比如,可以通过replaceAll("\d", "")把一个字符串所有的数字字符都换成;
对于<([{\^-=$!|]})?*+.> 都需要使用转义负号

## 例子

```
String path = "D:\\downloads\\test\\renmian";
```
1. 将路径中的' \ '替换为' \ '
```
String result1 = path.replace("\\", "\\\\");
String result2 = path.replaceAll("\\\\", "\\\\\\\\");
```
2. 分割多个空格
```
如果需要分割多个空格就使用加号 String[] str=s.split("\\s+");
会保留第一个空格 再split
" 1 2  3 4 5"-> 空格 1 2 3 4 5
```
3. 分割 全部字符出来
```
"Bob hit a ball, the hit BALL flew far after it was hit."

String[] s = paragraph.toLowerCase().replaceAll("^[a-z]", " ").split("\\s+");
```
如果使用^[a-z] 会认为 ball1 或者 ball, 也是字符 -> 适合对单个string使用

```
String[] s = paragraph.toLowerCase().split("[ !?',;.]+");
或者
String[] s = paragraph.toLowerCase().replaceAll("[ !?',;.]", " ").split("\\s+");
```
