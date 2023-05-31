import java.awt.*;
public class CommonShapes{
	private Polygon layers = new Polygon();
	private Polygon layers2 = new Polygon();
	private Polygon columns = new Polygon();
	private Polygon columns2 = new Polygon();
	private Polygon rows = new Polygon();
	private Polygon rows2 = new Polygon();
	private Polygon face1 = new Polygon();
	private Polygon face2 = new Polygon();
	private Polygon face3 = new Polygon();
	private int rad = 100;
	private int x = 25;
	private int y = 50;
	private int x2 = 275;
	private double xUnit = (double) (Math.cos(Math.toRadians(30))*rad/3); //7 	Max Units (including 0)
	private double yUnit = rad/6.0; //13 Max Units (including 0)
	public CommonShapes(){
		//adds points to all of the polygons (shape of the highlighted area)
		columns.addPoint(x + (int)(xUnit * 3), y);
		columns.addPoint(x, y + (int)(yUnit * 3));
		columns.addPoint(x, y + (int)(yUnit * 9));
		columns.addPoint(x + (int)(xUnit), y + (int)(yUnit * 10));
		columns.addPoint(x + (int)(xUnit), y + (int)(yUnit * 4));
		columns.addPoint(x + (int)(xUnit * 4), y + (int)(yUnit));
		columns2.addPoint(x2 + (int)(xUnit), y + (int)(yUnit * 2));
		columns2.addPoint(x2, y + (int)(yUnit * 3));
		columns2.addPoint(x2, y + (int)(yUnit * 9));
		columns2.addPoint(x2 + (int)(xUnit * 3), y + (int)(yUnit * 12));
		columns2.addPoint(x2 + (int)(xUnit * 4), y + (int)(yUnit * 11));
		columns2.addPoint(x2 + (int)(xUnit), y + (int)(yUnit * 8));
		rows.addPoint(x, y + (int)(yUnit * 3));
		rows.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 6));
		rows.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 12));
		rows.addPoint(x + (int)(xUnit * 4), y + (int)(yUnit * 11));
		rows.addPoint(x + (int)(xUnit * 4), y + (int)(yUnit * 5));
		rows.addPoint(x + (int)(xUnit), y + (int)(yUnit * 2));
		rows2.addPoint(x2, y + (int)(yUnit * 9));
    rows2.addPoint(x2 + (int)(xUnit), y + (int)(yUnit * 10));
    rows2.addPoint(x2 + (int)(xUnit * 4), y + (int)(yUnit * 7));
    rows2.addPoint(x2 + (int)(xUnit * 4), y + (int)(yUnit));
    rows2.addPoint(x2 + (int)(xUnit * 3), y);
    rows2.addPoint(x2 + (int)(xUnit * 3), y + (int)(yUnit * 6));
		layers.addPoint(x, y + (int)(yUnit * 7));
		layers.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 10));
		layers.addPoint(x + (int)(xUnit * 6), y + (int)(yUnit * 7));
		layers.addPoint(x + (int)(xUnit * 6), y + (int)(yUnit * 9));
		layers.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 12));
		layers.addPoint(x, y + (int)(yUnit * 9));
		layers2.addPoint(x2, y + (int)(yUnit * 9));
    layers2.addPoint(x2 + (int)(xUnit * 3), y + (int)(yUnit * 6));
    layers2.addPoint(x2 + (int)(xUnit * 6), y + (int)(yUnit * 9));
    layers2.addPoint(x2 + (int)(xUnit * 6), y + (int)(yUnit * 7));
    layers2.addPoint(x2 + (int)(xUnit * 3), y + (int)(yUnit * 4));
    layers2.addPoint(x2, y + (int)(yUnit * 7));
    face1.addPoint(x, y + (int)(yUnit * 3));
		face1.addPoint(x, y + (int)(yUnit * 9));
		face1.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 12));
		face1.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 6));
    face2.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 6));
		face2.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 12));
		face2.addPoint(x + (int)(xUnit * 6), y + (int)(yUnit * 9));
		face2.addPoint(x + (int)(xUnit * 6), y + (int)(yUnit * 3));
    face3.addPoint(x, y + (int)(yUnit * 3));
    face3.addPoint(x + (int)(xUnit * 3), y + (int)(yUnit * 6));
    face3.addPoint(x + (int)(xUnit * 6), y + (int)(yUnit * 3));
    face3.addPoint(x + (int)(xUnit * 3), y);
	}
	public Polygon layers()
		{
		return layers;
		}
	public Polygon layers2()
		{
		return layers2;
		}
	public Polygon columns()
		{
		return columns;
		}
	public Polygon columns2()
		{
		return columns2;
		}
	public Polygon rows()
		{
		return rows;
		}
	public Polygon rows2()
		{
		return rows2;
		}
	public Polygon face1()
		{
		return face1;
		}
	public Polygon face2()
		{
		return face2;
		}
	public Polygon face3()
		{
		return face3;
		}
}