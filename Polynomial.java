import java.lang.Math;

public class Polynomial {
	// fields
	double [] coefficients;

	// methods
	public Polynomial() {
		coefficients = new double[] {0.0};
	}

	public Polynomial(double [] a) {
		int len = a.length;
		coefficients = new double[len];
		for (int i = 0; i < len; i++) {
			coefficients[i] = a[i];
		}
	}

public Polynomial add(Polynomial poly) {

    int len1 = coefficients.length;
    int len2 = poly.coefficients.length;

    double[] result;

    if (len1 > len2) {
    	result = new double[len1];
    } else {
    	result = new double[len2];
    }

    for (int i = 0; i < coefficients.length; i++) {
        result[i] += coefficients[i];
    }
    for (int i = 0; i < poly.coefficients.length; i++) {
        result[i] += poly.coefficients[i];
    }

    return new Polynomial(result);
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
}