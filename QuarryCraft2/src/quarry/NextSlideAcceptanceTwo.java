package quarry;

import java.util.List;

import quarry.GameViewAndEnemies;
import quarry.QCraft2.View;
import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class NextSlideAcceptanceTwo extends GContainer {
	public NextSlideAcceptanceTwo() {

		setSize(1000, 600);
		GSprite bg1 = ImageCache.getSprite("next.png");
		bg1.setAnchorCenter();
		addAtCenter(bg1);

		GButton play = new GButton();
		GSprite buttonImageOne = new GSprite(ImageCache.forClass(QCraft2.class)
				.get("Accept.png"));
		GSprite hoveredImageOne = new GSprite(ImageCache
				.forClass(QCraft2.class).get("Accept.png"));
		GSprite pressedImageOne = new GSprite(ImageCache
				.forClass(QCraft2.class).get("Accept.png"));
		play.setStateSprite(ButtonState.NONE, buttonImageOne);
		play.setStateSprite(ButtonState.HOVERED, hoveredImageOne);
		play.setStateSprite(ButtonState.PRESSED, pressedImageOne);
		addAt(play, 400, (200));

		ButtonListener playNow = new ButtonListener() {
			public void mouseClicked(Context context) {

				context.setCurrentGameView(View.GAMEANDENEMIES);
				GameViewAndEnemies.newTerrain = 3;
			}
		};
		play.addListener(playNow);

		GButton playy = new GButton();
		GSprite buttonImageOnee = new GSprite(ImageCache
				.forClass(QCraft2.class).get("Decline.png"));
		GSprite hoveredImageOnee = new GSprite(ImageCache.forClass(
				QCraft2.class).get("Decline.png"));
		GSprite pressedImageOnee = new GSprite(ImageCache.forClass(
				QCraft2.class).get("Decline.png"));
		playy.setStateSprite(ButtonState.NONE, buttonImageOnee);
		playy.setStateSprite(ButtonState.HOVERED, hoveredImageOnee);
		playy.setStateSprite(ButtonState.PRESSED, pressedImageOnee);
		addAt(playy, (400), 400);

		ButtonListener playyNoww = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {

				context.setCurrentGameView(View.GAMEANDENEMIES);
			}
		};
		playy.addListener(playyNoww);

	}
}
