package soil;

import jgame.listener.LocalClickListener;

import java.awt.Image;

import quarry.SolidGround;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;

public class Land extends GSprite implements SolidGround {
	public Land(Image image) {
		super(image);
		
		LocalClickListener gcl = new LocalClickListener(){

			@Override
			public void invoke(GObject target, Context context) {
				target.removeSelf();
			}
			 
		 };
			addListener(gcl);

	}

}
