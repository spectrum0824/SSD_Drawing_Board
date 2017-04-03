package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class CompositeGObject extends GObject {

	private List<GObject> gObjects;

	public CompositeGObject() {
		super(0, 0, 0, 0);
		gObjects = new ArrayList<GObject>();
	}

	public void add(GObject gObject) {
		gObjects.add(gObject);
	}

	public void remove(GObject gObject) {
		// TODO: Implement this method.
		gObjects.remove(gObject);
	}

	@Override
	public void move(int dX, int dY) {
		// TODO: Implement this method.
		int diffX = dX - this.x;
		int diffY = dY - this.y;
		for(GObject go : gObjects){
			go.move(go.x+diffX, go.y+diffY);
		}
		this.x = dX;
		this.y = dY;
	}
	
	public void recalculateRegion() {
		// TODO: Implement this method.
		int newX = 1000, newY = 1000, newW = 0, newH = 0;
		for(GObject go : gObjects){
			if(go.x < newX) newX = go.x;
			if(go.y < newY) newY = go.y;
			if(go.x + go.width > newW) 	newW = go.x + go.width;
			if(go.y + go.height > newH)	newH = go.y + go.height;
		}
		this.x = newX;
		this.y = newY;
		this.width = newW - newX;
		this.height = newH - newY;

	}

	@Override
	public void paintObject(Graphics g) {
		// TODO: Implement this method.
		for(GObject go : gObjects){
			go.paintObject(g);
		}
		
	}

	@Override
	public void paintLabel(Graphics g) {
		// TODO: Implement this method.
		g.drawString("NewObject", x, y+height+15);
	}
	
}
