package QC2;

import java.util.List;

import soil.Soil;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ControlScheme;
import jgame.controller.KeyboardLocationController;
import jgame.listener.HitTestListener;
import jgame.listener.ParentBoundsListener;
import QC2.PlatformController;
import QC2.PlatformControlScheme;
import QC2.SolidGround;

public class Character extends GSprite {
	public Character() {
		super(ImageCache.forClass(QCraft2.class).get("qc2_soiltop.png"));

		PlatformController klc = new PlatformController(
				PlatformControlScheme.WASD, -10, -20, 3);
		addController(klc);
		 
		
	}
}
