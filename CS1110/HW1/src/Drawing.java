import java.awt.Color;
import java.io.IOException;

/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 11, 2013

*/
public class Drawing {
	public static void drawCircle (Turtle t){
		for (int i = 0; i < 30; ++i){
			t.forward(2);
			t.left(360/30);
		}
		}
	
	public static void main(String[] args) throws IOException {
	
		World tw = new World();
		Turtle t = new Turtle(tw);
		
		//TURTLE WITH SHELL SIZE 100
	
		//tail
		t.penUp();
		t.goTo(150,300);
		
		t.penDown();
		t.setWidth(5);
		t.setColor(Color.black);
		
		t.right(10);
		t.forward(60);
		t.left(100);
		t.forward(25);
		t.left(102);
		t.forward(60);
		
		
		//bot left leg
		t.penUp();
		t.goTo(250,415);
		
		t.penDown();
		t.left(160);
		t.forward(30);
		t.left(90);
		t.forward(35);
		t.left(75);
		t.forward(40);
		t.left(112);
		t.forward(46);
		
		
		//bot right leg
		t.penUp();
		t.goTo(400,415);
		
		t.penDown();
		t.left(90);
		t.forward(30);
		t.left(85);
		t.forward(50);
		t.left(120);
		t.forward(40);
		t.left(67);
		t.forward(33);
		
		
		//top left leg
		t.penUp();
		t.goTo(250,180);
		
		t.penDown();
		t.left(100);
		t.forward(30);
		t.right(90);
		t.forward(35);
		t.right(75);
		t.forward(40);
		t.right(112);
		t.forward(46);
		
		
		
		//top right leg
		t.penUp();
		t.goTo(400,180);
		
		t.penDown();
		t.right(95);
		t.forward(30);
		t.right(85);
		t.forward(50);
		t.right(120);
		t.forward(40);
		t.right(67);
		t.forward(33);
		
		
		//head
		t.penUp();
		t.goTo(470,300);
		
		t.penDown();
		t.left(20);
		t.forward(35);
		t.right(110);
		t.forward(30);
		t.right(10);
		t.forward(10);
		t.right(10);
		t.forward(10);
		t.right(10);
		t.forward(10);
		t.right(10);
		t.forward(10);
		t.right(20);
		t.forward(5);
		t.right(20);
		t.forward(10);
		t.right(20);
		t.forward(10);
		t.right(20);
		t.forward(5);
		t.right(10);
		t.forward(10);
		t.right(10);
		t.forward(10);
		t.right(10);
		t.forward(10);
		t.right(10);
		t.forward(10);
		t.right(20);
		t.forward(30);
		t.right(105);
		t.forward(35);
		
		//bottom eye
		t.penUp();
		t.goTo(505,320);
		
		t.penDown();
		drawCircle (t);
		
		//top eye
		t.penUp();
		t.goTo(505,290);
		
		t.penDown();
		drawCircle (t);
		
		
		//outer shell
		t.penUp();
		t.goTo(245,300);
		t.setWidth(75);
		t.setColor(Color.darkGray);
		t.left(18);
		
		
		t.penDown();
		
		for (int i = 0; i < 12; ++i){
			t.forward(4);
			t.right(5);
		}
		
		for (int i = 0; i < 10; ++i){
			t.forward(3);
			t.right(0);
		}
		
		for (int i = 0; i < 10; ++i){
			t.forward(5);
			t.right(3);
		}
		
		for (int i = 0; i < 10; ++i){
			t.forward(5);
			t.right(3);
		}
		
		for (int i = 0; i < 10; ++i){
			t.forward(3);
			t.right(0);
		}
		
		for (int i = 0; i < 12; ++i){
			t.forward(4);
			t.right(5);
		}
		
		for (int i = 0; i < 12; ++i){
			t.forward(4);
			t.right(5);
		}
		
		for (int i = 0; i < 10; ++i){
			t.forward(3);
			t.right(0);
		}
		
		for (int i = 0; i < 10; ++i){
			t.forward(5);
			t.right(3);
		}
		
		for (int i = 0; i < 10; ++i){
			t.forward(5);
			t.right(3);
		}
		
		for (int i = 0; i < 10; ++i){
			t.forward(3);
			t.right(0);
		}
		
		for (int i = 0; i < 12; ++i){
			t.forward(4);
			t.right(5);
		}
		
		
		//inner shell
		
				t.penUp();
				t.goTo(315,300);
				t.setWidth(95);
				t.setColor(Color.gray);
				
				t.penDown();
				
				drawCircle(t);
				
				t.penUp();
				t.goTo(335,310);
				t.setWidth(95);
				t.setColor(Color.gray);
				
				t.penDown();
				
				drawCircle(t);
				
				t.penUp();
				t.goTo(355,320);
				t.setWidth(95);
				t.setColor(Color.gray);
				
				t.penDown();
				
				drawCircle(t);
				
				
				t.penUp();
				t.goTo(375,310);
				t.setWidth(95);
				t.setColor(Color.gray);
				
				t.penDown();
				
				drawCircle(t);
				

				t.penUp();
				t.goTo(395,300);
				t.setWidth(95);
				t.setColor(Color.gray);
				
				t.penDown();
				
				drawCircle(t);
				
				t.penUp();
				t.goTo(335,290);
				t.setWidth(95);
				t.setColor(Color.gray);
				
				t.penDown();
				
				drawCircle(t);
				
				t.penUp();
				t.goTo(355,280);
				t.setWidth(95);
				t.setColor(Color.gray);
				
				t.penDown();
				
				drawCircle(t);
				
				
				t.penUp();
				t.goTo(375,290);
				t.setWidth(95);
				t.setColor(Color.gray);
				
				t.penDown();
				
				drawCircle(t);
				

		t.penUp();
		t.goTo(0,0);
		
		
		tw.saveAs("drawing.png");		
		
		
		
		
		
		
	}	
}
