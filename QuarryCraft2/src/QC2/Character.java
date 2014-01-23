package QC2;

import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ControlScheme;
import jgame.controller.KeyboardLocationController;

public class Character extends GSprite{
	public Character(){
		super(ImageCache.forClass(QCraft2.class).get("qc2_soiltop.png"));
		PlatformController klc = new PlatformController;
		addPlatformController(klc);
		}

}
