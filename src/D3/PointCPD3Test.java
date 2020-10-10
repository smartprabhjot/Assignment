package D3;

import java.io.IOException;

public class PointCPD3Test {
	public static void main(String[] args) throws IOException {

		PointCPD3 point;
		System.out.println("Simple Design to Store Cartesian coordinates only");

		try {
			point = new PointCPD3(args[0].toUpperCase().charAt(0), Double.valueOf(args[1]).doubleValue(),
					Double.valueOf(args[2]).doubleValue());
		} catch (Exception e) {
			// If we arrive here, it is because either there were no
			// command line arguments, or they were invalid
			if (args.length != 0)
				System.out.println("Invalid arguments on command line");

			point = getInput();
		}

		System.out.println("\nResult:\n" + point);
		System.out.println("Time taken to calculate Distance"+calDistance(point));
		System.out.println("Time taken to calculate Rotation"+calRotation(point));
		
		

	}

	public static long calDistance(PointCPD3 point) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			// timer is initiated, logging begins

			point.getDistance(point);

		}
		long stopTime = System.currentTimeMillis(); // timer is halted, logging stops
		long elapsedTime = stopTime - startTime;
		
		return elapsedTime;
	}

	public static long calRotation(PointCPD3 point) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			// timer is initiated, logging begins

			point.rotatePoint(45.3);

		}
		long stopTime = System.currentTimeMillis(); // timer is halted, logging stops
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}

	private static PointCPD3 getInput() throws IOException {
		byte[] buffer = new byte[1024]; // Buffer to hold byte input
		boolean isOK = false; // Flag set if input correct
		String theInput = ""; // Input information

		// Information to be passed to the constructor
		char coordType = 'A'; // Temporary default, to be set to Y or N
		double a = 0.0;
		double b = 0.0;

		// Allow the user to enter the three different arguments
		for (int i = 0; i < 3; i++) {
			while (!(isOK)) {
				isOK = true; // flag set to true assuming input will be valid

				// Prompt the user
				if (i == 0) // First argument - type of coordinates
				{
					System.out
							.print("Do you want to convert your cartesian to polar coordinates?" + " ((Y)es / (N)o): ");
				} else // Second and third arguments
				{
					System.out.print("Enter the value of "
							+ (coordType == 'C' ? (i == 1 ? "Y " : "N ") : (i == 1 ? "X coordinate " : "Y coordinate "))
							+ "using a decimal point(.): ");
				}

				// Get the user's input

				// Initialize the buffer before we read the input
				for (int k = 0; k < 1024; k++)
					buffer[k] = '\u0020';

				System.in.read(buffer);
				theInput = new String(buffer).trim();

				// Verify the user's input
				try {
					if (i == 0) // First argument -- type of coordinates
					{
						if (!((theInput.toUpperCase().charAt(0) == 'Y') || (theInput.toUpperCase().charAt(0) == 'N'))) {
							// Invalid input, reset flag so user is prompted again
							isOK = false;
						} else {
							coordType = theInput.toUpperCase().charAt(0);
						}
					} else // Second and third arguments
					{
						// Convert the input to double values
						if (i == 1)
							a = Double.valueOf(theInput).doubleValue();
						else
							b = Double.valueOf(theInput).doubleValue();
					}
				} catch (Exception e) {
					System.out.println("Incorrect input");
					isOK = false; // Reset flag as so not to end while loop
				}
			}

			// Reset flag so while loop will prompt for other arguments
			isOK = false;
		}
		// Return a new PointCP object
		return (new PointCPD3(coordType, a, b));

	}
}
