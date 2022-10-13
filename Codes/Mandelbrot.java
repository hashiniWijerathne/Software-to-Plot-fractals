// create a class to set the Mandelbrot Fractal set 
public class Mandelbrot {
	
	//declare the variables to set the Region of Interest
	private double realP ; 						//positive bound of real part
    private double realN ;						//negative bound of real part
    private double complexP ;					//positive bound of complex part
    private double complexN ; 					//negative bound of complex part
   
    private Complex z0 = new Complex(0,0) ;		//Zn
    private Complex z1 = new Complex(0,0) ;		//Zn+1
    
    private Complex initC ;
    private Complex tempC ;						//to hold a complex number temporarily
    
    public int i ;								//variable to iterate through points
    private double abs;							//to get the square of absolute value of the complex number 
    private int iter ;							//number of iterations

    private double xpix;						//to get the one pixel value of x axis
    private double ypix;						//to get the one pixel value of y axis

    //constructor
    Mandelbrot(double realP, double realN, double ComplexP, double ComplexN, int iter){				
        this.realP = realP ;																		
        this.realN = realN ;
        this.complexP = ComplexP ;
        this.complexN = ComplexN ;
        this.iter = iter ;
        this.initC = new Complex(realN,ComplexP);
        this.tempC = new Complex(realN,ComplexP) ;
        this.xpix = (this.realP - this.realN)/800d ;												
        this.ypix = (this.complexP - this.complexN)/800d ;
    }

    // a method to get the Zn+1 =  Zn^2 + C
    private static Complex nextmandelbrot(Complex Z0,Complex C){									
   
        return Complex.sumCmp(Complex.sqrCmp(Z0),C) ;
    }
    
    //check weather point is a Mandelbrot or not
    public boolean checkMandelbrot(){																		
    	
    	// get the x and y in complex plane
    	tempC.real = initC.real + MandelbrotPanel.x * xpix ;										
    	tempC.imaginary = initC.imaginary - MandelbrotPanel.y *ypix ;	
    	
    	// initially set as z0=0
    	z0.real = 0 ;																													
    	z0.imaginary = 0 ;
    	
    	//Perform given number iterations and then see if absolute value of Zn > 2(Zn^2>4)
        for(i = 0 ; i < iter ; i++ ){																
            z1 = nextmandelbrot(z0, tempC) ;		//to get the next number
            abs=Complex.absCmp(z0);					//to get the Zn^2
            
            //to check that point is a Mandelbrot or not
            if(abs>4){
                return true ;						// if not a Mandelbrot number
            }
            else{
            	z0.real = z1.real ;					// if it is a Mandelbrot number, assign Zn+1 to Zn
                z0.imaginary = z1.imaginary ;
            					
            }
        }
        return false ;				
    	
    }
}
