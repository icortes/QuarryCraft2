package quarry;

import java.util.List;
import quarry.Character;
import quarry.QCraft2.View;
import soil.SoilBlock1;
import soil.SoilBlock2;
import soil.TopSoil1;
import soil.TopSoil2;
import soil.BedRock;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ParentBoundsListener;

public class GameLevel extends GContainer {
	public GameLevel() {
		setSize(1000, 600);
		GSprite bg1 = ImageCache.getSprite("tempBack.png");
		bg1.setAnchorCenter();
		addAtCenter(bg1);

		BedRock unbreakable = new BedRock();
		add(unbreakable);
		unbreakable.setLocation(500, 600);

		NextSlide next = new NextSlide();
		add(next);
		next.setLocation(995, 300);

		for (int horizontal = 1025; horizontal >= 0; horizontal -= 50) {
			int blockPickTop = (int) (Math.random() * 3);
			GObject t = null;
			switch (blockPickTop) {
			case 0:
				t = new TopSoil1();
				break;

			case 1:
				t = new TopSoil2();
				break;
			case 2:
				t = new WaterBlock();
				break;

			}

			addAt(t, horizontal, 325);

		}
		for (int vertical = 375; vertical <= 600; vertical += 50) {
			for (int horizontal = 1025; horizontal >= 0; horizontal -= 50) {
				int blockPick = (int) (Math.random() * 2);
				GObject e = null;
				switch (blockPick) {
				case 0:
					e = new SoilBlock1();
					break;

				case 1:
					e = new SoilBlock2();
					break;

				}

				addAt(e, horizontal, vertical);

			}

		}
		Character hero = new Character();
		add(hero);
		hero.setLocation(500, 200);

	}
}