import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A world for turtles to play inside of
 * 
 * @author Luther Tychonievich
 */
public class World extends JFrame {
	/// version number based on date of creation
		private static final long serialVersionUID = 20130902L; 
		
		private BufferedImage paths;
		private BufferedImage surface;
		private Graphics2D pg;
		private Graphics2D sg;
		private ArrayList<Turtle> turtles;
		
		public final int CENTER_X;
		public final int CENTER_Y;
		
		private int turtlePause = 50;
		
		/**
		 * Seconds to pause between each turtle movement
		 * @return the seconds currently paused
		 */
		public double getTurtleSpeed() {
			return turtlePause * 0.001;
		}
		/**
		 * Seconds to pause between each turtle movement
		 * @param seconds The seconds to pause
		 */
		public void setTurtleSpeed(double seconds) {
			this.turtlePause = (int)(seconds*1000);
		}

		/**
		 * Creates a new World for Turtles to play in.
		 */
		public World() {
			super("Turtle World");
			this.CENTER_X = 300;
			this.CENTER_Y = 300;
			this.surface = new BufferedImage(2*this.CENTER_X, 2*this.CENTER_Y, BufferedImage.TYPE_INT_ARGB);
			this.paths = new BufferedImage(this.surface.getWidth(), this.surface.getHeight(), BufferedImage.TYPE_INT_ARGB);
			this.setContentPane(new JLabel(new ImageIcon(this.surface)));
			this.pack();
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			this.pg = (Graphics2D)this.paths.getGraphics();
			this.sg = (Graphics2D)this.surface.getGraphics();
			
			this.pg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			this.pg.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			this.pg.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			this.pg.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
			
			this.sg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			this.sg.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			this.sg.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			this.sg.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

//			this.sg.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
			
			this.pg.setBackground(new Color(255,255,255,0)); // transparent
			this.sg.setBackground(Color.WHITE);
			
			this.clear();
			this.eraseAll();

			this.repaint();
			this.setVisible(true);
			
			this.turtles = new ArrayList<Turtle>();
		}
		
		/**
		 * Erases all existing paths
		 */
		public void eraseAll() {
			this.pg.clearRect(0, 0, this.paths.getWidth(), this.paths.getHeight());
		}
		/**
		 * Erases all existing paths
		 */
		private void clear() {
			this.sg.clearRect(0, 0, this.surface.getWidth(), this.surface.getHeight());
		}
		
		
		
		/**
		 * Should only called by the Turtle class constructor 
		 */
		void addTurtle(Turtle t) {
			this.turtles.add(t);
		}
		/**
		 * Should only called by Turtle class methods 
		 */
		void drawLine(Point2D p1, Point2D p2, double width, Color color) {
			// draw the line
			this.pg.setColor(color);
			this.pg.setStroke(new BasicStroke((float)width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			Line2D.Double line = new Line2D.Double(p1, p2);
			this.pg.draw(line);

			// show the drawn lines
			this.clear();
			this.sg.drawImage(this.paths, 0, 0, this);
			// add the turtles over top
			for(Turtle t : this.turtles) {
				t.draw(this.sg);
			}
			// force the OS to show what's shown
			this.repaint();
			
			// pause
			try { Thread.sleep(this.turtlePause); } catch (InterruptedException e) { }
		}
		/**
		 * Should only called by Turtle class methods 
		 */
		void drawLine(Point2D p1, double nx, double ny, double width, Color color) {
			this.drawLine(p1,  new Point2D.Double(nx,ny), width, color);
		}
		/**
		 * Should only called by Turtle class methods 
		 */
		void turtleMoved() {
			// show the drawn lines
			this.clear();
			this.sg.drawImage(this.paths, 0, 0, this);
			// add the turtles over top
			for(Turtle t : this.turtles) {
				t.draw(this.sg);
			}
			// force the OS to show what's shown
			this.repaint();
			// pause
			try { Thread.sleep(this.turtlePause); } catch (InterruptedException e) { }
		}
		
		/**
		 * Saves the current image to the specified file
		 * 
		 * @param filename The name of the file to write
		 * @throws IllegalArgumentException if any parameter is null or if the filename is not an image filename
		 * @throws IOException if an error occurs in writing the file
		 */
		public void saveAs(String filename) throws IOException {
			int dot = filename.lastIndexOf('.');
			if (dot < 0 || dot == filename.length()-1) {
				throw new IllegalArgumentException("The filename must end in a valid image extension, like .png or .jpg");
			}
			String ext = filename.substring(dot+1).toLowerCase();
			File f = new File(filename);
			ImageIO.write(this.surface, ext, f);
		}
		
		/**
		 * To be used by Turtle class only
		 * @param img the Image to draw
		 * @param placement the Affine Transform to use in drawing it 
		 */
		void drawImage(Image img, AffineTransform placement) {
			this.pg.drawImage(img, placement, this);
			// show the drawn lines
			this.clear();
			this.sg.drawImage(this.paths, 0, 0, this);
			// add the turtles over top
			for(Turtle t : this.turtles) {
				t.draw(this.sg);
			}
			// force the OS to show what's shown
			this.repaint();
			
			// pause
			try { Thread.sleep(this.turtlePause); } catch (InterruptedException e) { }
		}
		
		static void tree(Turtle t, int depth) {
			if (depth <= 0) {
				t.dropPicture("http://www.biologycorner.com/resources/leaves_clker.png", 50);
				return;
			}
			t.penDown();
			t.setWidth(depth);
			double dist = Math.random()*15+1;
			t.forward(dist*depth);
			double d = Math.random()*60-30;
			if (d < 0) d -= 15;
			else d += 15;
			t.left(d);
			tree(t,depth-1);
			t.right(2*d);
			tree(t,depth-1);
			t.left(d);
			t.penUp();
			t.backward(dist*depth);
		}
		
		
		public static void main(String[] args) {
			World w = new World();
			Turtle t = new Turtle(w, 0, 200);
			t.left(90);
			tree(t,8);
			/*
			
			for (int i=0; i<26; ++i) {
				t.setColor(new Color(0,255-i*10,i*10));
				
				t.setWidth((26.-i)/4);
				t.forward(10 + 10*i);
				t.left(69);
				
				
				t.penUp();
				
				t.forward(10+10*i);
				t.left(69);
				t.penDown();

				t.dropPicture("http://coachesinc.com/images/uploads/UVA%20logo.png", 10+10*i);
			}
				*/	
			try {
				w.saveAs("demo.png");
			} catch (IOException e) {
				System.err.println("Unable to save image");
			}
		}
		
	}


