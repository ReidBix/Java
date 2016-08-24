import java.text.DecimalFormat;

/**
 * GPSCoordinate
 * 
 * A class that allows a user to manipulate a GPS entry.
 * 
 * Methods to know:
 * 
 * getCoordinate() / toCSV() - returns the lat and lon as lat,lon 
 *   which you will use when building the POI map
 *   
 * distanceTo(GPSCoordinate pt2) - called like this:
 *   pt1.distanceTo(pt2)
 *   returns the distance between the two points in miles
 *   
 * getBearing(GPSCoordinate pt2) - called like this:
 *   pt1.distanceTo(pt2)
 *   returns the direction to go from pt1 to pt2
 *   
 * findCoordinate(bearing, distance) - called like this:
 *   pt1.findCoordinate(bearing, distance)
 *   returns a new GPSCoordinate that is distance away from
 *   pt1 in the bearing direction
 * 
 * @author Mark Sherriff
 * 
 */
public class GPSCoordinate {

	// The four fields in the GPS coordinate file
	private double lat;
	private double lon;
	private String name;
	private String info;

	/**
	 * Default constructor of the GPSCoordinate class
	 */
	public GPSCoordinate() {
		super();
	}

	/**
	 * Constructor for GPSCoordinate with location parameters
	 * 
	 * @param lat
	 *            latitude of a point
	 * @param lon
	 *            longitude of a point
	 */
	public GPSCoordinate(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	
	/**
	 * Constructor for GPSCoordinate with full parameters
	 * 
	 * @param lat
	 *            latitude of a point
	 * @param lon
	 *            longitude of a point
	 * @param name
	 *            name of location at point
	 * @param info
	 *            info about the point
	 */
	public GPSCoordinate(double lat, double lon, String name, String info) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.name = name;
		this.info = info;
	}

	/**
	 * Returns the GPSCoordinate as a CSV line item
	 * 
	 * @return CSV version of the item
	 */
	public String toCSV() {
		DecimalFormat fmt = new DecimalFormat("#.000000");
		return fmt.format(lat) + "," + fmt.format(lon);

	}
	
	/**
	 * Returns the lat,lon in this format
	 * 
	 * @return lat,lon
	 */
	public String getCoordinate() {
		return toCSV();
	}

	@Override
	public String toString() {
		DecimalFormat fmt = new DecimalFormat("#.000000");
		if(name == null || name == "") {
			return "(" +fmt.format(lat) + "," + fmt.format(lon) + ")";
		}
		if(info == null || info == "") {
			return "(" +fmt.format(lat) + "," + fmt.format(lon) + ") - " + name;
		}
		return "(" +fmt.format(lat) + "," + fmt.format(lon) + ") - " + name + " - " + info;

	}

	/**
	 * This method returns the distance between two GPSCoordinates as a fraction
	 * of a mile.
	 * 
	 * @param coord
	 *            GPSCoordinate to calculate with
	 * @return distance in miles
	 */
	public double distanceTo(GPSCoordinate coord) {

		double lat1 = lat;
		double lon1 = lon;
		double lat2 = coord.getLat();
		double lon2 = coord.getLon();

		double theta = lon1 - lon2;
		double dist = Math.sin(lat1 * Math.PI / 180.0)
				* Math.sin(lat2 * Math.PI / 180.0)
				+ Math.cos(lat1 * Math.PI / 180.0)
				* Math.cos(lat2 * Math.PI / 180.0)
				* Math.cos(theta * Math.PI / 180.0);
		dist = Math.acos(dist);
		dist = dist * 180.0 / Math.PI;
		dist = dist * 60 * 1.1515;

		return dist;
	}

	/**
	 * This method determines the radial bearing between two coordinates.
	 * 
	 * @param coord
	 *            coordinate to calculate the bearing toward
	 * @return radial bearing
	 */
	public double getBearing(GPSCoordinate coord) {

		double lat1 = lat;
		double lon1 = lon;
		double lat2 = coord.getLat();
		double lon2 = coord.getLon();

		lat1 = lat1 * Math.PI / 180;
		lon1 = lon1 * Math.PI / 180;
		lat2 = lat2 * Math.PI / 180;
		lon2 = lon2 * Math.PI / 180;

		double dLon = lon2 - lon1;
		double y = Math.sin(dLon) * Math.cos(lat2);
		double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1)
				* Math.cos(lat2) * Math.cos(dLon);

		double bearing = (180.0 / Math.PI) * Math.atan2(y, x);
		bearing = bearing % 360;
		return bearing;
	}

	/**
	 * This method finds a GPS coordinate given a start point, a bearing
	 * (direction), and a distance traveled
	 * 
	 * @param brng
	 *            radial bearing that you are traveling
	 * @param dist
	 *            distance to travel in miles
	 * @return an array where index 0 is latitude and index 1 is longitude of
	 *         found coordinate
	 */
	public GPSCoordinate findCoordinate(double brng, double dist) {

		double R = 3963.1676;
		brng = brng * Math.PI / 180;

		dist = dist / R;
		
		

		double latrad = lat * Math.PI / 180;
		double lonrad = lon * Math.PI / 180;

		double lat2 = Math.asin(Math.sin(latrad) * Math.cos(dist) + Math.cos(latrad)
				* Math.sin(dist) * Math.cos(brng));
		double lon2 = lonrad
				+ Math.atan2(Math.sin(brng) * Math.sin(dist) * Math.cos(latrad),
						Math.cos(dist) - Math.sin(latrad) * Math.sin(lat2));
		lon2 = (lon2 + 3 * Math.PI) % (2 * Math.PI) - Math.PI;

		lat2 = lat2 * 180 / Math.PI;
		lon2 = lon2 * 180 / Math.PI;

		GPSCoordinate temp = new GPSCoordinate();
		temp.setLat(lat2);
		temp.setLon(lon2);
		return temp;

	}

	// GETTERS AND SETTERS -------------------------------


	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


}
