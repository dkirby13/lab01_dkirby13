import java.lang.*;
public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }

    public static int lcm(int a, int b){
	return Math.abs(a*b) / gcd(a,b);

    }
    
    public Rational plus(Rational r){
	int lcm = lcm(r.denom, this.denom);
	int m1 = lcm/this.denom;
	int m2 = lcm/r.denom;
	int num = m1*this.num + m2*r.num;
	Rational ans = new Rational(num,lcm);

	return ans;
    }

    public static Rational sum(Rational a, Rational b){
	int lcm = lcm(a.denom, b.denom);
	int m1 = lcm/b.denom;
	int m2 = lcm/a.denom;
	int num = m1*b.num + m2*a.num;
	Rational ans = new Rational(num,lcm);

	return ans;
    }

    public Rational minus(Rational r){
	int comDenom = lcm (r.denom, this.denom);
	int newRNum = r.num * this.denom;
	int newThisNum = this.num * r.denom;
	return new Rational((newRNum + (-1*newThisNum)), comDenom);
    }
    
    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	this.num = num;
	this.denom = denom;
	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }

    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}
