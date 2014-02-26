package quarry;

import jgame.GSprite;
import jgame.ImageCache;

public class WaterBlock extends GSprite implements LiquidGround {
	public WaterBlock(){
	
	super(ImageCache.forClass(QCraft2.class).get("tempWater.png"));
	}
}
