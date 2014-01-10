package QC2;

import jgame.GSprite;
import jgame.ImageCache;

public class BackGroundMain extends GSprite {

	public BackGroundMain() {
		super(ImageCache.forClass(QCraft2.class).get("temp.temp"));

	}
}
