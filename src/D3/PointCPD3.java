package D3;


public class PointCPD3 {
	 
	/**
	 * Instance variables for the class
	 */
		private double x;
		private double y;
		private char decision;
		
		/**
		 * Constructor
		 * @param decision
		 * @param x
		 * @param y
		 */
		
		public PointCPD3(char decision, double x,double y) {
			if(decision != 'Y' && decision != 'N')
			      throw new IllegalArgumentException();
			this.setX(x);
			this.setY(y);
			this.decision=decision;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}
		
		
		/**
		 * This method converts the storage to Polar
		 * @return
		 */
		public String convertStorageToPolar() {
			String result;
			double rho = Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
			double theta = Math.toDegrees(Math.atan2(getY(), getX()));
			
			result ="Stored Cartesian( "+getX()+","+ getY()+")\n "+
			" Polar Coodinates: ( "+rho+" , "+theta+")";
			return result;
		}
		
		
		/**
		   * Calculates the distance in between two points using the Pythagorean
		   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
		   *
		   * @param pointA The first point.
		   * @param pointB The second point.
		   * @return The distance between the two points.
		   */
		  public double getDistance(PointCPD3 pointB)
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
		  public PointCPD3 rotatePoint(double rotation)
		  {
		    double radRotation = Math.toRadians(rotation);
		    double X = getX();
		    double Y = getY();
		        
		    return new PointCPD3('Y',
		      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
		      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
		  }

		
		  public String toString()
		  {
		    return  (decision == 'Y') 
		       ? convertStorageToPolar()
		       : "Cartesian  (" + getX() + "," + getY() + ")" + "\n";
		  }
		
	}
