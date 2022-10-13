import java.awt.*; /* java abstract window toolkit */
//import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;

public class JuliaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	//one pixel value for x and y axes
	public static double x = 0;																
    public static double y = 0;
    
    private int iterations ;  		// no of iterations
    private Complex constC;   		//constant complex number
   // private int width, height;      // to set the panel size
  
    //constructor
    JuliaPanel(int iter,Complex ConsC){							
        this.iterations = iter;
        this.constC = ConsC ;
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
    	// create a object to Julia
    	Julia obj = new Julia( iterations,constC);

    	//iterate through y and x axes to color the points which are Julia and not, with relatively
    	for(y=0; y<800 ; y++) {																
            for (x=0;x<800 ; x++){															
            	if(obj.checkJulia()){																	
                    printPoint((Graphics2D)g, Color.getHSBColor(obj.i/256f,1,obj.i/(obj.i+8f)), (int)x,(int)y);						
                }
                else{
                    printPoint((Graphics2D)g, Color.BLACK, (int)x,(int)y);						
                } 
            }
        }
}
    
}
