/**
	NBody is the class that will actually run the simulation
*/
public class NBody {

	/* read universe radius. */
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int numPlanet = in.readInt();
		Double radius = in.readDouble();

		return radius;
	}

	/* read planets. */
	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		int numPlanet = in.readInt();
		Double radius = in.readDouble();
		Planet[] planets = new Planet[numPlanet];

		/* why does a while loop cause InputMismatchException ? 
		loop loop ends where conditon is meet, which is i = numPlanets. However, after it ends, it jumps back 
		to the while loop, asks, if in.isEmpty? for a file that has additional gabage at the end, condition is meet,
		a new for loop starts! if the first in comes into the loop is not double, ERROR.
		*/ 
		for (int i = 0; i < numPlanet; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();

			planets[i] = new Planet(xP, yP, xVel, yVel, mass, img);
		}
		return planets;
	}


	public static void main(String[] args) {

		StdDraw.enableDoubleBuffering();

		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double r = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		int waitTimeMilliseconds = 10;
		

		for (double t = 0; t < T; t += dt) {
				double[] xForces = new double[planets.length];
				double[] yForces = new double[planets.length];

			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
				
				planets[i].update(dt, xForces[i], yForces[i]);

				/* Set up background starfield. */
				StdDraw.setScale(-r, r);
				StdDraw.clear();
				StdDraw.picture(0, 0, "images/starfield.jpg");

				/* Draw planets. */
				for (int j = 0; j < planets.length; j++) {
					planets[j].draw();
				}
				StdDraw.show();
				StdDraw.pause(waitTimeMilliseconds);
			}

		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
}