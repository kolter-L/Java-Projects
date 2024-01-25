package main;
import java.util.Scanner;

public class segmentsIntersect {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		double[] point1Line1 = {-8, -8};
		double[] point2Line1 = {-2, -2};
		double[] point1Line2 = {5, 1};
		double[] point2Line2 = {-3, -3};
		
		checkIntersection(point1Line1, point2Line1, point1Line2, point2Line2);
		
	}
	
	
	public static void checkIntersection(double[] p1, double[] p2, double[] p3, double[] p4) {
		double lineOneSlope = (p2[1] - p1[1]) / (p2[0] - p1[0]);
		System.out.print("S1: " + lineOneSlope);
		System.out.println();
		double lineTwoSlope = (p4[1] - p3[1]) / (p4[0] - p3[0]);
		System.out.print("S2: " + lineTwoSlope);
		System.out.println();
		
		double lineOneIntercept = (lineOneSlope * (-p1[0])) + p1[1];
		System.out.print("B1: " + lineOneIntercept);
		System.out.println();
		double lineTwoIntercept = (lineTwoSlope * (-p3[0])) + p3[1];
		System.out.print("B2: " + lineTwoIntercept);
		System.out.println();
		
		double[] differenceEquations = {lineOneSlope - lineTwoSlope, lineOneIntercept - lineTwoIntercept};
		
		if (differenceEquations[0] == 0 && differenceEquations[1] != 0) {
			System.out.print("lines are parallel and do not intersect");
		}
		else if (differenceEquations[0] == 0 && differenceEquations[1] == 0) {
			System.out.print("segments lay on the same line");
			
			if (p1[0] <= p3[0] && p1[0] >= p4[0]) {
				System.out.print("segments intersect");
			}
			if (p1[0] >= p3[0] && p1[0] <= p4[0]) {
				System.out.print("segments intersect");
			}
			if (p2[0] <= p3[0] && p2[0] >= p4[0]) {
				System.out.print("segments intersect");
			}
			if (p2[0] >= p3[0] && p2[0] <= p4[0]) {
				System.out.print("segments intersect");
			}
		
		}
		else {
			double xIntercept = -differenceEquations[1] / differenceEquations[0];
			double yIntercept = (lineOneSlope * xIntercept) + lineOneIntercept;
			System.out.print(xIntercept + ", " + yIntercept);
			System.out.println();
			
			if (xIntercept <= p1[0] && xIntercept >= p2[0] && xIntercept <= p3[0] && xIntercept >= p4[0]) {
				System.out.print("segments intersect");
			}
			else if (xIntercept >= p1[0] && xIntercept <= p2[0] && xIntercept <= p3[0] && xIntercept >= p4[0]) {
				System.out.print("segments intersect");
			}
			else if (xIntercept <= p1[0] && xIntercept >= p2[0] && xIntercept >= p3[0] && xIntercept <= p4[0]) {
				System.out.print("segments intersect");
			}
			else if (xIntercept >= p1[0] && xIntercept <= p2[0] && xIntercept >= p3[0] && xIntercept <= p4[0]) {
				System.out.print("segments intersect");
			}
			else {
				System.out.print("no intersection");
			}
		}
	}
}
