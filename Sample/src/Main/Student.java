package Main;

import java.util.Comparator;

public class Student implements Comparable<Student>{
	public String name;
	public int id;
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(this.id<o.id) return -1;
		if(this.id>o.id) return 1;
		
		return 0;
	}
	
	

}
