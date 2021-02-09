public class Planet {

	public double xxPos; public double yyPos; 
	public double xxVel; public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV,
		double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double r;

		r = Math.sqrt(Math.pow((this.xxPos - p.xxPos), 2) + Math.pow((this.yyPos - p.yyPos), 2));
		return r;
	}

	public double calcForceExertedBy(Planet p) {
		double f;

		f = G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
		return f;
	}

	public double calcForceExertedByX(Planet p) {
		double fx, dx; 

		dx = p.xxPos - this.xxPos;
		fx = this.calcForceExertedBy(p) * dx/this.calcDistance(p);
		return fx;
	}

	public double calcForceExertedByY(Planet p) {
		double fy, dy; 

		dy = p.yyPos - this.yyPos;
		fy = this.calcForceExertedBy(p) * dy/this.calcDistance(p);
		return fy;
	}

	public double calcNetForceExertedByX(Planet[] ps) {
		double fx_net = 0.0;

		for (int i = 0; i < ps.length; i++) {
			if (this.equals(ps[i])) {
				continue;
			}
			fx_net += this.calcForceExertedByX(ps[i]);
		}
		return fx_net;
	}

	public double calcNetForceExertedByY(Planet[] ps) {
		double fy_net = 0.0;

		for (int i = 0; i < ps.length; i++) {
			if (this.equals(ps[i])) {
				continue;	
			}
			fy_net += this.calcForceExertedByY(ps[i]);
		}
		return fy_net;
	}

	public void update(double dt, double fX, double fY) {
		double ax = fX / mass;
		double ay = fY / mass;
		xxVel += dt * ax;
		yyVel += dt * ay;
		xxPos += dt*xxVel;
		yyPos += dt*yyVel;	
	}	

	public void draw() {
		String imgFilePath = "images/" + imgFileName;
		StdDraw.picture(xxPos, yyPos, imgFilePath);
		StdDraw.show();
	}
	
}