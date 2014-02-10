package soil;

import jgame.listener.LocalClickListener;
import QC2.SolidGround;

import java.awt.Image;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;

public class Soil extends GSprite implements SolidGround {
	public Soil(Image image) {
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
