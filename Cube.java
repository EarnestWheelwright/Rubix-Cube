import java.awt.*;

public class Cube
{
	//Rubik's Cube array
	private Block[][][] cube = new Block[3][3][3];
	//Instantiates a solved Rubik's Cube
	public Cube()
	{
		cube[0][0][0] = new Block("White", "bottom", "Green", "backLeft", "Orange", "backRight");
		cube[1][0][0] = new Block("White", "bottom", "Orange", "backRight");
		cube[2][0][0] = new Block("White", "bottom", "Orange", "backRight", "Yellow", "frontLeft");
		cube[0][1][0] = new Block("White", "bottom", "Green", "backLeft");
		cube[1][1][0] = new Block("White", "bottom");
		cube[2][1][0] = new Block("White", "bottom", "Yellow", "frontLeft");
		cube[0][2][0] = new Block("White", "bottom", "Green", "backLeft", "Red", "frontRight");
		cube[1][2][0] = new Block("White", "bottom", "Red", "frontRight");
		cube[2][2][0] = new Block("White", "bottom", "Yellow", "frontLeft", "Red", "frontRight");
		cube[0][0][1] = new Block("Green", "backLeft", "Orange", "backRight");
		cube[1][0][1] = new Block("Orange", "backRight");
		cube[2][0][1] = new Block("Orange", "backRight", "Yellow", "frontLeft");
		cube[0][1][1] = new Block("Green", "backLeft");
		cube[1][1][1] = null;
		cube[2][1][1] = new Block("Yellow", "frontLeft");
		cube[0][2][1] = new Block("Green", "backLeft", "Red", "frontRight");
		cube[1][2][1] = new Block("Red", "frontRight");
		cube[2][2][1] = new Block("Yellow", "frontLeft", "Red", "frontRight");
		cube[0][0][2] = new Block("Blue", "top", "Green", "backLeft", "Orange", "backRight");
		cube[1][0][2] = new Block("Blue", "top", "Orange", "backRight");
		cube[2][0][2] = new Block("Blue", "top", "Orange", "backRight", "Yellow", "frontLeft");
		cube[0][1][2] = new Block("Blue", "top", "Green", "backLeft");
		cube[1][1][2] = new Block("Blue", "top");
		cube[2][1][2] = new Block("Blue", "top", "Yellow", "frontLeft");
		cube[0][2][2] = new Block("Blue", "top", "Green", "backLeft", "Red", "frontRight");
		cube[1][2][2] = new Block("Blue", "top", "Red", "frontRight");
		cube[2][2][2] = new Block("Blue", "top", "Yellow", "frontLeft", "Red", "frontRight");
	}
	//Rotates the layer at height h to the right
	public void rotateLeft(int h)
	{
		Block[][] arr = new Block[3][3];
		for(int r = 0; r < 3; r++)
			{
				for(int c = 0; c < 3; c++)
					{
						arr[c][r] = cube[r][c][h];
					}
			}
		for(int r = 0; r < 3; r++)
			{
				for(int c = 0; c < 3; c++)
					{
						cube[r][c][h] = arr[r][2-c];
					}
			}
		for(int r = 0; r < 3; r++)
			{
				for(int c = 0; c < 3; c++)
					{
						if(cube[r][c][h] == null)
						{
							cube[r][c][h] = null;
						}
						else
						{	
							cube[r][c][h].rotate90Left();
						}
					}
			}
	}
	//Rotates the layer at height h to the left
	public void rotateRight(int h)
	{
		Block[][] arr = new Block[3][3];
		for(int r = 0; r < 3; r++)
			{
				for(int c = 0; c < 3; c++)
					{
						arr[2-c][r] = cube[r][c][h];
					}
			}
		for(int r = 0; r < 3; r++)
			{
				for(int c = 0; c < 3; c++)
					{
						cube[r][c][h] = arr[r][c];
					}
			}
		for(int r = 0; r < 3; r++)
			{
				for(int c = 0; c < 3; c++)
					{
						if(cube[r][c][h] == null)
						{
							cube[r][c][h] = null;
						}
						else
						{	
							cube[r][c][h].rotate90Right();
						}
					}
			}
	}
	//Rotates row r up
	public void rotateRowUp(int r)
	{
		Block[][] arr = new Block[3][3];
		for(int c = 0; c < 3; c++)
			{
				for(int h = 0; h < 3; h++)
					{
						arr[h][c] = cube[r][c][h];
					}
			}
		for(int c = 0; c < 3; c++)
			{
				for(int h = 0; h < 3; h++)
					{
						cube[r][c][h] = arr[c][2-h];
					}
			}
		for(int h = 0; h < 3; h++)
			{
				for(int c = 0; c < 3; c++)
					{
						if((r == 1 && c == 1) && h == 1)
						{
							cube[r][c][h] = null;
						}
						else
						{	
							cube[r][c][h].rotate90LeftUp();
						}
					}
			}
	}
	//Rotates row r down
	public void rotateRowDown(int r)
	{
		Block[][] arr = new Block[3][3];
		for(int c = 0; c < 3; c++)
			{
				for(int h = 0; h < 3; h++)
					{
						arr[h][c] = cube[r][c][h];
					}
			}
		for(int c = 0; c < 3; c++)
			{
				for(int h = 0; h < 3; h++)
					{
						cube[r][c][h] = arr[2-c][h];
					}
			}
		for(int h = 0; h < 3; h++)
			{
				for(int c = 0; c < 3; c++)
					{
						if((r == 1 && c == 1) && h == 1)
						{
							cube[r][c][h] = null;
						}
						else
						{	
							cube[r][c][h].rotate90LeftDown();
						}
					}
			}
	}
	//Rotates col c up
	public void rotateColDown(int c)
	{
		Block[][] arr = new Block[3][3];
		for(int r = 0; r < 3; r++)
			{
				for(int h = 0; h < 3; h++)
					{
						arr[h][r] = cube[r][c][h];
					}
			}
		for(int r = 0; r < 3; r++)
			{
				for(int h = 0; h < 3; h++)
					{
						cube[r][c][h] = arr[r][2-h];
					}
			}
		for(int r = 0; r < 3; r++)
			{
				for(int h = 0; h < 3; h++)
					{
						if((r == 1 && c == 1) && h == 1)
						{
							cube[r][c][h] = null;
						}
						else
						{	
							cube[r][c][h].rotate90RightDown();
						}
					}
			}
	}
	//Rotates col c down
	public void rotateColUp(int c)
	{
		Block[][] arr = new Block[3][3];
		for(int r = 0; r < 3; r++)
			{
				for(int h = 0; h < 3; h++)
					{
						arr[h][r] = cube[r][c][h];
					}
			}
		for(int r = 0; r < 3; r++)
			{
				for(int h = 0; h < 3; h++)
					{
						cube[r][c][h] = arr[2-r][h];
					}
			}
		for(int r = 0; r < 3; r++)
			{
				for(int h = 0; h < 3; h++)
					{
						if((r == 1 && c == 1) && h == 1)
						{
							cube[r][c][h] = null;
						}
						else
						{	
							cube[r][c][h].rotate90RightUp();
						}
					}
			}
	}
	//Scrambles the cube
	public void scramble()
	{
		int choose;
		for(int i = 0; i < 10; i++)
			{
				int rand = 0;
				choose = (int) (Math.random()*6);
				if(choose == 0){
					rand = (int) (Math.random()*3);
					rotateLeft(rand);
					System.out.println("rotateLeft(" + rand + ")");
				}
				if(choose == 1){
					rand = (int) (Math.random()*3);
					rotateRight(rand);
					System.out.println("rotateRight(" + rand + ")");
				}
				if(choose == 2){
					rand = (int) (Math.random()*3);
					rotateColUp(rand);
					System.out.println("rotateColUp(" + rand + ")");
				}
				if(choose == 3){
					rand = (int) (Math.random()*3);
					rotateColDown(rand);
					System.out.println("rotateColDown(" + rand + ")");
				}
				if(choose == 4){
					rand = (int) (Math.random()*3);
					rotateRowUp(rand);
					System.out.println("rotateRowUp(" + rand + ")");
				}
				if(choose == 5){
					rand = (int) (Math.random()*3);
					rotateRowDown(rand);
					System.out.println("rotateRowDown(" + rand + ")");
				}
			}
	}
	//Resets the cube to solved state
	public void reset()
	{
		cube[0][0][0] = new Block("White", "bottom", "Green", "backLeft", "Orange", "backRight");
		cube[1][0][0] = new Block("White", "bottom", "Orange", "backRight");
		cube[2][0][0] = new Block("White", "bottom", "Orange", "backRight", "Yellow", "frontLeft");
		cube[0][1][0] = new Block("White", "bottom", "Green", "backLeft");
		cube[1][1][0] = new Block("White", "bottom");
		cube[2][1][0] = new Block("White", "bottom", "Yellow", "frontLeft");
		cube[0][2][0] = new Block("White", "bottom", "Green", "backLeft", "Red", "frontRight");
		cube[1][2][0] = new Block("White", "bottom", "Red", "frontRight");
		cube[2][2][0] = new Block("White", "bottom", "Yellow", "frontLeft", "Red", "frontRight");
		cube[0][0][1] = new Block("Green", "backLeft", "Orange", "backRight");
		cube[1][0][1] = new Block("Orange", "backRight");
		cube[2][0][1] = new Block("Orange", "backRight", "Yellow", "frontLeft");
		cube[0][1][1] = new Block("Green", "backLeft");
		cube[1][1][1] = null;
		cube[2][1][1] = new Block("Yellow", "frontLeft");
		cube[0][2][1] = new Block("Green", "backLeft", "Red", "frontRight");
		cube[1][2][1] = new Block("Red", "frontRight");
		cube[2][2][1] = new Block("Yellow", "frontLeft", "Red", "frontRight");
		cube[0][0][2] = new Block("Blue", "top", "Green", "backLeft", "Orange", "backRight");
		cube[1][0][2] = new Block("Blue", "top", "Orange", "backRight");
		cube[2][0][2] = new Block("Blue", "top", "Orange", "backRight", "Yellow", "frontLeft");
		cube[0][1][2] = new Block("Blue", "top", "Green", "backLeft");
		cube[1][1][2] = new Block("Blue", "top");
		cube[2][1][2] = new Block("Blue", "top", "Yellow", "frontLeft");
		cube[0][2][2] = new Block("Blue", "top", "Green", "backLeft", "Red", "frontRight");
		cube[1][2][2] = new Block("Blue", "top", "Red", "frontRight");
		cube[2][2][2] = new Block("Blue", "top", "Yellow", "frontLeft", "Red", "frontRight");
	}
	//Returns the 3D Block Array
	public Block[][][] getCube()
	{
		return cube;
	}
	//prints out the cube in the console
	public String toString()
	{
		String temp = "";
		for(int h = 0; h < 3; h++)
			{
				for(int r = 0; r < 3; r++)
					{
						for(int c = 0; c < 3; c++)
							{
								if(r == 1 && c == 1 && h == 1)
								{
									temp += "Center   ";
								}
								else
								{
									temp += cube[r][c][h].getColors() + "   ";
								}
							}
						temp += "\n";
						for(int c = 0; c < 3; c++)
							{
								if(r == 1 && c == 1 && h == 1)
								{
									temp += "Center   ";
								}
								else
								{
									temp += cube[r][c][h].getColorDirections() + "   ";
								}
							}
						temp += "\n";
					}
				temp += "\n";
			}
		return temp;
	}

  public boolean solved()
	{
		int temp = 0;
		Color currentColor = cube[1][1][temp].getColor1();
    for(int r = 0; r < 3; r++)
    {
      for(int c = 0; c < 3; c++)
      {
				if(cube[r][c][temp].getColor1Direction().equals("bottom"))
				{
					if(!cube[r][c][temp].getColor1().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[r][c][temp].getColor2Direction() == null)
				{
					return false;
				}
				else if(cube[r][c][temp].getColor2Direction().equals("bottom"))
				{
					if(!cube[r][c][temp].getColor2().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[r][c][temp].getColor3Direction() == null)
				{
					return false;
				}
				else if(cube[r][c][temp].getColor3Direction().equals("bottom"))
				{
					if(!cube[r][c][temp].getColor3().equals(currentColor))
					{
						return false;
					}
				}
      }  
    }
		temp = 2;
		currentColor = cube[1][1][temp].getColor1();
    for(int r = 0; r < 3; r++)
    {
      for(int c = 0; c < 3; c++)
      {
				if(cube[r][c][temp].getColor1Direction().equals("top"))
				{
					if(!cube[r][c][temp].getColor1().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[r][c][temp].getColor2Direction() == null)
				{
					return false;
				}
				else if(cube[r][c][temp].getColor2Direction().equals("top"))
				{
					if(!cube[r][c][temp].getColor2().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[r][c][temp].getColor3Direction() == null)
				{
					return false;
				}
				else if(cube[r][c][temp].getColor3Direction().equals("top"))
				{
					if(!cube[r][c][temp].getColor3().equals(currentColor))
					{
						return false;
					}
				}
      }  
    }
		temp = 0;
		currentColor = cube[1][temp][1].getColor1();
    for(int r = 0; r < 3; r++)
    {
      for(int h = 0; h < 3; h++)
      {
				if(cube[r][temp][h].getColor1Direction().equals("backRight"))
				{
					if(!cube[r][temp][h].getColor1().equals(currentColor))
					{
            return false;
					}
				}
				else if(cube[r][temp][h].getColor2Direction() == null)
				{
          return false;
				}
				else if(cube[r][temp][h].getColor2Direction().equals("backRight"))
				{
					if(!cube[r][temp][h].getColor2().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[r][temp][h].getColor3Direction() == null)
				{
					return false;
				}
				else if(cube[r][temp][h].getColor3Direction().equals("backRight"))
				{
					if(!cube[r][temp][h].getColor3().equals(currentColor))
					{
						return false;
					}
				}
      }  
    }
    temp = 2;
		currentColor = cube[1][temp][1].getColor1();
    for(int r = 0; r < 3; r++)
    {
      for(int h = 0; h < 3; h++)
      {
				if(cube[r][temp][h].getColor1Direction().equals("frontRight"))
				{
					if(!cube[r][temp][h].getColor1().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[r][temp][h].getColor2Direction() == null)
				{
					return false;
				}
				else if(cube[r][temp][h].getColor2Direction().equals("frontRight"))
				{
					if(!cube[r][temp][h].getColor2().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[r][temp][h].getColor3Direction() == null)
				{
					return false;
				}
				else if(cube[r][temp][h].getColor3Direction().equals("frontRight"))
				{
					if(!cube[r][temp][h].getColor3().equals(currentColor))
					{
						return false;
					}
				}
      }  
    }
		temp = 0;
		currentColor = cube[temp][1][1].getColor1();
    for(int c = 0; c < 3; c++)
    {
      for(int h = 0; h < 3; h++)
      {
				if(cube[temp][c][h].getColor1Direction().equals("backLeft"))
				{
					if(!cube[temp][c][h].getColor1().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[temp][c][h].getColor2Direction() == null)
				{
					return false;
				}
				else if(cube[temp][c][h].getColor2Direction().equals("backLeft"))
				{
					if(!cube[temp][c][h].getColor2().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[temp][c][h].getColor3Direction() == null)
				{
					return false;
				}
				else if(cube[temp][c][h].getColor3Direction().equals("backLeft"))
				{
					if(!cube[temp][c][h].getColor3().equals(currentColor))
					{
						return false;
					}
				}
      }  
    }
		temp = 2;
		currentColor = cube[temp][1][1].getColor1();
    for(int c = 0; c < 3; c++)
    {
      for(int h = 0; h < 3; h++)
      {
				if(cube[temp][c][h].getColor1Direction().equals("frontLeft"))
				{
					if(!cube[temp][c][h].getColor1().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[temp][c][h].getColor2Direction() == null)
				{
					return false;
				}
				else if(cube[temp][c][h].getColor2Direction().equals("frontLeft"))
				{
					if(!cube[temp][c][h].getColor2().equals(currentColor))
					{
						return false;
					}
				}
				else if(cube[temp][c][h].getColor3Direction() == null)
				{
					return false;
				}
				else if(cube[temp][c][h].getColor3Direction().equals("frontLeft"))
				{
					if(!cube[temp][c][h].getColor3().equals(currentColor))
					{
						return false;
					}
				}
      }  
    }
		return true;
  }
}