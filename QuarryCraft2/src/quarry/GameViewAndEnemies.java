package quarry;

import enemy.Enemies;
import enemy.EnemyOne;

import java.util.List;

import quarry.Character;
import soil.Land;
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
import jgame.listener.LocalClickListener;
import jgame.listener.TimerListener;

public class GameViewAndEnemies extends GContainer {
	public static int newTerrain = 1;
	public GameViewAndEnemies() {
		setSize(1000, 600);
		GSprite bg1 = ImageCache.getSprite("tempBack.png");
		bg1.setAnchorCenter();
		addAtCenter(bg1);

		bedRock unbreakable = new bedRock();
		add(unbreakable);
		unbreakable.setLocation(500, 600);
		
		NextSlideTwo next = new NextSlideTwo();
		add(next);
		next.setLocation(995, 300);
		if (newTerrain <= 1){
			RandomTerrain();
			try {
			    Thread.sleep(4000);
			    newTerrain = newTerrain++;
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
		}else if(newTerrain>=3){
			deleteTerrain(null);
			newTerrain=1;
			}
			
		Character hero = new Character();
		add(hero);
		hero.setLocation(500, 200);

		final TimerListener enemyTimer = new TimerListener(500) {

			@Override
			public void invoke(GObject target, Context context) {
				addRandomEnemy();
				
				
			}
		};

		addListener(enemyTimer);

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
	
	public void deleteTerrain(Context context){
		List<SolidGround> solidGrounds = context
				.getInstancesOfClass(SolidGround.class);
		for (SolidGround solidGround : solidGrounds) {

			GObject groundObject = (GObject) solidGround;
			groundObject.removeSelf();
		}
		
		List<LiquidGround> liquidGrounds = context
				.getInstancesOfClass(LiquidGround.class);
		for (LiquidGround liquidGround : liquidGrounds) {

			GObject liquidObject = (GObject) liquidGround;
			liquidObject.removeSelf();
		}
		
	}
	public void RandomTerrain(){
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
}
}