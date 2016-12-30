package mygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Immunity{
	
	int ix,iy;
	Random r = new Random();
	Rectangle rect ;
	Dodge instance;
	public boolean immunityDead = false;
	public Immunity(Dodge instance,int x, int y){
		this.instance = instance;
		rect = new Rectangle(x,y,32,32);
		
	}
	public boolean isColliding(Rectangle entity){
		boolean c=false;
			if(entity.intersects(rect)){
				c=true;
			}
			return c;
	}
	
	public void draw(Graphics g){
		move();
		if(instance.getStage().isCollided(rect)){
			iy = 0;
			immunityDead = true;
			instance.timeForImmunity = false;
		}
		else iy=1;
		if(!immunityDead)
		{
			g.setColor(Color.MAGENTA);
			g.fillOval(rect.x,rect.y, rect.width, rect.height);
		}
		
	}
	
	
	public void move(){
		rect.y+=iy;
	}
}
