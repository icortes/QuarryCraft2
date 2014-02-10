package quarry;

import java.awt.Color;

import jgame.GSprite;
import jgame.ImageCache;

public class BackGroundMain extends GSprite {

	public BackGroundMain() {
		super(ImageCache.forClass(QCraft2.class).get("tempBack.png"));

		
	}
}
