package mygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends Entity{
	
	private Rectangle box;
	private boolean dead = false;
	private Dodge instance;
	private int ix,iy;
	Color customColor = new Color(200, 200, 200);
	
	public Enemy(Dodge instance, int x,int y)
	{
		super(x,y);
		this.instance= instance;
		box=new Rectangle(x,y,32,32);
		ix=0;
		iy=1;
	}

	public void draw(Graphics g)
	{
		move();
		if(instance.getStage().isCollided(box))
		{
			iy=0;
			dead=true;
		}
		
		g.setColor(customColor);
		g.fillRect(box.x, box.y, box.width, box.height);
	}
	
	public boolean isDead(){
		return dead;
	}
	
	public Rectangle getRectangle(){
		return box; }
	
	public void move()
	{
		
		box.y+=iy;
	}
}
