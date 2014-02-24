package quarry;
import java.util.List;
import quarry.Character;
import quarry.QCraft2.View;
import soil.SoilBlock1;
import soil.SoilBlock2;
import soil.TopSoil1;
import soil.TopSoil2;
import soil.bedRock;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ParentBoundsListener;

public class GameView extends GContainer {
	public GameView() {
		setSize(1000, 600);
		GSprite bg1 = ImageCache.getSprite("tempBack.png");
		bg1.setAnchorCenter();
		addAtCenter(bg1);

		bedRock unbreakable = new bedRock();
		add(unbreakable);
		unbreakable.setLocation(500, 600);
		
		NextSlide next = new NextSlide();
		add(next);
		next.setLocation(995, 300);

		ParentBoundsListener PBL = new ParentBoundsListener(){
		@Override
		public void invoke(GObject target, Context context) {
			List<Character> enemies = context.hitTestClass(Character.class);
			for (Character e : enemies)
				context.setCurrentGameView(View.GAMEANDENEMIES);
		}
	};
	addListener(PBL);

		for (int z = 1025; z >= 0; z -= 50) {
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
				t = new waterBlock();
				break;

			}

			addAt(t, z, 325);

		}
		for (int l = 375; l <= 600; l += 50) {
			for (int i = 1025; i >= 0; i -= 50) {
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

				addAt(e, i, l);

			}

		}
		Character hero = new Character();
		add(hero);
		hero.setLocation(500, 200);

	}
}