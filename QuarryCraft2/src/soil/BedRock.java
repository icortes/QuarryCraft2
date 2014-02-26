package soil;

import quarry.QCraft2;
import quarry.SolidGround;
import jgame.GSprite;
import jgame.ImageCache;

public class BedRock extends GSprite implements SolidGround{
	public BedRock() {
		super(ImageCache.forClass(QCraft2.class).get("bedRock.png"));
	}

}
