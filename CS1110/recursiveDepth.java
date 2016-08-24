import java.awt.Color;
import java.util.Random;
import java.util.Scanner;


public class recursiveDepth {
	private static int maxDepth = 10;
	
	private static Color[] colors = { Color.blue, Color.cyan, Color.green,
		Color.magenta, Color.orange, Color.pink, Color.red, Color.yellow };


	public static void recursiveDepth(Turtle turtle, int depth, double length, int xcall){
		// if the depth == the maxdepth (or however you do the base case check
		if (depth == maxDepth){
			   // return
			/*
			System.out.println(depth);
			
			if (depth == 7){
				turtle.setColor(Color.green);
			}
			if (depth == 8){
				turtle.setColor(Color.cyan);
			}
			if (depth == 9){
				turtle.setColor(Color.blue);
			}
			else{
				turtle.setColor(Color.pink);
			}
			*/
			turtle.forward(length);
			return;
		}
		
	
		if (xcall == 1){
			 // if (direction == 'X')
			   //    Do the X type recursion
			//Random rand = new Random();
			//int colorChoice = rand.nextInt(colors.length);
			//System.out.println(depth);


			xcall = 0;
			
			//turtle.setColor(Color.blue);

			recursiveDepth(turtle, depth + 1, length, xcall);
			turtle.left(60);
			xcall = 1;
			
			//turtle.setColor(Color.blue);

			recursiveDepth(turtle, depth + 1, length, xcall);
			turtle.left(60);
			xcall = 0;
			
			//turtle.setColor(Color.cyan);
			
			recursiveDepth(turtle, depth + 1, length, xcall);
		}
		else{
			//System.out.println(depth);

			  // else
			   //    Do the Y type recursion
			//Random rand = new Random();
			//int colorChoice = rand.nextInt(colors.length);
	
			xcall = 1;

			//turtle.setColor(Color.green);
			
			recursiveDepth(turtle, depth + 1, length, xcall);
			turtle.right(60);
			xcall = 0;
			
			//turtle.setColor(Color.blue);
			
			recursiveDepth(turtle, depth + 1, length, xcall);
			turtle.right(60);
			xcall = 1;
			
			//turtle.setColor(Color.blue);

			recursiveDepth(turtle, depth + 1, length, xcall);
			
			//turtle.setColor(Color.blue);

		}
		  
		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World myWorld = new World(900, 700, Color.black);
		myWorld.setTurtleSpeed(.001);
		Turtle turtle = new Turtle(myWorld, 0, 0);
		//turtle.setColor(Color.pink);
		turtle.setColor(Color.green);
		turtle.left(60);
		Scanner s = new Scanner (System.in);
		System.out.println("What level of recursive depth do you want? ");
		int depth = s.nextInt();
		depth = 10 - depth;
		turtle.setColor(Color.blue);

		recursiveDepth(turtle, depth, 5, 0);
		s.close();
	}

}
