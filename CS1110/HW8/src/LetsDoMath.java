


public class LetsDoMath {
	public static void main(String[] args)  {
	
		double locx = 350;
		double locy = 350;
		double gox = 650;
		double goy = 650;
		
		goy = goy + 2*(locy - goy);
		

		System.out.println(gox);

		System.out.println(goy);
		
		double dx = gox-locx;
		double dy = goy-locy;
		
		double angle = Math.atan2(dy, dx)*180/ Math.PI;
		
		System.out.println(angle);
	}
}
