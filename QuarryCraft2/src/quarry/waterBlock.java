package quarry;

import jgame.GSprite;
import jgame.ImageCache;

public class waterBlock extends GSprite implements LiquidGround {
	public waterBlock(){
	
	super(ImageCache.forClass(QCraft2.class).get("tempWater.png"));
	}
}
