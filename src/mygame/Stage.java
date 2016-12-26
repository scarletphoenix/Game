package mygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Stage {

	private Rectangle platform = new Rectangle(0, 550, 1100, 100);
	public Stage(){	
	}
	
	public boolean isCollided(Rectangle entity){
		return platform.intersects(entity);
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(platform.x, platform.y, platform.width, platform.height);
	}

}
