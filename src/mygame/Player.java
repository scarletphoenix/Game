
package mygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player extends Entity {

	private int xd,yd;
	private Dodge instance;
	private Rectangle box;
	int life = 5;
	Color customColor = new Color(255,100,215);
//	Image img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Rashmi\\Downloads\\Wallpapers\\snow.jfif");

	
	
	public Player(Dodge instance,int x, int y) {
		super(x, y);
		w=32; h=32;
		this.instance=instance;
		box= new Rectangle(x,y,w,h);
	}
	
	@Override
	public void draw(Graphics g)
	{
		move();
		g.setColor(customColor);
		g.fillOval(box.x, box.y, box.width, box.height);
		g.setColor(Color.white);
		g.drawString("Life/Lives:"+life, 20, 20);
		
	}

	
	private void move(){
		if(!instance.getStage().isCollided(box)){
			yd=1;
		}else yd=0;
		if(box.x+xd<=0)
			box.x=0;
		else if(box.x+xd>=800)
			box.x=800;
		else{box.x+=xd;}
		box.y+=yd;
		

		if(instance.getEnemyManager().isColliding(box)){
		
			if(life > 0)
				{
				life--;
				box.x=800/2 - w/2;
				box.y=350;
				}
			else{
				instance.setGameOver(true);
			}
		}
		
	}

	public void setXD(int value)
	{
		xd=value;
	}
	
	public void setYD(int value)
	{
		yd=value;
	}
}
