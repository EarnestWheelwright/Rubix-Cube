import java.awt.*;
public class Select
{
	//information needed for selection + buttons and passed into the highlight method in Panel class
	public static int row = 0;
	public static int col = 0;
	public static int layer = 0;
	public static int select = 0;
	//returns a color for highlighting
	public static Color highlight()
	{
		return new Color((float) 0, (float) 0, (float) 0, (float) .4);
	}
}