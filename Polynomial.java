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
	
	// method to concatenate two arrays of type int
	private int [] concatenate(int [] exp) {
		int len = exponents.length + exp.length;
		int [] result = new int [len];
		
		for (int i = 0; i < exponents.length; i++) {
			result[i] = exponents[i];
		}
		for (int i = exponents.length; i < exp.length; i++) {
			result[i] = exp[i];
		}
		
		return result;
	}
	
	// argument should be the concatenated exponents of the two polynomials
	private int getDistinct(int [] exp) {
		if (exp.length == 0)
			return 0;
		
		int counter = 0;
		
		for (int i = 0; i < exp.length; i++) {
			int checkCommon = exp[i];
			for (int j = i + 1; j < exp.length; j++) {
				if (checkCommon == exp[j])
					break;
				else if (j == exp.length - 1)
					counter++;
			}
		}
		return counter + 1;
	}
	
	// this method checks if an array contains a certain value
	public boolean contains(int [] arr, int start, int end, int val) {
		for (int i = 0; i < end; i++) {
			if (arr[i] == val)
				return true;
		}
		return false;
	}
	
	// this method combines terms with common exponents in the calling object's polynomial
	public void combine() {
		int len = getDistinct(exponents);
		double [] result_c = new double [len];
		int [] result_e = new int [len];
		
		for (int i = 0; i < len; i++) {
			if (contains(exponents, 0, i, exponents[i]) == false) {
				result_e[i] = exponents[i];
				result_c[i] = coefficients[i];
			}
			else {
				continue; // skip this iteration because we already took
						  // this exponent into account
			}
			for (int j = 0; j < exponents.length; j++) {
				if (result_e[i] == exponents[j]) {
					result_c[i] += coefficients[j];
				}
			}
		}
		coefficients = result_c;
		exponents = result_e;
	}
	
	// this method combines terms with common exponents in the polynomial provided in the argument
	public void combine(Polynomial poly) {
		int len = getDistinct(poly.exponents);
		double [] result_c = new double [len];
		int [] result_e = new int [len];
		
		for (int i = 0; i < len; i++) {
			if (contains(poly.exponents, 0, i, poly.exponents[i]) == false) {
				result_e[i] = poly.exponents[i];
				result_c[i] = poly.coefficients[i];
			}
			else {
				continue; // skip this iteration because we already took
						  // this exponent into account
			}
			for (int j = 0; j < poly.exponents.length; j++) {
				if (result_e[i] == poly.exponents[j]) {
					result_c[i] += poly.coefficients[j];
				}
			}
		}
		poly.coefficients = result_c;
		poly.exponents = result_e;
	}

	public Polynomial add(Polynomial poly) {
		
		// get length of resulting polynomial after adding
		int [] allExp = concatenate(poly.exponents);
		int len = getDistinct(allExp);
		
		// now we can initialize the resulting arrays
		// of coefficients and polynomials
		double [] result_c = new double [len];
		int [] result_e = new int [len];
		
		// combining all like terms
		combine();
		combine(poly);
		
		// adding the two polynomials together
		// ...
		
		return Polynomial(result_c, result_e);
	}


	public double evaluate(double x) {
		int len = coefficients.length;
		double result = 0;
		for (int i = 0; i < len; i++) {
			result += coefficients[i]*(Math.pow(x, exponents[i]));
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






