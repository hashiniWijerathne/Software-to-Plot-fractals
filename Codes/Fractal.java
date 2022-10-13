
import javax.swing.JFrame;

//class Fractal containing the main method
public class Fractal{
	
	//set the default sizes
	private static double realpos = 1;										//positive bound for real part
	private static double realneg = -1;										//negative bound for real part
	private static double complexpos = 1;									//positive bound for complex part
	private static double complexneg = -1;									//negative bound for complex part
    public static int iterations = 1000;									//no of iterations
    static Complex juliaC = new Complex(-0.4, 0.6);							//Complex C value for Julia Fractal

    //main method
    public static void main(String args[]) {

    	//if first argument is Mandelbrot
        if (args[0].equals("Mandelbrot")) {	
        	//set default value if there are no more arguments
            if (args.length == 1) {											

            }
            //if no of arguments are equal to 5, set the relevant arguments (region of interest)
            else if (args.length == 5) {									
                realneg = Double.parseDouble(args[1]);
                realpos = Double.parseDouble(args[2]);
                complexneg = Double.parseDouble(args[3]);
                complexpos = Double.parseDouble(args[4]);
            } 
            //if no of arguments are equal to 6 set the relevant arguments( region of interest and iterations)
            else if (args.length == 6) {									
                realneg = Double.parseDouble(args[1]);
                realpos = Double.parseDouble(args[2]);
                complexneg = Double.parseDouble(args[3]);
                complexpos = Double.parseDouble(args[4]);
                iterations = Integer.parseInt(args[5]);
            }
            //if no of arguments are invalid
            else {														
                System.out.println("No of arguments are invalid"); 			//print error message
                System.exit(0);												//exit
            }

            // create a frame
	        JFrame frame = new JFrame("Mandelbrot Fractal"); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	        // set the content of the frame as one of this Mandelbrot panel
	        frame.setContentPane(new MandelbrotPanel(realneg,realpos , complexneg , complexpos , iterations)); 
	        frame.pack(); 
		    frame.setLocationRelativeTo(null); 
		    frame.setVisible(true); 
        }

        //if first argument is julia
        else if (args[0].equals("Julia")) {
        	//set default value if there are no more arguments
            if (args.length == 1) {											

            }
            //if there are 3 arguments set the C value
            else if (args.length == 3) {									
                juliaC.real = (Double.parseDouble(args[1]));
                juliaC.imaginary = (Double.parseDouble(args[2])) ;
            }
            //if there are 4 arguments set the C value and no of iterations
            else if (args.length == 4) {									
                juliaC.real = (Double.parseDouble(args[1]));
                juliaC.imaginary = (Double.parseDouble(args[2])) ;
                iterations = Integer.parseInt(args[3]) ;

            }
            //if no of arguments are invalid
            else{
                System.out.println("No of arguments are invalid"); 		//print an error message
                System.exit(0);							//exit
            }

            // create a Julia frame
	        JFrame frame = new JFrame("Julia Fractal"); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	        // set the content of the frame as one of this panel
	        frame.setContentPane(new JuliaPanel(iterations,juliaC)); 
	        frame.pack(); 
		    frame.setLocationRelativeTo(null); 
		    frame.setVisible(true); 

	        
        }
        
        //if the first argument | nameofthe fractal is not correct
        else{																
            System.out.println("Enter the correct Name of the FRACTAL");	//print error
            System.exit(0) ;							//exit
        }
        
       }
}