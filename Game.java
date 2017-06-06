package main;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends JFrame {
	private Graphics g;
	private BufferStrategy bs;
	private Draw canvas;
	public ArrayList<Character> characters;
	public ArrayList<Projectile> projectiles;
	private Images imgloader;

	public Game(int width, int height) {
		characters = new ArrayList<Character>();
		projectiles = new ArrayList<Projectile>();
		imgloader = new Images();
		canvas = new Draw(this);
		add(canvas);
		Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int) (sc.getWidth() / 2) -(width/2), (int) (sc.getHeight() / 2) -(height/2), width, height);
		this.setVisible(true);
		this.setUndecorated(true);
		bs = canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
		Character c0 = new Character(32, 32, "Ken", this, true);
		characters.add(c0);
		this.setTitle("StarJumper Gamma");
	}

	public static void main(String[] args0) {
		int width = 1000;
		int height = 1500;
		Game game = new Game(width, height);
	}

	public Graphics getG() {
		return g;
	}

	public BufferStrategy getBS() {
		return bs;
	}

	public Canvas getCanvas() {
		// TODO Auto-generated method stub
		return canvas;
	}
	public ArrayList getCharacters(){
		return characters;
	}

	public Images getImgloader() {
		return imgloader;
	}
}
