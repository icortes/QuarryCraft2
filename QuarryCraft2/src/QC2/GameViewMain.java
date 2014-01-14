package QC2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import QC2.QCraft2.View;
import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class GameViewMain extends GContainer {
	public GameViewMain() {
		setSize(1000, 600);
		this.setBackgroundColor(Color.PINK);
		GSprite bg1 = ImageCache.getSprite("qc2_bg1.png");
		bg1.setAnchorCenter();
		addAtCenter(bg1);

		GButton play = new GButton();
		GSprite buttonImageOne = new GSprite(ImageCache.forClass(QCraft2.class)
				.get("qc2_soilrocks1.png"));
		GSprite hoveredImageOne = new GSprite(ImageCache
				.forClass(QCraft2.class).get("qc2_soilrocks2.png"));
		GSprite pressedImageOne = new GSprite(ImageCache
				.forClass(QCraft2.class).get("qc2_soiltop.png"));
		play.setStateSprite(ButtonState.NONE, buttonImageOne);
		play.setStateSprite(ButtonState.HOVERED, hoveredImageOne);
		play.setStateSprite(ButtonState.PRESSED, pressedImageOne);
		addAt(play, 1000 / 2, (600 / 2));

		ButtonListener playNow = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {

				context.setCurrentGameView(View.GAME);
			}
		};
		play.addListener(playNow);
	}

}
