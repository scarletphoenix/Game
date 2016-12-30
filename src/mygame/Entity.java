package mygame;

import java.awt.Graphics;

public abstract class Entity {

	protected int x,y,w,h;
	protected boolean removed = false;
	
	public Entity(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
