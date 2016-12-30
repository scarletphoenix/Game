package mygame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class Dodge extends JPanel implements KeyListener{
	
	private Player player;
	private Stage stage;
	private EnemyManager manager;
	private boolean isGameOver = false;
	private int score = 0;
	private int level = 8;
	private int threshold= 100;
	private int i=1;
	private boolean gameNotStarted = true;
//	private Immunity immune;
	boolean timeForImmunity = false;
	Random r = new Random();
	Image img = Toolkit.getDefaultToolkit().createImage("i3.jpg");
	
	public Dodge()
	{
		setPreferredSize(new Dimension(1000,600));
		setFocusable(true);
		addKeyListener(this);
		stage = new Stage();
		manager = new EnemyManager(this,level);
		player = new Player(this, 200,200);
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}
/*	public void setTimeForImmunity(boolean flag){
		immune = new Immunity(this,r.nextInt(600),r.nextInt(100));
		timeForImmunity=flag;
		}
	
	public Immunity getImmunity(){
		return immune;
	}*/
	public void paint(Graphics g)
	{
		g.drawRect(0, 0, getWidth(), getHeight());
		g.drawImage(img, 0, 0, getWidth(),getHeight(), null);
		
		while(gameNotStarted){
			g.setColor(Color.black);
			g.setFont(new Font("Century Gothic", Font.BOLD,24));
			g.drawString("Press Enter to start", 300, 200);
			
		}
		
		if(score/1000>threshold*i){
			level+=3;
			manager = new EnemyManager(this,level);
			player.life= 5;	
			i++;
		}
		
		if(!isGameOver){
		
				stage.draw(g);
				player.draw(g);
				manager.draw(g);
				score+=10;
			/*	if(timeForImmunity)
					{
					immune.draw(g);
					}*/
				g.setColor(Color.white);
				g.drawString("SCORE: "+score/1000,600,20);
				g.drawString("LEVEL "+i, 300,20);
				
		}
		else{
			g.setColor(Color.white);
			g.setFont(new Font("Century Gothic", Font.BOLD,24));
			g.drawString("GAME OVER!", 300, 200);
			g.drawString("Your score is "+score/1000,300,300);
			g.drawString("Reached Level:"+i,300,400);
		}
		repaint();
	}

	public Stage getStage()
	{
		return stage;
	}
	
	
	public static void main(String args[])
	{
		Dodge game = new Dodge();
		JFrame frame = new JFrame();
		frame.setTitle("Dodge the Rectangles");
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public EnemyManager getEnemyManager(){ return manager; }

	public void setGameOver(boolean flag){
		isGameOver = flag;
	}
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(c==KeyEvent.VK_LEFT)
		{
				player.setXD(-1);
			
		}
		if(c==KeyEvent.VK_RIGHT)
		{
				player.setXD(1);
		}
	
		if(c==KeyEvent.VK_UP)
			gameNotStarted = false;
	}

	
	public void keyReleased(KeyEvent e) {
		player.setYD(0);
		player.setXD(0);
		gameNotStarted=false;
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}
}
