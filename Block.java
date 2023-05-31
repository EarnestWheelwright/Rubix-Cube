import java.awt.*;

public class Block
{
  // instance variables
  private String color1;
  private String color1Direction;
  private String color2;
  private String color2Direction;
  private String color3;
  private String color3Direction;
  private int numFaces;

  // constructers
  public Block(String color, String colorDirection)
  {
    color1 = color;
    color1Direction = colorDirection;
    color2 = null;
    color2Direction = null;
    color3 = null;
    color3Direction = null;
    numFaces = 1;
  }

  public Block(String color, String colorDirection, String color2, String color2Direction)
  {
    color1 = color;
    color1Direction = colorDirection;
    this.color2 = color2;
    this.color2Direction = color2Direction;
    this.color3 = null;
    color3Direction = null;
    numFaces = 2;
  }

  public Block(String color, String colorDirection, String color2, String color2Direction, String color3, String color3Direction)
  {
    color1 = color;
    color1Direction = colorDirection;
    this.color2 = color2;
    this.color2Direction = color2Direction;
    this.color3 = color3;
    this.color3Direction = color3Direction;
    numFaces = 3;
  }

  // accessor methods
  // returns all colors of the block
  public String getColors()
  {
    if(color2 == null && color3 == null){
      return color1;
    } else if(color3 == null){
      return color1 + " " + color2;
    } else {
      return color1 + " " + color2 + " " + color3;
    }
  }

	public Color getColor(String color)
	{
		if(color.equals("White")){
      return Color.green;
    } else if(color.equals("Yellow")){
      return Color.yellow;
    } else if(color.equals("Blue")){
      return Color.blue;
    } else if(color.equals("Red")){
      return new Color((float) 1, (float) .53, (float) .12);
    } else if(color.equals("Green")){
      return new Color((float) .95, (float) .95, (float) .95);
    } else if(color.equals("Orange")){
      return Color.red;
    } else {
      return null;
    }
	}
	
  public Color getColor1()
  {
    return getColor(color1);
  }

  public Color getColor2()
  {
    return getColor(color2);
  }

  public Color getColor3()
  {
    return getColor(color3);
  }
  
  public int getNumFaces(){
    return numFaces;
  }

  // returns all possible color directions
  public String getColorDirections()
  {
    if(color2Direction == null && color3Direction == null){
      return color1Direction;
    } else if(color3Direction == null){
      return color1Direction + " " + color2Direction;
    } else {
      return color1Direction + " " + color2Direction + " " + color3Direction;
    }
  }

  public String getColor1Direction(){
    return color1Direction;
  }

  public String getColor2Direction(){
    return color2Direction;
  }

  public String getColor3Direction(){
    return color3Direction;
  }

  // set methods
  public void setColor1Direction(String direction){
    color1Direction = direction;
  }

  public void setColor2Direction(String direction){
    color2Direction = direction;
  }

  public void setColor3Direction(String direction){
    color3Direction = direction;
  }

  public void setColor1(String color){
    color1 = color;
  }

  public void setColor2(String color){
    color2 = color;
  }

  public void setColor3(String color){
    color3 = color;
  }

  // rotate methods for blocks
  // possible directions: frontLeft, frontRight, top, backLeft, backRight, bottom

  // rotate selected row to the left
  public void rotate90Left(){
    if(numFaces >= 1){
      if(color1Direction.equals("frontLeft")){
        color1Direction = "backRight";        
      } else if(color1Direction.equals("frontRight")){
        color1Direction = "frontLeft";
      } else if(color1Direction.equals("top")){
        color1Direction = "top";
      } else if(color1Direction.equals("backLeft")){
        color1Direction = "frontRight";
      } else if(color1Direction.equals("backRight")){
        color1Direction = "backLeft";
      } else {
        color1Direction = "bottom";
      }
      if(numFaces >= 2){
        if(color2Direction.equals("frontLeft")){
          color2Direction = "backRight";        
        } else if(color2Direction.equals("frontRight")){
          color2Direction = "frontLeft";
        } else if(color2Direction.equals("top")){
          color2Direction = "top";
        } else if(color2Direction.equals("backLeft")){
          color2Direction = "frontRight";
        } else if(color2Direction.equals("backRight")){
          color2Direction = "backLeft";
        } else {
          color2Direction = "bottom";
        }
        if(numFaces == 3){
            if(color3Direction.equals("frontLeft")){
            color3Direction = "backRight";        
          } else if(color3Direction.equals("frontRight")){
            color3Direction = "frontLeft";
          } else if(color3Direction.equals("top")){
            color3Direction = "top";
          } else if(color3Direction.equals("backLeft")){
            color3Direction = "frontRight";
          } else if(color3Direction.equals("backRight")){
            color3Direction = "backLeft";
          } else {
            color3Direction = "bottom";
          }
        }
      } 
    } 
  }

// rotates the selected row to the right
  public void rotate90Right(){
    if(numFaces >= 1){
      if(color1Direction.equals("frontLeft")){
        color1Direction = "frontRight";        
      } else if(color1Direction.equals("frontRight")){
        color1Direction = "backLeft";
      } else if(color1Direction.equals("top")){
        color1Direction = "top";
      } else if(color1Direction.equals("backLeft")){
        color1Direction = "backRight";
      } else if(color1Direction.equals("backRight")){
        color1Direction = "frontLeft";
      } else {
        color1Direction = "bottom";
      }
      if(numFaces >= 2){
        if(color2Direction.equals("frontLeft")){
          color2Direction = "frontRight";        
        } else if(color2Direction.equals("frontRight")){
          color2Direction = "backLeft";
        } else if(color2Direction.equals("top")){
          color2Direction = "top";
        } else if(color2Direction.equals("backLeft")){
          color2Direction = "backRight";
        } else if(color2Direction.equals("backRight")){
          color2Direction = "frontLeft";
        } else {
          color2Direction = "bottom";
        }
        if(numFaces == 3){
          if(color3Direction.equals("frontLeft")){
            color3Direction = "frontRight";        
          } else if(color3Direction.equals("frontRight")){
            color3Direction = "backLeft";
          } else if(color3Direction.equals("top")){
            color3Direction = "top";
          } else if(color3Direction.equals("backLeft")){
            color3Direction = "backRight";
          } else if(color3Direction.equals("backRight")){
            color3Direction = "frontLeft";
          } else {
            color3Direction = "bottom";
          }
        }
      } 
    }
  }

  // rotates the selected column left down
  public void  rotate90LeftDown(){
    if(numFaces >= 1){
      if(color1Direction.equals("frontLeft")){
        color1Direction = "frontLeft";        
      } else if(color1Direction.equals("frontRight")){
        color1Direction = "top";
      } else if(color1Direction.equals("top")){
        color1Direction = "backRight";
      } else if(color1Direction.equals("backLeft")){
        color1Direction = "backLeft";
      } else if(color1Direction.equals("backRight")){
        color1Direction = "bottom";
      } else {
        color1Direction = "frontRight";
      }
      if(numFaces >= 2){
        if(color2Direction.equals("frontLeft")){
          color2Direction = "frontLeft";        
        } else if(color2Direction.equals("frontRight")){
          color2Direction = "top";
        } else if(color2Direction.equals("top")){
          color2Direction = "backRight";
        } else if(color2Direction.equals("backLeft")){
          color2Direction = "backLeft";
        } else if(color2Direction.equals("backRight")){
          color2Direction = "bottom";
        } else {
          color2Direction = "frontRight";
        }
        if(numFaces == 3){
          if(color3Direction.equals("frontLeft")){
           color3Direction = "frontLeft";        
          } else if(color3Direction.equals("frontRight")){
            color3Direction = "top";
          } else if(color3Direction.equals("top")){
            color3Direction = "backRight";
          } else if(color3Direction.equals("backLeft")){
            color3Direction = "backLeft";
          } else if(color3Direction.equals("backRight")){
            color3Direction = "bottom";
          } else {
            color3Direction = "frontRight";
          }
        }
      }
    }
  }

  // rotates the selected column left up
  public void rotate90LeftUp(){
    if(numFaces >= 1){
      if(color1Direction.equals("frontLeft")){
        color1Direction = "frontLeft";        
      } else if(color1Direction.equals("frontRight")){
        color1Direction = "bottom";
      } else if(color1Direction.equals("top")){
        color1Direction = "frontRight";
      } else if(color1Direction.equals("backLeft")){
        color1Direction = "backLeft";
      } else if(color1Direction.equals("backRight")){
        color1Direction = "top";
      } else {
        color1Direction = "backRight";
      }
      if(numFaces >= 2){
        if(color2Direction.equals("frontLeft")){
          color2Direction = "frontLeft";        
        } else if(color2Direction.equals("frontRight")){
          color2Direction = "bottom";
        } else if(color2Direction.equals("top")){
          color2Direction = "frontRight";
        } else if(color2Direction.equals("backLeft")){
          color2Direction = "backLeft";
        } else if(color2Direction.equals("backRight")){
          color2Direction = "top";
        } else {
          color2Direction = "backRight";
        }
        if(numFaces == 3){
          if(color3Direction.equals("frontLeft")){
           color3Direction = "frontLeft";        
          } else if(color3Direction.equals("frontRight")){
            color3Direction = "bottom";
          } else if(color3Direction.equals("top")){
            color3Direction = "frontRight";
          } else if(color3Direction.equals("backLeft")){
            color3Direction = "backLeft";
          } else if(color3Direction.equals("backRight")){
            color3Direction = "top";
          } else {
            color3Direction = "backRight";
          }
        }
      }
    }
  }

  // rotates the selected column right up
  public void rotate90RightUp(){
    if(numFaces >= 1){
      if(color1Direction.equals("frontLeft")){
        color1Direction = "top";        
      } else if(color1Direction.equals("frontRight")){
        color1Direction = "frontRight";
      } else if(color1Direction.equals("top")){
        color1Direction = "backLeft";
      } else if(color1Direction.equals("backLeft")){
        color1Direction = "bottom";
      } else if(color1Direction.equals("backRight")){
        color1Direction = "backRight";
      } else {
        color1Direction = "frontLeft";
      }
      if(numFaces >= 2){
        if(color2Direction.equals("frontLeft")){
          color2Direction = "top";        
        } else if(color2Direction.equals("frontRight")){
          color2Direction = "frontRight";
        } else if(color2Direction.equals("top")){
          color2Direction = "backLeft";
        } else if(color2Direction.equals("backLeft")){
          color2Direction = "bottom";
        } else if(color2Direction.equals("backRight")){
          color2Direction = "backRight";
        } else {
          color2Direction = "frontLeft";
        }
        if(numFaces == 3){
          if(color3Direction.equals("frontLeft")){
           color3Direction = "top";        
          } else if(color3Direction.equals("frontRight")){
            color3Direction = "frontRight";
          } else if(color3Direction.equals("top")){
            color3Direction = "backLeft";
          } else if(color3Direction.equals("backLeft")){
            color3Direction = "bottom";
          } else if(color3Direction.equals("backRight")){
            color3Direction = "backRight";
          } else {
            color3Direction = "frontLeft";
          }
        }
      }
    }
  }

  // rotates selected column right down
  public void rotate90RightDown(){
    if(numFaces >= 1){
      if(color1Direction.equals("frontLeft")){
        color1Direction = "bottom";        
      } else if(color1Direction.equals("frontRight")){
        color1Direction = "frontRight";
      } else if(color1Direction.equals("top")){
        color1Direction = "frontLeft";
      } else if(color1Direction.equals("backLeft")){
        color1Direction = "top";
      } else if(color1Direction.equals("backRight")){
        color1Direction = "backRight";
      } else {
        color1Direction = "backLeft";
      }
      if(numFaces >= 2){
        if(color2Direction.equals("frontLeft")){
          color2Direction = "bottom";        
        } else if(color2Direction.equals("frontRight")){
          color2Direction = "frontRight";
        } else if(color2Direction.equals("top")){
          color2Direction = "frontLeft";
        } else if(color2Direction.equals("backLeft")){
          color2Direction = "top";
        } else if(color2Direction.equals("backRight")){
          color2Direction = "backRight";
        } else {
          color2Direction = "backLeft";
        }
        if(numFaces == 3){
          if(color3Direction.equals("frontLeft")){
           color3Direction = "bottom";        
          } else if(color3Direction.equals("frontRight")){
            color3Direction = "frontRight";
          } else if(color3Direction.equals("top")){
            color3Direction = "frontLeft";
          } else if(color3Direction.equals("backLeft")){
            color3Direction = "top";
          } else if(color3Direction.equals("backRight")){
            color3Direction = "backRight";
          } else {
            color3Direction = "backLeft";
          }
        }
      }
    }
  }
}