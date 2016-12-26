package mygame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyManager {
	
	private Dodge instance;
	private int amount;
	private List<Enemy> enemies = new ArrayList<Enemy>(); 
	public EnemyManager(Dodge instance,int a ){
		this.amount= a;
		this.instance=instance;
		spawn();
	}
	
	private void spawn(){
		Random random=new Random();
		int ss= enemies.size();
		if(ss < amount){
			for(int i =0; i < amount-ss;i++){
				enemies.add(new Enemy(instance, random.nextInt(1078),random.nextInt(100)));
			}
		}
		else{
			for(int i = 0; i < ss-amount;i++){
				enemies.remove(i);
			}
		}
	}
	
	public boolean isColliding(Rectangle entity){
		boolean c=false;
		for(int i=0; i<enemies.size();i++){
			if(entity.intersects(enemies.get(i).getRectangle())){
				c=true;
			}
		}
			return c;
		
	}
	
	public void update(){
		boolean re = false;
		for(int i=0;i< enemies.size();i++){
			if(enemies.get(i).isDead()){
				enemies.remove(i);
				re = true;
			}
		}
		if(re) spawn();
	}
	public void draw(Graphics g){
		for(Enemy e: enemies){
			e.draw(g);
		}
		update();
	}
}
