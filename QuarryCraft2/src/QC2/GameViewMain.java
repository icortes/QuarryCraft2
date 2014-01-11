package QC2;

import java.awt.Color;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class GameViewMain extends GContainer {
	public GameViewMain() {
		setSize(1400, 600);
		this.setBackgroundColor(Color.PINK);
		 GSprite bg1 = ImageCache.getSprite("qc2_bg1.png");
		 bg1.setAnchorCenter(); 
		 addAtCenter(bg1);
	}

}
