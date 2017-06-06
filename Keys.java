package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Keys implements KeyListener {
	private Game game;
	private int x, y, size, speed;
	private String charId, dir;
	private Character character;
	protected BufferedImage image;

	public Keys(Character character, String charId, Game game) {
		character = this.character;
		this.game = game;
		this.charId = charId;
		game.getCanvas().addKeyListener(this);
		size = (int) Math.max((Math.random() * 25 + 1), 10);
		x = (int) (Math.random() * game.getWidth() + 1);
		y = (int) (Math.random() * game.getHeight() + 1);
		image = game.getImgloader().createImage("character", size);
	}

	private void update() {
		character.setPos(0, x);
		character.setPos(1, y);
		//System.out.println(character.pos.get(0) + ", " + character.pos.get(1));
		game.getCanvas().repaint();
	}

	private void callInventory(String id) {
		game.getCanvas().repaint();
	}

	private void shoot() {
		Projectile p = new Projectile(x, y, dir, (int) Math.random() * 3 + 1, game);
		game.getCanvas().repaint();
	}

	public String getId() {
		return charId;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KEYPRESSED");
		// TODO Auto-generated method stub
		boolean inBounds = true;
		if (inBounds) {
			String echar = e.getKeyChar() + "";
			switch (echar.toLowerCase()) {
			case "w":
				y -= size;
				dir = "n";
				break;
			case "a":
				x -= size;
				dir = "w";
				break;
			case "s":
				y += size;
				dir = "s";
				break;
			case "d":
				x += size;
				dir = "e";
				break;
			case "e":
				callInventory(charId);
				break;
			case " ":
				shoot();
				break;
			}
		}
		update();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
