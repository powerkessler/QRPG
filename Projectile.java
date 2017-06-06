package main;
import java.awt.Image;

public class Projectile {
	protected int[] pos = {0, 0};
	protected Image image;
	public Projectile(int x, int y, String dir, int random, Game game) {
		image = game.getImgloader().createImage("bullet", 25);
		game.projectiles.add(this);
		int dist = 0;
		while (dist < Math.random() * 20 + 1) {
			switch (dir) {
			case "n":
				y -= random;
				break;
			case "s":
				y += random;
				break;
			case "e":
				x += random;
				break;
			case "w":
				x -= random;
				break;
			}
			dist++;
			pos[0] = x;
			pos[1] = y;
			game.getCanvas().repaint();
		}
	}

}
