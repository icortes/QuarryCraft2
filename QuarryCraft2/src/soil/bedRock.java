package soil;

import quarry.QCraft2;
import quarry.SolidGround;
import jgame.GSprite;
import jgame.ImageCache;

public class bedRock extends GSprite implements SolidGround{
	public bedRock() {
		super(ImageCache.forClass(QCraft2.class).get("bedRock.png"));
	}

}
