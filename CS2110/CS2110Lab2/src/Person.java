import java.util.ArrayList;


public class Person {
	private ArrayList<String> movieList;
	private String name;
	
	public Person(String name){
		this.name = name;
		movieList = new ArrayList<String>();
	}
	
	public int watch(String movieName){

		movieList.add(movieName);


		int total = movieList.size();
		return total;
	}
	
}
