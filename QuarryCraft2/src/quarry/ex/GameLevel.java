package quarry.ex;

import java.util.List;

import quarry.Character;
import quarry.LiquidGround;
import quarry.NextSlideTwo;
import quarry.SolidGround;
import quarry.WaterBlock;
import soil.BedRock;
import soil.SoilBlock1;
import soil.SoilBlock2;
import soil.TopSoil1;
import soil.TopSoil2;
import enemy.Enemies;
import enemy.EnemyOne;
import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.TimerListener;

/**
 * The current game level in the QC2 game. This can be configured with variable
 * enemy times with {@link #setEnemyDelay(int)}, and can be regenerated with
 * {@link #regenerateLevel()}.
 * 
 * @author pstorum
 * 
 */
public class GameLevel extends GContainer {

	/**
	 * The hero for this game level.
	 */
	private final Character hero;

	private final TimerListener tlEnemies = new TimerListener(0) {
		@Override
		public void invoke(GObject target, Context context) {
			addRandomEnemy();
		}
	};

	public GameLevel() {
		setSize(1000, 600);
		GSprite bg1 = ImageCache.getSprite("tempBack.png");
		setBackgroundSprite(bg1);

		BedRock unbreakable = new BedRock();
		add(unbreakable);
		unbreakable.setLocation(500, 600);

		generateTerrain();
		hero = new Character();
		addAt(hero, 500, 200);

		NextSlideTwo next = new NextSlideTwo();
		addAt(next, 995, 300);

		addListener(tlEnemies);
	}

	public void generateTerrain() {
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
				t = new WaterBlock();
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
	}

	public void setEnemyDelay(int frm) {
		tlEnemies.setInterval(frm);
	}

	public void regenerateLevel() {
		deleteTerrain();
		generateTerrain();
		hero.setLocation(500, 200);
	}

	public void deleteTerrain() {
		for (GObject obj : getObjects()) {
			if (!(obj instanceof BedRock)
					&& (obj instanceof SolidGround || obj instanceof LiquidGround)) {
				obj.removeSelf();
			}
		}
	}

	private void addRandomEnemy() {

		int enemyPick = (int) (Math.random() * 1);

		Enemies e = null;
		switch (enemyPick) {
		case 0:
			e = new EnemyOne();
			break;
		default:
			e = new EnemyOne();
			break;
		}

		this.addAt(e, 900, 200);
	}

}
