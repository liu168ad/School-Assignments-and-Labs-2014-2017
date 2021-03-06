import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
///////////////////BELOW ARE THE METHODS FROM LECTURE AND LABS. KEEP SCROLLING TO FIND MY ASSIGNMENT METHODS/////////////////
  
  public void decreaseRed()
  {
    Pixel [] pixelArray = this.getPixels();
    Pixel pixelObj = null;
    int index = 0;
    int value = 0;
    
    //loop through all the pixels
    while(index<pixelArray.length)
    {
      pixelObj=pixelArray[index];      //get the current pixel   
      value = pixelObj.getRed();       //get the red value
      value = (int) (value * 0.5);     //decrease the red value
      pixelObj.setRed(value);          //set the pixel's red value  
      index++;                         //increment the index
    }
  }  
  
  
    public void changeRed(double howMuch)
    {
      Pixel [] pixelArray = this.getPixels();
      Pixel pixelObj = null;
      int index = 0;
      int value = 0;
      
      for(int index2 = 1; index2 <pixelArray.length ; index2 ++)
      {
       
        pixelObj=pixelArray[index];         //get the current pixel 
        value = pixelObj.getRed();          //get the red value
        value = (int) (value * howMuch);    //decrease the red value
        pixelObj.setRed(value);             //set the pixel's red value
        index++;                            //increment the index
      }
    }
  
  
  public void clearBlue2()
  {
    Pixel pixelObj;
    
    for (int x=0; x<this.getWidth(); x++)     //loop through the columns (x direction)
    {
      for (int y=0; y< this.getHeight(); y++) //loop through the rows (y direction)
      {
        pixelObj = this.getPixel(x,y);        //get pixel at the x and y location
        pixelObj.setBlue(0);                  //set its blue to 0 
      }//end of inner loop
    }//end of outer loop
  }
  
  
  public void mirrorVertical()
  {
    int mirrorPoint = this.getWidth()/2;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    for (int y=0; y<this.getHeight(); y++) //loop through the rows
    {
      for (int x=0; x< mirrorPoint; x++)   //loop from column 0 to just before the mirror point
      {
        leftPixel= this.getPixel(x,y);
        rightPixel = this.getPixel(this.getWidth()-1-x, y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  
  public void mirrorVerticalRightToLeft()
  {
    int mirrorPoint = this.getWidth()/2;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
   
    for (int y=0; y<this.getHeight(); y++)    //loop through the rows
    {
      for (int x=0; x< mirrorPoint; x++)      //loop from column 0 to just before the mirror point
      {
        leftPixel= this.getPixel(x,y);
        rightPixel = this.getPixel(this.getWidth()-1-x, y);
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }
  
  //method to grayscale (black, gray and white) using the luminance technique (percieve blue to be darker than red and green)
  public void grayscaleWithLuminance()
  {
    Pixel pixelObj = null;
    int intensity = 0;
    
    // loop through all the pixels
    for (int y = 0; y < this.getHeight(); y++)
    {
      for (int x = 0; x < this.getWidth(); x++)
      {
        pixelObj = this.getPixel(x, y);                                  // get the current pixel
        intensity = (int) (pixelObj.getRed() * 0.299 + pixelObj.getGreen() * 0.587 + pixelObj.getBlue() * 0.114); //sets the value fo the variable intensity. Makes the colours more gray
        pixelObj.setColor(new Color(intensity,intensity,intensity));     // set the pixel color
      }
    }
  }
    
  
  /////////////////For assignment 2 (above methods are from labs and stuff)/////////////////
 
   //method for copying the source picture to aa target picture. Source picture is passed as a parameter and target invokes object
  public void copyPictureTo(Picture sourcePicture, int xStart, int yStart)
  {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //loop through the columns
    for (int sourceX = 0, targetX = xStart; sourceX < sourcePicture.getWidth(); sourceX++, targetX++)
    {
      //loop through the rows
      for (int sourceY = 0, targetY = yStart; sourceY < sourcePicture.getHeight(); sourceY++, targetY++)
      {
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY); //gets pixel from source image
        targetPixel = this.getPixel(targetX,targetY);          //gets pixel from target picture
        targetPixel.setColor(sourcePixel.getColor());          //sets the colour of the pixel in the target to match the colour of the pixel from the source
      } 
    }
  } 
  
  
  //increase purple method
  public void increasePurple()
  {
    Pixel pixelObj = null;
    
    //loop through all the pixels
    for (int x = 0 ; x < this.getWidth() ; x++)
    {
      for (int y = 0 ; y < this.getHeight() ; y++)
      {
        int redValue, blueValue = 0; //declares the variables redValue and blueValue which will be used to store and then alter the red and blue values of the picture
   
        pixelObj = this.getPixel(x,y);      //get the current pixel from the source image   
      
        redValue = pixelObj.getRed();       //get the red value and blue value of the pixel
        blueValue = pixelObj.getBlue();
      
        redValue = (int) (redValue * 1.5);     //increase the red value and the blue
        blueValue = (int) (blueValue * 1.5);
      
        pixelObj.setRed(redValue);          //set the pixel's red and blue values  
        pixelObj.setBlue(blueValue); 
      }
    }
  }
  
  
  //mirror Four square method
  
  //mirrors the picture in a wacky 4 square pattern and places it in
  public void mirrorFourSquare()
  {
    int mirrorPoint = this.getWidth()/2;
    Pixel leftPixel, rightPixel = null;
    
    //mirrors the top left part of the image onto the bottom right 
    for (int y=0; y<this.getHeight()/2; y++) //loop through the rows until it reaches the middle of the picture
    {
      for (int x=0; x< mirrorPoint; x++)   //loop from column 0 to just before the mirror point
      {
        leftPixel= this.getPixel(x,y);
        rightPixel = this.getPixel(this.getWidth()-1-x, this.getHeight()/2 + y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
   //copies the top right part of the image to the bottom left and mirros the top right part on itself
    for (int y= 0 ; y<this.getHeight()/2; y++)
    {
      for (int x=0; x< mirrorPoint; x++)
      {
        leftPixel= this.getPixel(x,this.getHeight()/2  + y);
        rightPixel = this.getPixel(mirrorPoint -1 +x, y);
        leftPixel.setColor(rightPixel.getColor());
      }
    }
    
    for (int y=0; y<this.getHeight()/2; y++) //loop through the rows until it reaches the middle of the picture
    {
      for (int x=0; x< mirrorPoint; x++)   //loop from column 0 to just before the mirror point
      {
        rightPixel= this.getPixel(this.getWidth()-1-x,y);
        leftPixel = this.getPixel(x, this.getHeight()/2 + y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
 
  
  // 2 by 2 checkered invert method
  public void twoByTwoCheckeredInvert()
  {
    Pixel pixelObj = null;
    int redValue,blueValue,greenValue = 0;
    
    for (int y=0 ; y< this.getHeight()/2; y++)                        //nested for loops to negate the top left part of the picture
      {
      for(int x=0; x< this.getWidth()/2; x++)
      {
        pixelObj = this.getPixel(x,y);                                //get the current pixel from the source image   
      
        redValue = pixelObj.getRed();                                 //gives values to the variables by getting the colours from the pixel
        greenValue = pixelObj.getGreen();
        blueValue = pixelObj.getBlue();
      
        pixelObj.setColor(new Color(255-redValue,255-greenValue,255-blueValue)); //Negates the pixel's original color
      }
      
      for (int x= this.getWidth()/2 ; x< this.getWidth(); x++)        //nested for loops to negate the bottom right part of the picture
      {
        pixelObj = this.getPixel(x, this.getHeight()/2 + y);          //get the current pixel from the source image   
      
        redValue = pixelObj.getRed();
        greenValue = pixelObj.getGreen();
        blueValue = pixelObj.getBlue();
        
        pixelObj.setColor(new Color(255-redValue,255-greenValue,255-blueValue));   //Negates the pixel's original color
      }
    }
  }
  
  
  //stripes of sepia and gray method
  public void stripesOfSepiaAndGray()
  {
    Pixel pixelObj = null;
    int redValue, blueValue, greenValue = 0;
    
    int xIncrement = (int) (this.getWidth()/10);
    
    this.grayscaleWithLuminance(); //changes the current picture to grayscale
    
    //loops through the pixels and creates the striped pattern
    for (int y = 0; y <this.getHeight(); y++)
    {
      for (int x = 0; x < this.getWidth()- xIncrement; x= x + 2* xIncrement)
      {
        for (int i = 0; i<xIncrement; i++)
        {
          pixelObj = this.getPixel(x+i,y); //gets the current pixel
      
          redValue = pixelObj.getRed();
          greenValue = pixelObj.getGreen();
          blueValue = pixelObj.getBlue();
      
          if (redValue < 60) //tint the shadow darker
          {
            //changes the value of the variables redValue, greenValue and blueValue
            redValue = (int) (redValue*0.8);
            greenValue = (int) (greenValue*0.6); 
            blueValue = (int) (blueValue*0.6);
          }
          else if(redValue >190) //tint the midtones a light brown by reducing the blue
          {
            blueValue = (int) (blueValue*0.6);
          }
          else // tint the highlights a light yellow by reducing the blue
          {
            blueValue = (int) (blueValue*0.6);
          }

          //sets the new colour for the pixel
          pixelObj.setRed(redValue);
          pixelObj.setBlue(blueValue);
          pixelObj.setGreen(greenValue);
        }
      }
    }
  }
  
  
  //overlay transparent reddish border of width 20 and horizontally mirror image method
  public void overlayRedBorderAndHorizMirror()
  {
    Pixel topPixel, bottomPixel = null;    //creates two pixels objects used to get the top pixel and mirror it to the botoom pixel.
                                          // these variables are reused to create the borders by increase the red values of the pixels around the edges
    //mirrors image horizontally
    for(int y = 0; y< this.getHeight()/2; y++)//loops through the rows
    {
      for(int x = 0; x< this.getWidth(); x++)//loops through the columns
      {
        topPixel= this.getPixel(x,y);                             //gets the pixel
        bottomPixel = this.getPixel(x, this.getHeight()-1-y);    //
        bottomPixel.setColor(topPixel.getColor());               //
      }
    }
    
    //paints a border over the image by changing the pixels around the edge to max red
    for(int y = 0; y<20; y++)              //nested loops to create the top and bottom part of the border
    {
      for(int x = 0; x< this.getWidth(); x++)
      {
        topPixel = this.getPixel(x,y);
        bottomPixel = this.getPixel(x, this.getHeight()-1-y);
        topPixel.setRed(255);
        bottomPixel.setRed(255);
      }
    }
    for(int y = 0; y< this.getHeight(); y++)                      //nested loops to create the side parts of the border
    {
      for(int x = 0; x<20; x++)
      {
        topPixel = this.getPixel(x,y);                          //
        bottomPixel = this.getPixel(this.getWidth()-1-x,y);     //
        topPixel.setRed(255);
        bottomPixel.setRed(255);
      }
    }
  }
  
   
  //make white more red method and make shadows green
  public void makeWhiteMoreRedAndShadowsGreen()
  {
    for (int x = 0; x < this.getWidth(); x++) {                         //nested loops to get all the pixels
      for (int y = 0; y < this.getHeight(); y++) {
        Pixel pixelObj = this.getPixel(x,y);                              //gets the pixel
        int redValue = pixelObj.getRed();
        int greenValue = pixelObj.getGreen();
        int blueValue = pixelObj.getBlue();
        if (redValue >= 200 && greenValue >= 200 && blueValue >= 200)    //tints the white to be more red (if the value is light)
        {
          pixelObj.setRed(255);
          pixelObj.setGreen(200);
          pixelObj.setBlue(200);
        }
        if (redValue<60)                                  //tints the shadows green (if the value is dark increase green)
        {
          pixelObj.setRed((int) (redValue*0.4));
          pixelObj.setBlue((int) (blueValue*0.4));
        }
      }
    }
  } 
  ///////////////////////////////////////////////////////////////
  
  public int countWhitePixels()
  {
    Pixel pixelObj;
    int counter = 0;
    //loop through the columns (x direction)
    for (int x = 0; x< this.getWidth(); x++)
    {
      //loop through the rows (y direction)
      for(int y= 0 ; y<this.getHeight();y++)
      {
        //get the pixel at the x and y location
        pixelObj = this.getPixel(x,y);
        
        if (pixelObj.getRed()==255 && pixelObj.getGreen()==255 && pixelObj.getBlue()==255)
        {
          counter = counter+1;
        }
        
      }
    }
    return counter;
  }
  
  
    public int countNonWhitePixels()
  {
    Pixel pixelObj;
    int counter = 0;
    //loop through the columns (x direction)
    for (int x = 0; x< this.getWidth(); x++)
    {
      //loop through the rows (y direction)
      for(int y= 0 ; y<this.getHeight();y++)
      {
        //get the pixel at the x and y location
        pixelObj = this.getPixel(x,y);
        
        if (pixelObj.getRed()!=255 && pixelObj.getGreen()!=255 && pixelObj.getBlue()!=255)
        {
          counter = counter+1;
        }
        
      }
    }
    return counter;
  }
  
  public int countNonWhitePixels2()
  {
    int numPixels = this.getHeight() * this.getWidth(); // gets total number of pixels
    int numNotWhite = numPixels - this.countWhitePixels();
      return numNotWhite;
  }
    

  public boolean equalPictureSize (Picture otherPicture)
  {
    int pic1Width = this.getWidth();
    int pic1Height = this.getHeight();
    int pic2Width = otherPicture.getWidth();
    int pic2Height = otherPicture.getHeight();
  
    return (pic1Width == pic2Width && pic1Height == pic2Height);
  }
  
  
  public void copyLeftHalf(Picture sourcePicture, int xStart, int yStart)
  {
   Pixel sourcePixel = null;
   Pixel targetPixel = null;
    
    //loop through the columns
    for (int sourceX = 0, targetX = xStart; sourceX < sourcePicture.getWidth()/2; sourceX++, targetX++)
    {
      //loop through the rows
      for (int sourceY = 0, targetY = yStart; sourceY < sourcePicture.getHeight(); sourceY++, targetY++)
      {
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY); //gets pixel from source image
        targetPixel = this.getPixel(targetX,targetY);          //gets pixel from target picture
        targetPixel.setColor(sourcePixel.getColor());          //sets the colour of the pixel in the target to match the colour of the pixel from the source
      } 
    }
  }
  
  
  public Picture copyLeftHalf()
  {
    int sourcePicWidth = this.getWidth()/2;
    int sourcePicHeight =this.getHeight();
    Picture targetPicture = new Picture(sourcePicWidth, sourcePicHeight);
    
    return targetPicture;
  }
  
  
} // end of class Picture, put all new methods before this
 