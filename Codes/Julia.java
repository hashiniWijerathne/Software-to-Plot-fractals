// create a class to set the Julia Fractal set 
public class Julia {
	
	private double xpix=(2d)/(800d);						//to get the one pixel value of x axis
	private double ypix=(2d)/(800d);						//to get the one pixel value of y axis
	private int iterations ;								//no of iterations
    private Complex z0 = new Complex(0,0) ;					//Zn
    private Complex z1 = new Complex(0,0) ;					//Zn+1
    private Complex initC = new Complex(-1,1) ;
    private Complex constantC = new Complex(0,0);													//to hold a complex number temporarily
    public int i ;	
    private double abs;
    
    //constructor
    Julia(int iter,Complex ConstC){
    	this.iterations = iter;
        this.constantC = ConstC ; 
    }
    
    //method to get the Zn+1 =  Zn^2 + C 
    private static Complex nextjulia(Complex Z0,Complex C) {
    	
        return Complex.sumCmp(Complex.sqrCmp(Z0),C) ;
    }
    
  //check weather point is a Julia or not
    public boolean checkJulia(){																		
    	
    	// get the x and y in complex plane
    	z0.real = initC.real + JuliaPanel.x * xpix ;										
    	z0.imaginary = initC.imaginary - JuliaPanel.y *ypix ;										
   
    	//Perform given number iterations and then see if absolute value of Zn > 2(Zn^2>4)
    	for(i = 0 ; i < iterations ; i++ ){																
            z1 = nextjulia(z0, constantC) ;				//to get the next number
            abs=Complex.absCmp(z0);						//to get the Zn^2
            
            //to check that point is a Julia or not
            if(abs>4){
                return true ;							// if not a Julia number
            }
            else{
            	z0 = z1 ;								// if it is a julia number, assign Zn+1 to Zn					
            }
        }
        return false ;														
    	
    }
}
