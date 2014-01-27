package QC2;

import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ControlScheme;
import jgame.controller.KeyboardLocationController;
import QC2.PlatformController;
import QC2.PlatformControlScheme;

public class Character extends GSprite{
	public Character(){
		super(ImageCache.forClass(QCraft2.class).get("qc2_soiltop.png"));
		
		PlatformController klc = new PlatformController(PlatformControlScheme.WASD, 1, 1, -1);

		addController(klc);
		
		
		
//		KeyboardLocationController klc = new KeyboardLocationController(
//		        ControlScheme.WASD, 10);
//		addController(klc);
		
		
		}

}
