package main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Character {
	private boolean k;
	private int x, y;
	protected ArrayList<Integer> pos = new ArrayList<Integer>(2);
	protected BufferedImage image;
	public Character(int width, int height, String charID, Game game, Boolean k) {
		this.k = k;
		pos = new ArrayList<Integer>(2);
		pos.add(20);
		pos.add(20);
		//System.out.println(pos.get(0));
		if(k){
		Keys keys = new Keys(this, charID, game);
		image = keys.image;
		}
	}
	protected void setPos(int slot, int value){
		pos.set(slot, value);
	}
}
