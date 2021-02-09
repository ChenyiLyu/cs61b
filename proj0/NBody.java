/**
	NBody is the class that will actually run the simulation
*/
public class NBody {

	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int numPlanet = in.readInt();
		Double radius = in.readDouble();

		return radius;
	}

	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		int numPlanet = in.readInt();
		Double radius = in.readDouble();
		Planet[] planets = new Planet[numPlanet];
// why not add a while ? 
		while (!in.isEmpty()) {
			for (int i = 0; i < numPlanet; i++) {
				double xP = in.readDouble();
				double yP = in.readDouble();
				double xVel = in.readDouble();
				double yVel = in.readDouble();
				double mass = in.readDouble();
				String img = in.readString();

				planets[i] = new Planet(xP, yP, xVel, yVel, mass, img);
			}
		}
		return planets;
	}
}