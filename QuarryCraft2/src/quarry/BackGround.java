package quarry;

import jgame.GSprite;
import jgame.ImageCache;

public class BackGround extends GSprite {

	public BackGround() {
		super(ImageCache.forClass(QCraft2.class).get("tempBack.png"));
	}
}