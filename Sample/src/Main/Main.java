package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student>s=new ArrayList<Student>();
		s.add(new Student("hemanth",1));
		s.add(new Student("ramesh",7));
		s.add(new Student("kiran",5));
		Collections.sort(s);
		
	}

}
