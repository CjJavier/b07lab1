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
		for (int i = 0; i < exp.length; i++) {
			result[exponents.length + i] = exp[i];
		}
		
		return result;
	}
	
	// method to concatenate two arrays of type int
	private double [] concatenate(double [] coef) {
		int len = coefficients.length + coef.length;
		double [] result = new double [len];
		
		for (int i = 0; i < coefficients.length; i++) {
			result[i] = coefficients[i];
		}
		for (int i = 0; i < coef.length; i++) {
			result[coefficients.length + i] = coef[i];
		}
		
		return result;
	}
	
    // method to combine like terms in a polynomial
    private Polynomial combine(Polynomial poly) {
    	int length = poly.coefficients.length;
        double [] finalCoefficients = new double[length];
        int [] finalExponents = new int[length];
        int finalIndex = 0;

        for (int i = 0; i < length; i++) {
            boolean found = false;

            // Check if the exponent already exists
            for (int j = 0; j < finalIndex; j++) {
                if (finalExponents[j] == poly.exponents[i]) {
                    finalCoefficients[j] += poly.coefficients[i];
                    found = true;
                    break;
                }
            }

            // if a new exponent was detected, add it and the coefficient to tail of the array
            if (!found) {
                finalCoefficients[finalIndex] = poly.coefficients[i];
                finalExponents[finalIndex] = poly.exponents[i];
                finalIndex++;
            }
        }

        // cutting out unnecessary tail of the arrays
        double [] resultCoefficients = new double[finalIndex];
        int [] resultExponents = new int[finalIndex];
        for (int i = 0; i < finalIndex; i++) {
            resultCoefficients[i] = finalCoefficients[i];
            resultExponents[i] = finalExponents[i];
        }
        return new Polynomial(resultCoefficients, resultExponents);
    }
	
	public Polynomial add(Polynomial poly) {
		
		int [] allExp = concatenate(poly.exponents);
	    double [] allCoef = concatenate(poly.coefficients);
	    
	    Polynomial result = new Polynomial(allCoef, allExp);
		
        // Combine like terms and return the resulting polynomial
        return combine(result);
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
	
	public Polynomial multiply (Polynomial poly) {
		int length = coefficients.length * poly.coefficients.length;
		double [] resultCoefficients = new double[length];
		int [] resultExponents = new int[length];
		int index = 0;
		
		for (int i = 0; i < coefficients.length; i++) {
			for (int j = 0; j < poly.coefficients.length; j++) {
				resultCoefficients[index] = coefficients[i] * poly.coefficients[j];
				resultExponents[index] = exponents[i] + poly.exponents[j];
				index++;
			}
		}
		Polynomial result = new Polynomial(resultCoefficients, resultExponents);
		return combine(result);
	}
}

