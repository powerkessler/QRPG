package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;

public class Draw extends Canvas implements Runnable {

	private JFrame frame;
	private final static int WIDTH = 1000, HEIGHT = 1500;
	private final static int SCALE = 1;
	private final static Dimension dimens = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	private final static int DISX = 0, DISY = 0;
	private final static Dimension dis = new Dimension(DISX, DISY);
	private final static Rectangle rectangle = new Rectangle(DISX, DISY, WIDTH, HEIGHT);
	private BufferedImage image;
	private Graphics g;
	private long nanoSecond = 1000000000;
	private double tick = nanoSecond / 60;
	private boolean running = false;
	private int pixelsFromImage[];
	private int pixel[][];
	private Game game;
	private static DateFormat dateFormat = new SimpleDateFormat("[" + "yyyy/MM/dd HH:mm:ss" + "]");
	private static DateFormat dateFormat2 = new SimpleDateFormat("[" + "HH:mm:ss" + "]");
	
	
	public Draw(Game game) {
		this.game = game;
		frame = new JFrame("Score");
		frame.setBounds(rectangle);
		frame.setMinimumSize(dimens);
		frame.setMaximumSize(dimens);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.add(this);
		init();
		//draw(string + combatoid.getScore());
	}

	public void init() {
		long startTime = System.nanoTime();
		Calendar cal = Calendar.getInstance();
		System.out.println("START: " + dateFormat.format(cal.getTime()));
		start();
	}

	public void run() {
		long now = System.nanoTime();
		long lastTick = System.nanoTime();
		long lastSecond = System.nanoTime();
		int frames = 0;

		while (running) {
			now = System.nanoTime();
			Calendar cal = Calendar.getInstance();

			if (now - lastTick >= tick) {
				lastTick = now;
				tick();
				render();
				frames++;
			}
			if (now - lastSecond >= nanoSecond) {
				lastSecond = now;
				System.out.println(dateFormat2.format(cal.getTime()) + "FPS: " + frames);
				frames = 0;
			}
		}
	}

	public void tick() {
		// updates values
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 1500);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Verdana", Font.PLAIN, 40));
		g.drawString("Running", 20, 50);
		for (Character c : game.characters) {
			g.drawImage(c.image, c.pos.get(0), c.pos.get(1), null);
			System.out.println("Cha drawn");
		}
		for (Projectile p : game.projectiles) {
			g.drawImage(p.image, p.pos[0], p.pos[1], null);
		}
		g.dispose();
		bs.show();
		// renders graphics
	}

	public synchronized void start() {
		running = true;
		run();
	}

	public synchronized void stop() {
		running = false;
	}
}

	/*public void repaint() {

		Graphics g = game.getG();
		g.setColor(Color.RED);
		g.fillRect(0, 0, width, height);
		for (Character c : game.characters) {
			g.drawImage(c.image, c.pos.get(0), c.pos.get(1), null);
		}
		for (Projectile p : game.projectiles) {
			g.drawImage(p.image, p.pos[0], p.pos[1], null);
		}
	}*/
