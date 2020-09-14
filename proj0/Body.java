/* create Body class*/
public class Body {

	public static double G = 6.67*Math.pow(10,-11);/* value of G*/
	public double xxPos; /* current x positon*/
	public double yyPos; /* cuurent y position*/
	public double xxVel; /* velocity in x direction*/
	public double yyVel; /* velocity in y direction*/
	public double mass; /* mass*/
	public String imgFileName; /*corresponds pictures*/
	/* constructor*/
	public Body(double xP,double yP,double xV,
		double yV, double m ,String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/* second constructor*/
	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	/* calculate the distance between two bodies*/
	public double calcDistance(Body b){
		double dx = xxPos - b.xxPos;
		double dy = yyPos - b.yyPos;
		double r = Math.sqrt(dx*dx+dy*dy);
		return r;
	}

	/* calculate force */
	public double calcForceExertedBy(Body b){
		double distanceBetween = this.calcDistance(b);
		double forceBetween = Body.G*mass*b.mass/Math.pow(distanceBetween,2);
		return forceBetween;
	}

	/* calculate force in x direction*/
	public double calcForceExertedByX(Body b){
		double forceBetween = this.calcForceExertedBy(b);
		double forcex = forceBetween*(b.xxPos-xxPos)/this.calcDistance(b);
		return forcex;
	}

	/* calculate force in y direction*/
	public double calcForceExertedByY(Body b){
		double forceBetween = this.calcForceExertedBy(b);
		double forcex = forceBetween*(b.yyPos-yyPos)/this.calcDistance(b);
		return forcex;
	}

	/* calcaulate net force in x direction exerted by many bodies*/
	public double calcNetForceExertedByX(Body [] allBodys){
		double netforcex = 0;
		for(int i=0;i<allBodys.length;i++){
			/*can't exert force on itself*/
			if (this.equals(allBodys[i])){
				netforcex += 0; 
			} else{
				netforcex += this.calcForceExertedByX(allBodys[i]);
			}
			
		}
		return netforcex;
	}

	/* calcaulate net force in y direction exerted by many bodies*/
	public double calcNetForceExertedByY(Body [] allBodys){
		double netforcey = 0;
		/* enhanced for*/
		for(Body b:allBodys){
			/* can't exert force on itself*/
			if (this.equals(b)){
				netforcey += 0;
			}else{
				netforcey += this.calcForceExertedByY(b);
			}
		}
		return netforcey;
	}

	/* update position dt->a small period of time  
	fx-> net x-force; fy net y-force exert on the body;
	*/
	public void update(double dt,double fX,double fY){
		double ax = fX/mass ; /* acceleration in x direction*/
		double ay = fY/mass ; /* acceleration in y direction*/
		xxVel += ax*dt ; /* updat xxVel*/
		yyVel += ay*dt ; /* update yyVel*/
		xxPos += dt*xxVel ; /* update position in x */
		yyPos += dt*yyVel ; /* update position iny */
	}
	



}