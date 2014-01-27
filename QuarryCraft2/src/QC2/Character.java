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
import QC2.PlatformController;
import QC2.PlatformControlScheme;

public class Character extends GSprite{
	public Character(){
		super(ImageCache.forClass(QCraft2.class).get("qc2_soiltop.png"));
		
		PlatformController klc = new PlatformController(PlatformControlScheme.WASD, 1, 1, -1);

		addController(klc);
		
		
		HitTestListener htl = new HitTestListener(Soil.class) {

			@Override
			public void invoke(GObject target, Context context) {
				List<Soil> ground = context.hitTestClass(Soil.class);
				for(Soil e : ground)
					e.setonSolidGround(true);
			
 
			}
		};
		addListener(htl);
		
		
		
//		HitTestListener htl = new HitTestListener(Enemy.class) {
//
//			@Override
//			public void invoke(GObject target, Context context) {
//				List<Enemy> enemies = context.hitTestClass(Enemy.class);
//				for(Enemy e : enemies)
//					e.setCurrentHealth(e.getCurrentHealth() - bd);
//            target.removeSelf();
// 
//			}
//		};
//		addListener(htl);
		
		
		
//		KeyboardLocationController klc = new KeyboardLocationController(
//		        ControlScheme.WASD, 10);
//		addController(klc);
		
		
		}

}
