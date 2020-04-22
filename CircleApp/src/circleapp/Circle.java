/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleapp;

/**
 *
 * @author NEDL
 */
public class Circle {
    
    private int centerPointX;
    private int centerPointY;
    private int radiusCircle;
    
    public Circle(){
        
        centerPointX = 0;
        centerPointY = 0;
        radiusCircle = 0;       
    }
    
    public Circle(int newCenterPointX, int newCenterPointY, int newRadiusCircle){
        
        centerPointX = newCenterPointX;
        centerPointY = newCenterPointY;
        radiusCircle = newRadiusCircle;    
    }
    
    
    public String toString(){
        return "The Center of the Circle is "+centerPointX+","+centerPointY+""
                + " and the circle radius is "+radiusCircle+" The area is "
                +circleArea()+" The perimeter is "+circlePerimeter();
        
    }

    public int  getCenterPointX(){
        return centerPointX; 
    }
    public int  getCenterPointY(){
        return centerPointY;
      }
    public int  getRadiusCircle(){
        return radiusCircle;
    }
    public void setCenterPointX(int newCenterPointX){
        centerPointX = newCenterPointX;      
    }
    public void setCenterPointY(int newCenterPointY){
        centerPointY = newCenterPointY;
    }
    public void setRadiusCircle(int newRadiusCircle){
        radiusCircle = newRadiusCircle;
    }
      
    public double circleArea(){
        return Math.PI * (radiusCircle * radiusCircle);
    }
    public double circlePerimeter(){
        return (2 * Math.PI * radiusCircle);
    }
    
    @Override
    public boolean equals(Object o){
        
        if (!(o instanceof Circle))
            return false;
        else
        {
                    Circle objCircle = (Circle) o;
                    if (centerPointX == objCircle.centerPointX
                        && centerPointY == objCircle.centerPointY
                        && radiusCircle == objCircle.radiusCircle){
                               
                        return true;
                } else {
                        return false;
                    }
                }       
        
    }
      
}

