/**
 * Names: Reid Bixler, Camille Hochheimer
 * Computing IDs: rmb3yz, cjh8uc
 * Lab Section: 1110-102
 * Date: November 13, 2013
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class SimpleCanvas extends JPanel implements MouseListener, MouseMotionListener {

	// width and height of the window
	private int width;
	private int height;

	// lastTime that the screen was refreshed
	private long lastTime;

	// a link back to the ZombieSurvival for updating it
	private ZombieSurvival simulator;

	// BufferedImages to handle the sprite graphics
	// We've provided a 2D array for zombies and humans in case you want to do
	// animation
	private BufferedImage[][] zombieSprites;
	private BufferedImage[][] humanSprites;
	private BufferedImage boomSprite;


	public SimpleCanvas(int width_, int height_, ZombieSurvival simulator_) {
		width = width_;
		height = height_;
		simulator = simulator_;
		lastTime = -1L;

		humanSprites = loadHumanSprites("sprite.png");
		zombieSprites = loadZombieSprites("zombie.png");
		try {
			boomSprite = ImageIO.read(new File("boom.png"));
		} catch (Exception e) {
			System.err.println("Cannot load images!");
		}

	}


	public BufferedImage[][] loadHumanSprites(String filename) {

		BufferedImage[][] spriteArray = new BufferedImage[4][8];
		BufferedImage spriteSheet = null;

		try {
			spriteSheet = ImageIO.read(new File(filename));
		} catch (Exception e) {
			System.err.println("Cannot load images!");
		}

		//ALL RIGHT ANIMATION
				spriteArray[0][0] = spriteSheet.getSubimage(0, 80, 50, 80);
				spriteArray[0][1] = spriteSheet.getSubimage(50, 80, 50, 80);
				spriteArray[0][2] = spriteSheet.getSubimage(100, 80, 50, 80);
				spriteArray[0][3] = spriteSheet.getSubimage(150, 80, 45, 80);
				spriteArray[0][4] = spriteSheet.getSubimage(190, 80, 50, 80);
				spriteArray[0][5] = spriteSheet.getSubimage(240, 80, 50, 80);
				spriteArray[0][6] = spriteSheet.getSubimage(290, 80, 50, 80);
				spriteArray[0][7] = spriteSheet.getSubimage(340, 80, 50, 80);


		// load left facing
				spriteArray[1][0] = getFlippedImage(spriteSheet.getSubimage(0, 80, 50, 80));
				spriteArray[1][1] = getFlippedImage(spriteSheet.getSubimage(50, 80, 50, 80));
				spriteArray[1][2] = getFlippedImage(spriteSheet.getSubimage(100, 80, 50, 80));
				spriteArray[1][3] = getFlippedImage(spriteSheet.getSubimage(150, 80, 45, 80));
				spriteArray[1][4] = getFlippedImage(spriteSheet.getSubimage(190, 80, 50, 80));
				spriteArray[1][5] = getFlippedImage(spriteSheet.getSubimage(240, 80, 50, 80));
				spriteArray[1][6] = getFlippedImage(spriteSheet.getSubimage(290, 80, 50, 80));
				spriteArray[1][7] = getFlippedImage(spriteSheet.getSubimage(340, 80, 50, 80));

		// load up facing
				spriteArray[2][0] = spriteSheet.getSubimage(0, 234, 50, 80);
				spriteArray[2][1] = spriteSheet.getSubimage(50, 234, 50, 80);
				spriteArray[2][2] = spriteSheet.getSubimage(100, 234, 50, 80);
				spriteArray[2][3] = spriteSheet.getSubimage(148, 234, 50, 80);
				spriteArray[2][4] = spriteSheet.getSubimage(190, 234, 50, 80);
				spriteArray[2][5] = spriteSheet.getSubimage(240, 234, 50, 80);
				spriteArray[2][6] = spriteSheet.getSubimage(290, 234, 50, 80);
				spriteArray[2][7] = spriteSheet.getSubimage(340, 234, 50, 80);

		// load down facing
				spriteArray[3][0] = spriteSheet.getSubimage(0, 160, 50, 78);
				spriteArray[3][1] = spriteSheet.getSubimage(50, 160, 50, 78);
				spriteArray[3][2] = spriteSheet.getSubimage(100, 160, 50, 78);
				spriteArray[3][3] = spriteSheet.getSubimage(148, 160, 50, 78);
				spriteArray[3][4] = spriteSheet.getSubimage(190, 160, 50, 78);
				spriteArray[3][5] = spriteSheet.getSubimage(240, 160, 50, 78);
				spriteArray[3][6] = spriteSheet.getSubimage(290, 160, 50, 78);
				spriteArray[3][7] = spriteSheet.getSubimage(340, 160, 50, 78);
				
		
		

		
		
		return spriteArray;
	}


	public BufferedImage[][] loadZombieSprites(String filename) {

		BufferedImage[][] spriteArray = new BufferedImage[4][8];
		BufferedImage spriteSheet = null;

		try {
			spriteSheet = ImageIO.read(new File(filename));
		} catch (Exception e) {
			System.err.println("Cannot load images!");
		}
		int x = 10;
		int y = 10;
		
		// load right facing
			spriteArray[0][0] = spriteSheet.getSubimage(x + 10, y + 90, 45, 100);
			spriteArray[0][1] = spriteSheet.getSubimage(x + 90, y + 90, 45, 100);
			spriteArray[0][2] = spriteSheet.getSubimage(x + 160, y + 90, 45, 100);


		// load left facing
			spriteArray[1][0] = spriteSheet.getSubimage(x, y + 290, 45, 100);
			spriteArray[1][1] = spriteSheet.getSubimage(x + 80, y + 290, 45, 100);
			spriteArray[1][2] = spriteSheet.getSubimage(x + 150, y + 290, 45, 100);

		// load up facing
			spriteArray[2][0] = spriteSheet.getSubimage(x, y, 45, 100);
			spriteArray[2][1] = spriteSheet.getSubimage(x + 80, y, 45, 100);
			spriteArray[2][2] = spriteSheet.getSubimage(x + 150, y, 45, 100);

		// load down facing
			spriteArray[3][0] = spriteSheet.getSubimage(x, y + 190, 45, 100);
			spriteArray[3][1] = spriteSheet.getSubimage(x + 80, y + 190, 45, 100);
			spriteArray[3][2] = spriteSheet.getSubimage(x + 150, y + 190, 45, 100);
		

		
		

		return spriteArray;
	}

	/**
	 * Called to start the game
	 */
	public void setupAndDisplay() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(this));
		f.setSize(width, height);
		f.setLocation(100, 100);
		f.setVisible(true);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}


	protected void paintComponent(Graphics g) {
		boolean first = (lastTime == -1L);
		long elapsedTime = System.nanoTime() - lastTime;
		lastTime = System.nanoTime();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.white);
		simulator.draw((Graphics2D) g, (first ? 0.0f : (float) elapsedTime / 1e9f));
		repaint();
	}


	public void drawDot(Graphics2D g, double x, double y, Color color) {
		g.setColor(color);
		g.fillOval((int) (x + 0.5f), (int) (y + 0.5f), 8, 8);
	}
	
	

	public void drawObstacle(Graphics2D g, Rectangle o) {
		g.setColor(Color.white);
		g.fill(o);
	}
	
	public void drawZombie(Graphics2D g, Zombie z, float tick) {
		int locationx = (int) z.getLocationx();
		int locationy = (int) z.getLocationy();
		Rectangle r = z.getHitbox();
		r.setRect(locationx-20, locationy-18, 25, 57);
		//String s = r.toString();
		//System.out.println(s);
		
			int directionsprite = z.getDirectionsprite();

			double gox = z.getGox();
			double goy = z.getGoy();
			
			double changey = goy + 2*(locationy - goy);
			
			double dx = gox-locationx;
			double dy = changey-locationy;
			
			double angle = Math.atan2(dy, dx)*180/ Math.PI;
			if (angle>-45 && angle<=45){
				z.setDirectionsprite(0);
			}
			if (angle>45 && angle<=135){
				z.setDirectionsprite(90);
			}
			if ((angle>135 && angle<=180)){
				z.setDirectionsprite(180);
			}
			if ((angle<-135 && angle>=-180)){
				z.setDirectionsprite(180);

			}
			if (angle>-135 && angle<=-45){
				z.setDirectionsprite(-90);
			}
			
			int x = 300;
			tick = tick%(4*x);

			switch (directionsprite){
			case 0:
				//move right	
				if (tick <= x && tick >= 0){
					g.drawImage(zombieSprites[0][0], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 2*x && tick > x){
					g.drawImage(zombieSprites[0][1], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 3*x && tick > 2*x){
					g.drawImage(zombieSprites[0][2], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 4*x && tick > 3*x){
					g.drawImage(zombieSprites[0][1], (int)locationx-32, (int)locationy-40, null);
				}
				break;
			case 180:
				//move left
				//g.drawImage(zombieSprites[1][0], (int)locationx-32, (int)locationy-40, null);
				if (tick <= x && tick >= 0){
					g.drawImage(zombieSprites[1][0], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 2*x && tick > x){
					g.drawImage(zombieSprites[1][1], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 3*x && tick > 2*x){
					g.drawImage(zombieSprites[1][2], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 4*x && tick > 3*x){
					g.drawImage(zombieSprites[1][1], (int)locationx-32, (int)locationy-40, null);
				}
				break;
			case 90:
				//move up
				if (tick <= x && tick >= 0){
					g.drawImage(zombieSprites[2][0], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 2*x && tick > x){
					g.drawImage(zombieSprites[2][1], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 3*x && tick > 2*x){
					g.drawImage(zombieSprites[2][2], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 4*x && tick > 3*x){
					g.drawImage(zombieSprites[2][1], (int)locationx-32, (int)locationy-40, null);
				}
				break;
			case -90:
				//move down
				if (tick <= x && tick >= 0){
					g.drawImage(zombieSprites[3][0], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 2*x && tick > x){
					g.drawImage(zombieSprites[3][1], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 3*x && tick > 2*x){
					g.drawImage(zombieSprites[3][2], (int)locationx-32, (int)locationy-40, null);
				}
				
				else if (tick <= 4*x && tick > 3*x){
					g.drawImage(zombieSprites[3][1], (int)locationx-32, (int)locationy-40, null);
				}				break;
			default:
				break;
			}
		
		
		//g.drawImage(zombieSprites[0][0], locationx-32, locationy-40, null);
		
	}

	public void drawHuman(Graphics2D g, Human h, float tick) {
		double locationx = h.getLocationx();
		double locationy = h.getLocationy();
		int directionsprite = h.getDirectionsprite();
		double angle = h.getAngle();
		int direction = h.getDirection();
		
		Rectangle r = h.getHitbox();
		

		r.setRect(locationx-15, locationy-25, 22, 40);
		
		
		
		
		if (angle>-45 && angle<=45){
			h.setDirectionsprite(0);
		}
		if (angle>45 && angle<=135){
			h.setDirectionsprite(90);
		}
		if ((angle>135 && angle<=180)){
			h.setDirectionsprite(180);
		}
		if ((angle<-135 && angle>=-180)){
			h.setDirectionsprite(180);

		}
		if (angle>-135 && angle<=-45){
			h.setDirectionsprite(-90);
		}
		if (direction == -1){
			h.setDirectionsprite(-1);
		}
		
		int x = 100;		//float ticky = tick;
		tick = tick%(8*x);
		
		switch (directionsprite){
		case 0:
			//move right
			if (tick <= x && tick >= 0){
				g.drawImage(humanSprites[0][0], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 2*x && tick > x){
				g.drawImage(humanSprites[0][1], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 3*x && tick > 2*x){
				g.drawImage(humanSprites[0][2], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 4*x && tick > 3*x){
				g.drawImage(humanSprites[0][3], (int)locationx-25, (int)locationy-45, null);
			}

			else if (tick <= 5*x && tick > 4*x){
				g.drawImage(humanSprites[0][4], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 6*x && tick > 5*x){
				g.drawImage(humanSprites[0][5], (int)locationx-25, (int)locationy-45, null);
			}
			else if (tick <= 7*x && tick > 6*x){
				g.drawImage(humanSprites[0][6], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 8*x && tick > 7*x){
				g.drawImage(humanSprites[0][7], (int)locationx-25, (int)locationy-45, null);
			}
			break;
		case 180:
			//move left
			if (tick <= x && tick >= 0){
				g.drawImage(humanSprites[1][0], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 2*x && tick > x){
				g.drawImage(humanSprites[1][1], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 3*x && tick > 2*x){
				g.drawImage(humanSprites[1][2], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 4*x && tick > 3*x){
				g.drawImage(humanSprites[1][3], (int)locationx-25, (int)locationy-45, null);
			}

			else if (tick <= 5*x && tick > 4*x){
				g.drawImage(humanSprites[1][4], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 6*x && tick > 5*x){
				g.drawImage(humanSprites[1][5], (int)locationx-25, (int)locationy-45, null);
			}
			else if (tick <= 7*x && tick > 6*x){
				g.drawImage(humanSprites[1][6], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 8*x && tick > 7*x){
				g.drawImage(humanSprites[1][7], (int)locationx-25, (int)locationy-45, null);
			}
			break;
		case 90:
			//move up
			if (tick <= x && tick >= 0){
				g.drawImage(humanSprites[2][0], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 2*x && tick > x){
				g.drawImage(humanSprites[2][1], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 3*x && tick > 2*x){
				g.drawImage(humanSprites[2][2], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 4*x && tick > 3*x){
				g.drawImage(humanSprites[2][3], (int)locationx-25, (int)locationy-45, null);
			}

			else if (tick <= 5*x && tick > 4*x){
				g.drawImage(humanSprites[2][4], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 6*x && tick > 5*x){
				g.drawImage(humanSprites[2][5], (int)locationx-25, (int)locationy-45, null);
			}
			else if (tick <= 7*x && tick > 6*x){
				g.drawImage(humanSprites[2][6], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 8*x && tick > 7*x){
				g.drawImage(humanSprites[2][7], (int)locationx-25, (int)locationy-45, null);
			}
			break;
		case -90:
			//move down
			if (tick <= x && tick >= 0){
				g.drawImage(humanSprites[3][0], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 2*x && tick > x){
				g.drawImage(humanSprites[3][1], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 3*x && tick > 2*x){
				g.drawImage(humanSprites[3][2], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 4*x && tick > 3*x){
				g.drawImage(humanSprites[3][3], (int)locationx-25, (int)locationy-45, null);
			}

			else if (tick <= 5*x && tick > 4*x){
				g.drawImage(humanSprites[3][4], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 6*x && tick > 5*x){
				g.drawImage(humanSprites[3][5], (int)locationx-25, (int)locationy-45, null);
			}
			else if (tick <= 7*x && tick > 6*x){
				g.drawImage(humanSprites[3][6], (int)locationx-25, (int)locationy-45, null);
			}
			
			else if (tick <= 8*x && tick > 7*x){
				g.drawImage(humanSprites[3][7], (int)locationx-25, (int)locationy-45, null);
			}
			break;
		case -1:
			g.drawImage(humanSprites[3][0], (int)locationx-25, (int)locationy-45, null);
		default:
			break;
		}
	

		
	}


	public void drawBoom(Graphics2D g, int x, int y) {
		g.drawImage(boomSprite, x, y, null);
	}

	public BufferedImage getFlippedImage(BufferedImage bi) {
		BufferedImage flipped = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
		AffineTransform tran = AffineTransform.getTranslateInstance(bi.getWidth(), 0);
		AffineTransform flip = AffineTransform.getScaleInstance(-1d, 1d);
		tran.concatenate(flip);

		Graphics2D g = flipped.createGraphics();
		g.setTransform(tran);
		g.drawImage(bi, 0, 0, null);
		g.dispose();

		return flipped;
	}


	public void mouseMoved(MouseEvent e) {
		simulator.mouseAction((float) e.getX(), (float) e.getY(), -1);
	}


	public void mouseClicked(MouseEvent e) {
		simulator.mouseAction((float) e.getX(), (float) e.getY(), e.getButton());
	}

	public void mouseEntered(MouseEvent e) {
	}


	public void mouseExited(MouseEvent e) {
	}


	public void mousePressed(MouseEvent e) {
	}


	public void mouseReleased(MouseEvent e) {
	}


	public void mouseDragged(MouseEvent arg0) {
	}

}
