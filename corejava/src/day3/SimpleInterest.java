package day3;
//@FunctionalInterface
public interface SimpleInterest {
	 default double computeInterest(double principal,double rateOfInterest,double duration) {
		return principal*rateOfInterest*duration / 100;
	}
}
