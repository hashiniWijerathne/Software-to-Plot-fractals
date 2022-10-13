import java.awt.*; /* java abstract window toolkit */
//import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;

class MandelbrotPanel extends JPanel { // inherit JPanel 

    
	private static final long serialVersionUID = 1L;
	//one pixel value for x and y axes
	public static double x = 0;								
    public static double y = 0;
    
   // private int width, height;      // to set the panel size
    private double repos ;	        //positive bound of real part
    private double reneg ;			//negative bound of real part
    private double comppos ;		//positive bound of complex part
    private double compneg ; 		//negative bound of complex part																																
    private int iterations ;		//No of iterations
    
    //constructor
    MandelbrotPanel(double realN, double realP, double complexN, double complexP, int iter){
       ///assigning variables
       this.reneg = realN ;
       this.repos = realP ;
       this.compneg = complexN ;
       this.comppos = complexP ;
       this.iterations =iter ;
       //this.width  = width; 
   	   //this.height = height; 
   	   setPreferredSize(new Dimension(800,800)); 
    }

  //printpoint method for print a point
    private static void printPoint(Graphics2D frame, Color c, int x,int y) {					

        frame.setColor(c); 
        frame.draw(new Line2D.Double(x, y, x,y)); 
    }

    public void paintComponent(Graphics g) { 
    	// call paintComponent from parent class 
    	super.paintComponent(g); 
    	// create a object to Mandelbrot
    	Mandelbrot obj = new Mandelbrot(repos,reneg ,comppos,compneg ,iterations);
    	//iterate through y and x axes to color the points which are Mandelbrot and not with relatively
    	for(y=0; y<800 ; y++) {										
    		for (x=0;x<800 ; x++){															
    			if(obj.checkMandelbrot()){																	
    				printPoint((Graphics2D)g, Color.getHSBColor(obj.i/256f,1,obj.i/(obj.i+8f)), (int)x,(int)y);						
    			}
    			else{
    				printPoint((Graphics2D)g, Color.BLACK, (int)x,(int)y);						
    			} 
    		}
    	}
	
    }
}