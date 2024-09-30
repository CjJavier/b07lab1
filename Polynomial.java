import java.lang.Math;

public class Polynomial {
	// fields
	double [] coefficients; // must be non-zero coefficients
	int [] exponents;

	// methods
	public Polynomial() {
		coefficients = new double[] {0.0};
		exponents = new int[] {0};
	}

	// a is an array of coefficients
	// b is an array of exponents
	// a and b both have the same length
	public Polynomial(double [] a, int [] b) {
		int len1 = a.length;
		int len2 = b.length;
		coefficients = new double[len1];
		exponents = new int [len2];
		for (int i = 0; i < len1; i++) {
			coefficients[i] = a[i];
			exponents[i] = b[i];
		}
	}
/*
	public int search_exp(int [] exp, int a) {
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == a)
				return true;
		}
		return false;
	}
*/
/*
	// method to get the length of the result polynomial after adding two polynomials
	public int get_length(Polynomial poly) {

		int result = 0;
		// for every distinct exponent we find, add it to result
		for (int i = 0; i)

	}
*/
	public Polynomial add(Polynomial poly) {
	
	    int len1 = coefficients.length;
	    int len2 = poly.coefficients.length;

	
	    double [] result_c;
	    int [] result_e;
	    int counter = 0;

	    if (len1 > len2) {
	    	result_c = new double[len1];
	    	result_e = new int[len1];

	    } else {
	    	result_c = new double[len2];
	    	result_e = new int[len2];
	    }

	    
	
	    return new Polynomial(result_c, result_e);
	}


	public double evaluate(double x) {
		int len = coefficients.length;
		double result = 0;
		for (int i = 0; i < len; i++) {
			result += coefficients[i]*(Math.pow(x, i));
		}
		return result;
	}

	public boolean hasRoot (double x) {
		return evaluate(x) == 0;
	}

/*
	public Polynomial multiply (Polynomial poly) {
		
		// nested loop
		// for each term in the calling object
			// multiply the coefficient

		int len1 = coefficients.length;
		int len2 = poly.coefficients.length;



	} */
}










