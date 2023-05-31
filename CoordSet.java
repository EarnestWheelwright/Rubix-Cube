//A helper class to assist in creating visual graphics using specified points
public class CoordSet {
	private int[][] coordPoints;

	// Constructor
	public CoordSet(int[][] list) {
		coordPoints = list;
	}

	public int[][] getList() {
		return coordPoints;
	}

	// Sets specified coordinate pair of the shape
	public void setPair(int idx, int x, int y) {
		coordPoints[0][idx] = x;
		coordPoints[1][idx] = y;
	}

	// Returns coordinate pair of specified index of shape
	public int[] getPair(int idx) {
		int[] result = { coordPoints[0][idx], coordPoints[1][idx] };
		return result;
	}

	// For debugging
	public String stringIndex(int idx) {
		return "[" + coordPoints[0][idx] + ", " + coordPoints[1][idx] + "]";
	}
}