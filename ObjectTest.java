package cn.io.study3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


/**
 * 对象流
 * 1，写出后读取
 * 2，读取的顺序与写出保持一致
 * 3，不是所有的对象都可以序列化Serializable
 * @author dell
 *
 */

public class ObjectTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		OutputStream os=new FileOutputStream("abc.txt");
		ObjectOutputStream oos=new ObjectOutputStream(os);
		oos.writeObject(new Student("aaa",12));
		oos.writeLong(12345);
		oos.flush();
		os.close();
		InputStream is=new FileInputStream("abc.txt");
		ObjectInputStream ois=new ObjectInputStream(is);
		Student p=(Student)ois.readObject();
		long data=ois.readLong();
		is.close();
		
		System.out.println(p+" "+data);
	}

}

class Student implements java.io.Serializable{
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
