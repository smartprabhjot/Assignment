package D4;

public class PointCPD4 {
	private double x;
	private double y;
	private double rho;
	private double theta;
	private char typeCoord;
	
	public PointCPD4(char type, double x, double y) {
		if (type != 'C' && type != 'P')
			throw new IllegalArgumentException();
		if(type=='C') {
			this.x = x;
			this.y = y;	
			typeCoord =type;
			this.rho = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			this.theta=  Math.toDegrees(Math.atan2(y, x));
		}
		else if(type=='P') {
			this.rho = x;
			this.theta = y;
			this.x=Math.cos(Math.toRadians(this.theta)) * this.rho;
			this.y=Math.sin(Math.toRadians(this.theta)) * this.rho;
			typeCoord =type;
		}
		
		else {
			System.out.println("Invalid input");
		}
		
		typeCoord = type;
	}
	
	public double getTheta() {
		return Math.toDegrees(Math.atan2(getY(), getX()));
	}

	public double getRho() {
		return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}
	
	public String toString() {

		return "Stored as " + (typeCoord == 'C' ? "Cartesian  (" + getX() + "," + getY() + ")"
				: "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
	}
	
	/**
	   * Calculates the distance in between two points using the Pythagorean
	   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	   *
	   * @param pointA The first point.
	   * @param pointB The second point.
	   * @return The distance between the two points.
	   */
	  public double getDistance(PointCPD4 pointB)
	  {
	    // Obtain differences in X and Y, sign is not important as these values
	    // will be squared later.
	    double deltaX = getX() - pointB.getX();
	    double deltaY = getY() - pointB.getY();
	    
	    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	  }
	
	
	  /**
	   * Rotates the specified point by the specified number of degrees.
	   * Not required until E2.30
	   *
	   * @param point The point to rotate
	   * @param rotation The number of degrees to rotate the point.
	   * @return The rotated image of the original point.
	   */
	  public PointCPD4 rotatePoint(double rotation)
	  {
	    double radRotation = Math.toRadians(rotation);
	    double X = getX();
	    double Y = getY();
	        
	    return new PointCPD4('C',
	      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
	      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	  }


}
