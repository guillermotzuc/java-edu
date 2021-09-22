package testcodes.towarmup;

public class PointDitance {
	
	private static class Point {
		
		final int x;
		final int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) {
		
		
		Point point1 = new Point(1, 1);
		Point point2 = new Point(2, 4);
		Point point3 = new Point(3, 3);
		
		printdistanceAv(point1, point2, point3);
	
	}
	
	public static void printdistanceAv(Point point1, Point point2, Point point3) {
		
		
		int x1 = point1.x;
		int y1 = point1.y;
		
		int x2 = point2.x;
		int y2 = point2.y;
		
		int x3 = point3.x;
		int y3 = point3.y;
		
		/* (dp) = (dP1P2 + dP1P3 + dP2P3)/3 */
		double dP1P2 = distance(x1, y1, x2, y2);
		double dP1P3 = distance(x1, y1, x3, y3);
		double dP2P3 = distance(x2, y2, x3, y3);
		
		double dp = (dP1P2 + dP1P3 + dP2P3)/3;
		System.out.println("the distance avarage is: " + dp);
	}
	
	public static double distance(int x, int y1, int x2, int y2) {
		
		
		Double distance = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y1, 2));
		return distance;
	}

}
