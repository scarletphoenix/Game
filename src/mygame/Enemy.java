package mygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Enemy extends Entity{
	
	private Rectangle box;
	private boolean dead = false;
	private Dodge instance;
	private int ix,iy;
	Color customColor = new Color(200, 200, 200);
	Image im = Toolkit.getDefaultToolkit().createImage("snow.png");
	public Enemy(Dodge instance, int x,int y)
	{
		super(x,y);
		this.instance= instance;
		box=new Rectangle(x,y,24,24);
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
		g.drawImage(im,box.x, box.y, box.width, box.height,null);
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
