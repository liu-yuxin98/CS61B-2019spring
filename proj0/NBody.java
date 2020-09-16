public class NBody {
	/* read radius from the file*/
	public static double readRadius(String filename){
		In in = new In(filename);
		int firstitem = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	/* read bodies from the file*/
	public static Body [] readBodies(String filename){
		In in = new In(filename);
		int numberOfplanet = in.readInt(); /* how many planets*/
		double radius = in.readDouble(); /* radius of the universe*/
		int i =0;
		Body [] bodys = new Body[numberOfplanet]; /* create body array*/
		while(i<numberOfplanet){
			double xp = in.readDouble(); /* xxPos*/
			double yp = in.readDouble(); /* yyPos*/
			double xv = in.readDouble(); /* xxVel*/
			double yv = in.readDouble(); /* yyVel*/
			double m = in.readDouble(); /* mass*/
			String planetName = in.readString(); /* name of the planet*/
			planetName = "images/"+planetName; /* add the relative path*/
			/* give value to bodys*/
			bodys[i] = new Body(xp,yp,xv,yv,m,planetName);
			i += 1 ;
		}
		return bodys;
	}
	/* draw background*/
	public static void drawBackground(String backGroundpic){
			/** Enables double buffering.
			  * A animation technique where all drawing takes place on the offscreen canvas.
			  * Only when you call show() does your drawing get copied from the
			  * offscreen canvas to the onscreen canvas, where it is displayed
			  * in the standard drawing window. */
			StdDraw.enableDoubleBuffering();
			/** Sets up the universe so it goes from
			  * -100, -100 up to 100, 100 */
			StdDraw.setXscale(-5*Math.pow(10,11),5*Math.pow(10,11));
			StdDraw.setYscale(-5*Math.pow(10,11), 5*Math.pow(10,11));
			/* Clears the drawing window. */
			StdDraw.clear();
			/* draw backGroundpic*/
			StdDraw.picture(0, 0, backGroundpic);
			/* Shows the drawing to the screen, and waits 2000 milliseconds. */
			StdDraw.show();
			StdDraw.pause(100);
		}

	public static void main(String[] args){
		/* read in variables, bodys*/
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]); /* read dtime*/
		String filename = args[2]; /* read filname*/
		double radiusOfuniverse = readRadius(filename); /* read radius*/
		Body [] bodys = readBodies(filename); /* read bodys*/
		String backGroundpic = "images/starfield.jpg" ;
		/* make it smooth*/
		StdDraw.enableDoubleBuffering();
		/* background*/
		drawBackground(backGroundpic);	
		/* annimation*/
		for(int time = 0;time<T;time+=dt){ /* update by dt time*/
			double [] xForces = new double[bodys.length];/*store net xforces*/
			double [] yForces = new double[bodys.length];/*store net yforces*/
			/* calculate each bodys net xforces and store it into xforces*/
			for(int i=0;i<bodys.length;i++){
				xForces[i] = bodys[i].calcNetForceExertedByX(bodys);
				yForces[i] = bodys[i].calcNetForceExertedByY(bodys);
			}
			
			/* update and draw bodys*/
			for(int i=0;i<bodys.length;i++){
				bodys[i].update(dt,xForces[i],yForces[i]);
				/* draw bodys*/
				bodys[i].draw();
			}
			/* pause*/
			StdDraw.pause(100);

		}

		
	}

	

}