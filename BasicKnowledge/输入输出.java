System is a class and out is a public static field which accepts output data.
print 
println 会自动换行
printf it provides string formatting 
```
String s = "Hello World";
System.out.printf("The String object %s is at hash code %h%n", s, s);
```
The String object Hello World is at hash code cc969a84

//scanner
import java.util.Scanner; 
Scanner input = new Scanner(System.in);

System.out.print("Enter an integer: ");
int number = input.nextInt();
System.out.println("You entered " + number);

float myFloat = input.nextFloat();
double myDouble = input.nextDouble();
String myString = input.next();

//buffer reader and inputstreamerreader
import java.io.BufferedReader;
import java.io.InputStreamReader;
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s = br.readLine();
int i = Integer.parseInt(br.readLine());

//datainputstream
import java.io.DataInputStream;
DataInputStream dis = new DataInputStream(System.in);
int i = dis.readInt();
