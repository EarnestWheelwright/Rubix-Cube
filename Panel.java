import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel{
	private int WIDTH = 500;
	private int HEIGHT = 500;
	private Block[][][] cube;
	private CommonShapes common = new CommonShapes();
	public Panel(Cube c){
		cube = c.getCube();
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
	}

	//Acts like a while loop constantly reloading the display
	public void paint(Graphics g){
		Graphics2D g2D = (Graphics2D) g;
		drawColor(g2D,getTopColorBlocks(100,25,50,275,50));
		drawHexagonTop(g2D,100,25,50);//Display hexagon
		drawHexagonBottom(g2D,100,275,50);
		highlight(Select.select, Select.layer, Select.row, Select.col, g2D);

	}
	
	//Draws hexagon onto the screen
	//r determines radius, from center to corner of hexagon
	//x,y are coordinates of where the top left corner of a square if the hexigon fit perfectly within the square.
	public void drawHexagonTop(Graphics2D g, int r, int x, int y){
		int[][] hexCords = hexagonCoords(r,x,y);
		g.setStroke(new BasicStroke(5));
		g.setPaint(Color.black);
		g.drawPolygon(hexCords[0],hexCords[1],hexCords[0].length);
		drawLines(boarderLineTop(hexCords,r,y),g);
		drawPoly(lineCoordsTop(r,x,y),g);
	}

	//Draws inverted version of HexagonTop
	public void drawHexagonBottom(Graphics2D g, int r, int x, int y){
		int[][] hexCords = hexagonCoords(r,x,y);
	  g.setStroke(new BasicStroke(5));
		g.setPaint(Color.black);
		g.drawPolygon(hexCords[0],hexCords[1],hexCords[0].length);
		drawLines(boarderLineBottom(hexCords,r,y),g);
		drawPoly(lineCoordsBottom(r,x,y),g);
	}
	
	public CoordSet[][][] getTopColorBlocks(int rad, int x1, int y1, int x2, int y2){
		CoordSet[][][] cubeCoords = new CoordSet[6][3][3];
		//Coordinate units
		
		double xUnit = (double) (Math.cos(Math.toRadians(30))*rad/3); //7 Max Units
		double yUnit = rad/6.0; //13 Max Units
		//Top Left
		for (int y=0; y<3; y++){
			for (int x=0; x<3; x++){
				int[][] coords = new int[2][4];
				coords[0][0] = x1 + (int) (xUnit*x);
				coords[0][1] = x1 + (int) (xUnit*(x+1));
				coords[0][2] = x1 + (int) (xUnit*(x+1));
				coords[0][3] = x1 + (int) (xUnit*x);
				coords[1][0] = y1 + (int) (yUnit*(y*2+3+x));
				coords[1][1] = y1 + (int) (yUnit*(y*2+4+x));
				coords[1][2] = y1 + (int) (yUnit*(y*2+6+x));
				coords[1][3] = y1 + (int) (yUnit*(y*2+5+x));
				cubeCoords[0][y][x] = new CoordSet(coords);
			}
		}
		//Top Top
		for (int y=0; y<3; y++){
			for (int x=0; x<3; x++){
				int[][] coords = new int[2][4];
				coords[0][0] = x1 + (int) (xUnit*(x+2-y));
				coords[0][1] = x1 + (int) (xUnit*(x+3-y));
				coords[0][2] = x1 + (int) (xUnit*(x+4-y));
				coords[0][3] = x1 + (int) (xUnit*(x+3-y));
				coords[1][0] = y1 + (int) (yUnit*(y+1+x));
				coords[1][1] = y1 + (int) (yUnit*(y+x));
				coords[1][2] = y1 + (int) (yUnit*(y+1+x));
				coords[1][3] = y1 + (int) (yUnit*(y+2+x));
				cubeCoords[1][y][x] = new CoordSet(coords);
			}
		}
		//Top Right
		for (int y=0; y<3; y++){
			for (int x=0; x<3; x++){
				int[][] coords = new int[2][4];
				coords[0][0] = x1 + (int) (xUnit*(x+3));
				coords[0][1] = x1 + (int) (xUnit*(x+4));
				coords[0][2] = x1 + (int) (xUnit*(x+4));
				coords[0][3] = x1 + (int) (xUnit*(x+3));
				coords[1][0] = y1 + (int) (yUnit*(y*2+6-x));
				coords[1][1] = y1 + (int) (yUnit*(y*2+5-x));
				coords[1][2] = y1 + (int) (yUnit*(y*2+7-x));
				coords[1][3] = y1 + (int) (yUnit*(y*2+8-x));
				cubeCoords[2][y][x] = new CoordSet(coords);
			}
		}
		
		//Bottom Left
		for (int y=0; y<3; y++){
			for (int x=0; x<3; x++){
				int[][] coords = new int[2][4];
				coords[0][0] = x2 + (int) (xUnit*x);
				coords[0][1] = x2 + (int) (xUnit*(x+1));
				coords[0][2] = x2 + (int) (xUnit*(x+1));
				coords[0][3] = x2 + (int) (xUnit*x);
				coords[1][0] = y2 + (int) (yUnit*(y*2+3-x));
				coords[1][1] = y2 + (int) (yUnit*(y*2+2-x));
				coords[1][2] = y2 + (int) (yUnit*(y*2+4-x));
				coords[1][3] = y2 + (int) (yUnit*(y*2+5-x));
				cubeCoords[3][y][x] = new CoordSet(coords);
			}
		}
		//Bottom Bottom
		for (int y=0; y<3; y++){
			for (int x=0; x<3; x++){
				int[][] coords = new int[2][4];
				coords[0][0] = x2 + (int) (xUnit*(x+2-y));
				coords[0][1] = x2 + (int) (xUnit*(x+3-y));
				coords[0][2] = x2 + (int) (xUnit*(x+4-y));
				coords[0][3] = x2 + (int) (xUnit*(x+3-y));
				coords[1][0] = y2 + (int) (yUnit*(y+7+x));
				coords[1][1] = y2 + (int) (yUnit*(y+6+x));
				coords[1][2] = y2 + (int) (yUnit*(y+7+x));
				coords[1][3] = y2 + (int) (yUnit*(y+8+x));
				cubeCoords[4][y][x] = new CoordSet(coords);
			}
		}
		//Bottom Right
		for (int y=0; y<3; y++){
			for (int x=0; x<3; x++){
				int[][] coords = new int[2][4];
				coords[0][0] = x2 + (int) (xUnit*(x+3));
				coords[0][1] = x2 + (int) (xUnit*(x+4));
				coords[0][2] = x2 + (int) (xUnit*(x+4));
				coords[0][3] = x2 + (int) (xUnit*(x+3));
				coords[1][0] = y2 + (int) (yUnit*(y*2+x));
				coords[1][1] = y2 + (int) (yUnit*(y*2+1+x));
				coords[1][2] = y2 + (int) (yUnit*(y*2+3+x));
				coords[1][3] = y2 + (int) (yUnit*(y*2+2+x));
				cubeCoords[5][y][x] = new CoordSet(coords);
			}
		}
		return cubeCoords;
		}

	
	//Adds specified colors into certain Coordinate locations
	public void drawColor(Graphics2D g, CoordSet[][][] c){
			/*	
			Color[] colors = 
			Cube coordinates: Cube[y][x][z] = Cube[row][col][height]
			Cube face patterns
			Top - z=2
			frontLeft - x=2
			frontRight - y=2
			Bottom - z=0
			backLeft - x=0
			backRight - y=0
	 		*/
			
	 		//Top Loop
	 		for(int y=0; y<3;y++){
				for(int x=0; x<3; x++){
					//get correct color direction
		 			Color color = Color.cyan;
					Block b = cube[y][x][2];
		 			if(b.getColor1Direction().equals("top")){
						color = b.getColor1();
					}
		 			else if(b.getColor2Direction() != null && b.getColor2Direction().equals("top")){
						color = b.getColor2();
					}
		 			else if(b.getColor3Direction() != null && b.getColor3Direction().equals("top")){
						color = b.getColor3();
					}
		 			int[][] list =c[1][y][x].getList();
					g.setColor(color);
					g.fillPolygon(list[0],list[1],4);
				}
			}
			
				
			
	 		//frontLeft loop
	 		for(int z=0; z<3; z++){
				for(int x=0; x<3; x++){
					//get correct color direction
		 			Color color = Color.cyan;
					Block b = cube[2][x][z];
		 			if(b.getColor1Direction().equals("frontLeft")){
						color = b.getColor1();
					}
		 			else if(b.getColor2Direction() != null && b.getColor2Direction().equals("frontLeft")){
						color = b.getColor2();
					}
		 			else if(b.getColor3Direction() != null && b.getColor3Direction().equals("frontLeft")){
						color = b.getColor3();
					}
		 			int[][] list =c[0][2-z][x].getList();
					g.setColor(color);
					g.fillPolygon(list[0],list[1],4);
				}
			}
			//frontRight loop
	 		for(int x=2; x>=0; x--){
				for(int z=2; z>=0; z--){
					//get correct color direction
		 			Color color = Color.cyan;
					Block b = cube[2-x][2][2-z];
		 			if(b.getColor1Direction().equals("frontRight")){
						color = b.getColor1();
					}
		 			else if(b.getColor2Direction() != null && b.getColor2Direction().equals("frontRight")){
						color = b.getColor2();
					}
		 			else if(b.getColor3Direction() != null && b.getColor3Direction().equals("frontRight")){
						color = b.getColor3();
					}
		 			int[][] list =c[2][z][x].getList();
					g.setColor(color);
					g.fillPolygon(list[0],list[1],4);
				}
			}

	 		
	 		//Bottom Loop
	 		for(int y=0; y<3;y++){
				for(int x=0; x<3; x++){
					//get correct color direction
		 			Color color = Color.cyan;
					Block b = cube[x][y][0];
		 			if(b.getColor1Direction().equals("bottom")){
						color = b.getColor1();
					}
		 			else if(b.getColor2Direction() != null && b.getColor2Direction().equals("bottom")){
						color = b.getColor2();
					}
		 			else if(b.getColor3Direction() != null && b.getColor3Direction().equals("bottom")){
						color = b.getColor3();
					}
		 			int[][] list =c[4][y][x].getList();
					g.setColor(color);
					g.fillPolygon(list[0],list[1],4);
				}
			}
			
				
			
	 		//backLeft loop
	 		for(int z=0; z<3; z++){
				for(int y=2; y>=0; y--){
					//get correct color direction
		 			Color color = Color.cyan;
					Block b = cube[0][2-y][2-z];
		 			if(b.getColor1Direction().equals("backLeft")){
						color = b.getColor1();
					}
		 			else if(b.getColor2Direction() != null && b.getColor2Direction().equals("backLeft")){
						color = b.getColor2();
					}
		 			else if(b.getColor3Direction() != null && b.getColor3Direction().equals("backLeft")){
						color = b.getColor3();
					}
		 			int[][] list =c[3][z][y].getList();
					g.setColor(color);
					g.fillPolygon(list[0],list[1],4);
				}
			}
			//backRight loop
	 		for(int z=2; z>=0; z--){
				for(int x=0; x<3; x++){
					//get correct color direction
		 			Color color = Color.cyan;
					Block b = cube[x][0][z];
		 			if(b.getColor1Direction().equals("backRight")){
						color = b.getColor1();
					}
		 			else if(b.getColor2Direction() != null && b.getColor2Direction().equals("backRight")){
						color = b.getColor2();
					}
		 			else if( b.getColor3Direction() != null && b.getColor3Direction().equals("backRight")){
						color = b.getColor3();
					}
		 			int[][] list =c[5][2-z][x].getList();
					g.setColor(color);
					g.fillPolygon(list[0],list[1],4);
				}
			}
		}
	

	//coords is a 2d array containing one array of x coordinates, and one array of y coordinates
	//There must be an equal number of X and Y coordinates
	//Coordinates must come in pairs (no odd number of total X or Y coordinates)
	public void drawLines(int[][] coords,Graphics2D g){
		g.setStroke(new BasicStroke(4));
		for(int c=0; c<coords[0].length; c+=2){
			g.drawLine(coords[0][c],coords[1][c],coords[0][c+1],coords[1][c+1]);
		}
	}

	
	//Draws multiple polygons according to the set of coords
	public void drawPoly(CoordSet[] coords, Graphics2D g){
		g.setStroke(new BasicStroke(4));
		for(CoordSet c: coords){
			int[][] points = c.getList();
			g.drawPolygon(points[0],points[1],points[0].length);
		}
	}

	
	//Sperates the cube into 3 primary sections
	public int[][] boarderLineTop(int[][] hex, int r, int y){
		//hex[0] -> x coordinates
		//hex[1] -> y coordinates
		int[] xPoint = new int[6], yPoint = new int[6];
		//Boarder Lines
		for (int i=0; i<3; i++){
			xPoint[i*2] = hex[0][i*2+1];
			yPoint[i*2] = hex[1][i*2+1];
			xPoint[i*2+1] = hex[0][0];
			yPoint[i*2+1] = y+r;
		}
		int[][] result = {xPoint, yPoint};
		return result;
	}

	
	//Seperates the cube into 3 primary sections, mirrior of boarderLineTop
	public int[][] boarderLineBottom(int[][] hex, int r, int y){
		int[][] result = boarderLineTop(hex,r,y);
		for (int i=0; i<result[1].length; i++){
			// center = y+r
			result[1][i] -= (result[1][i] - (y+r))*2;
		}
		return result;
	}
	//Returns a set of coordinates objects of a 6 sided shape of divider lines for the cube
	public CoordSet[] lineCoordsTop(int rad, int x, int y){
		CoordSet[] result = new CoordSet[3];
		double xUnit = (double) (Math.cos(Math.toRadians(30))*rad/3); //7 Max Units (including 0)
		double yUnit = rad/6.0; //13 Max Units (including 0)

		//part 1
		result[0] = new CoordSet(new int[2][6]);
		result[0].setPair(0,x + (int) xUnit, y + (int) (yUnit*10));
		result[0].setPair(1,x + (int) xUnit, y + (int) (yUnit*4));
		result[0].setPair(2,x + (int) (xUnit*4), y + (int) yUnit);
		result[0].setPair(3,x + (int) (xUnit*5), y + (int) (yUnit*2));
		result[0].setPair(4,x + (int) (xUnit*2), y + (int) (yUnit*5));
		result[0].setPair(5,x + (int) (xUnit*2), y + (int) (yUnit*11));
		//part 2
		result[1] = new CoordSet(new int[2][6]);
		result[1].setPair(0,x + (int) (xUnit),y + (int) (yUnit*2));
		result[1].setPair(1,x + (int) (xUnit*2),y + (int) (yUnit));
		result[1].setPair(2,x + (int) (xUnit*5),y + (int) (yUnit*4));
		result[1].setPair(3,x + (int) (xUnit*5),y + (int) (yUnit*10));
		result[1].setPair(4,x + (int) (xUnit*4),y + (int) (yUnit*11));
		result[1].setPair(5,x + (int) (xUnit*4),y + (int) (yUnit*5));

		//part 3
		result[2] = new CoordSet(new int[2][6]);
		result[2].setPair(0,x,y + (int) (yUnit*7));
		result[2].setPair(1,x,y + (int) (yUnit*5));
		result[2].setPair(2,x + (int) (xUnit*3),y + (int) (yUnit*8));
		result[2].setPair(3,x + (int) (xUnit*6),y + (int) (yUnit*5));
		result[2].setPair(4,x + (int) (xUnit*6),y + (int) (yUnit*7));
		result[2].setPair(5,x + (int) (xUnit*3),y + (int) (yUnit*10));
		return result;
	}

	
	//Returns a set of coordinate objects in the shape of a shape, a mirror result of lineCoordsTop;
	public CoordSet[] lineCoordsBottom(int r, int x, int y){
		CoordSet[] result = lineCoordsTop(r,x,y);
		for(int i=0; i<result.length; i++){
			for(int c=0; c<result[i].getList()[0].length; c++){
				int[] point = result[i].getPair(c);
				result[i].setPair(c,point[0], y+r - (point[1] - (y+r)));
				//System.out.println(result[i].stringIndex(c));
			}
		}
		return result;
	}
	
	//Returns a set of coordinates (Helper function) to draw a hexagon
	//r determines radius, from center to corner of hexagon
	//x,y are coordinates of where the top left corner of a square if the hexigon fit perfectly within the square.
	public int[][] hexagonCoords(int r, int x, int y){
		int[] xPoint = new int[6];
		int[] yPoint = new int[6];
		
		//Image is calculated as a square, top left determines placement
		//Very top point (12 O'Clock)
		int cosVal = (int) (Math.cos(Math.toRadians(30))*r);
		xPoint[0] = x + cosVal;
		yPoint[0] = y;
		//Top Right
		xPoint[1] = x + cosVal*2;
		yPoint[1] = y + r/2;
		//Bottom Right
		xPoint[2] = x + cosVal*2;
		yPoint[2] = y + r*3/2;
		//Very Bottom
		xPoint[3] = x + cosVal;
		yPoint[3] = y + 2*r;
		//Bottom Left
		xPoint[4] = x;
		yPoint[4] = y + r*3/2;
		//Top Left
		xPoint[5] = x;
		yPoint[5] = y + r/2;

		//return values
		int[][] result = {xPoint,yPoint};
		//printCords(result);
		return result;
	}
//highlights selected part of the cube
	public void highlight(int select, int layer, int row, int col, Graphics2D g)
	{
		
		int rad = 100;
		int x = 25;
    int y = 50;
		int x2 = 275;
		double xUnit = (double) (Math.cos(Math.toRadians(30))*rad/3); //7 Max Units (including 0)
		double yUnit = rad/6.0; //13 Max Units (including 0)
		//sets the highlight color
		g.setColor(Select.highlight());
		Polygon layers = common.layers();
		Polygon layers2 = common.layers2();
		Polygon columns = common.columns();
		Polygon columns2 = common.columns2();
		Polygon rows = common.rows();
		Polygon rows2 = common.rows2();
		Polygon face1 = common.face1();
		Polygon face2 = common.face2();
		Polygon face3 = common.face3();
		if(select == 0)
		{
			if(layer == 0)
			{
				g.fillPolygon(layers);
				g.fillPolygon(layers2);
				face3.translate(x2 - x, (int)(yUnit * 6));
				g.fillPolygon(face3);
				face3.translate(-(x2 - x), -((int)(yUnit * 6)));
			}
			else if(layer == 1)
			{
				layers.translate(0, (int)(-yUnit*2));
				layers2.translate(0, (int)(-yUnit*2));
				g.fillPolygon(layers);
				g.fillPolygon(layers2);
				layers.translate(0, -((int)(-yUnit*2)));
				layers2.translate(0, -((int)(-yUnit*2)));
			}
			else
			{
				layers.translate(0, (int)(-2 * yUnit*2));
				layers2.translate(0, (int)(-2*yUnit*2));
				g.fillPolygon(layers);
				g.fillPolygon(layers2);
				g.fillPolygon(face3);
				layers.translate(0, -((int)(-2 * yUnit*2)));
				layers2.translate(0, -((int)(-2*yUnit*2)));
			}
		}
		else if(select == 1)
		{
			if(row == 0)
			{
				rows.translate((int)(xUnit * 2), (int)(yUnit * -2));
				face2.translate(x2 - x + (int)(xUnit * -3), (int)(yUnit * -3));
				g.fillPolygon(rows);
				g.fillPolygon(rows2);
				g.fillPolygon(face2);
				rows.translate(-((int)(xUnit * 2)), -((int)(yUnit * -2)));
				face2.translate(-(x2 - x + (int)(xUnit * -3)), -((int)(yUnit * -3)));
			}
			else if(row == 1)
			{
				rows.translate((int)(xUnit), (int)(-yUnit));
				rows2.translate((int)(xUnit), (int)(yUnit));
				g.fillPolygon(rows);
				g.fillPolygon(rows2);
				rows.translate(-((int)(xUnit)), -((int)(-yUnit)));
				rows2.translate(-((int)(xUnit)), -((int)(yUnit)));
			}
			else
			{
				rows2.translate((int)(xUnit * 2), (int)(yUnit * 2));
				g.fillPolygon(rows);
				g.fillPolygon(rows2);
				g.fillPolygon(face1);
				rows2.translate(-((int)(xUnit * 2)), -((int)(yUnit * 2)));
			}
		}
		else
		{
			if(col == 0)
			{
				columns2.translate((int)(xUnit*2), (int)(yUnit*-2));
				face1.translate(x2 - x + (int)(xUnit * 3), (int)(yUnit * -3));
				g.fillPolygon(columns);
				g.fillPolygon(columns2);
				g.fillPolygon(face1);
				columns2.translate(-((int)(xUnit*2)), -((int)(yUnit*-2)));
				face1.translate(-(x2 - x + (int)(xUnit * 3)), -((int)(yUnit * -3)));
			}
			else if(col == 1)
			{
				columns.translate((int)(xUnit), (int)(yUnit));
				columns2.translate((int)(xUnit), (int)(-yUnit));
				g.fillPolygon(columns);
				g.fillPolygon(columns2);
				columns.translate(-((int)(xUnit)), -((int)(yUnit)));
				columns2.translate(-((int)(xUnit)), -((int)(-yUnit)));
			}
			else
			{
				columns.translate((int)(xUnit*2), (int)(yUnit*2));
				g.fillPolygon(columns);
				g.fillPolygon(columns2);
				g.fillPolygon(face2);
				columns.translate(-((int)(xUnit*2)), -((int)(yUnit*2)));
			}
		}
	}

	//Debugging method
	public void printCords(int[][] cords){
		for (int c=0; c<cords[0].length;c++){
			System.out.println(cords[0][c] + ", "+ cords[1][c]);
		}
	}
}