//create a class to get the complex number
public class Complex {
	
	// two variables to get the real and complex parts from the complex number
    double real;
    double imaginary;
    static double absoluteSqr;

    // constructor to initialize real and imaginary variables
    Complex(double real, double img){													
        this.real = real;
        this.imaginary = img ;
    }
    
    //a method to get the square of the complex number
    public static Complex sqrCmp(Complex cmp){												
        Complex sqr1 = new Complex(0,0);									//create a complex number object to return the square of the complex number
        sqr1.real = (cmp.real*cmp.real) -(cmp.imaginary*cmp.imaginary);		//to get the real part of square of complex number
        sqr1.imaginary = 2d* cmp.real *cmp.imaginary ;						//to get the complex part of square of the complex number
        return sqr1;														//to return the result(Square of complex number)
    }

    //a method to get the sum of two complex numbers
    public static Complex sumCmp(Complex cmp1, Complex cmp2){								
        Complex sum1 = new Complex(0,0);									//create a complex number object to return the sum of the two complex numbers
        sum1.real = cmp1.real + cmp2.real ;									//to get the real part after adding real parts of two complex numbers
        sum1.imaginary = cmp1.imaginary + cmp2.imaginary ;					//to get the complex part after adding complex parts of two complex numbers
        return sum1;														//to return the result(addition of two complex numbers)
    }
    
    //a method to get the square of absolute number of the complex number 
    public static double absCmp(Complex cmp){
    	absoluteSqr=Math.pow(cmp.real,2) + Math.pow(cmp.imaginary, 2);	    //to get the square of absolute value of the complex number
        return absoluteSqr;
    }
   
}