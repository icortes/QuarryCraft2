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

public class GameView extends GContainer {
	public GameView() {
		setSize(1000, 600);
		GSprite bg1 = ImageCache.getSprite("tempBack.png");
		bg1.setAnchorCenter();
		addAtCenter(bg1);

		LocalClickListener lcl = new LocalClickListener(){
			Enemies e = new EnemyOne();
			//e = new EnemyOne();
			@Override
			public void invoke(GObject target, Context context) {
				addAt(e,900,600);
			}
			 
		 };
			addListener(lcl);
		
		bedRock unbreakable = new bedRock();
		add(unbreakable);
		unbreakable.setLocation(500, 600);
		
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
		
//		final TimerListener enemyTimer = new TimerListener(60) {
//
//			@Override
//			public void invoke(GObject target, Context context) {
//				addRandomEnemy();
//			}
//		};
//
//		addListener(enemyTimer);
		

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

		this.add(e);
	}
//	public void waterSpread(Context context){
//		
//		List<LiquidGround> liquidGrounds = context.getInstancesOfClass(LiquidGround.class);
//		if (liquidGrounds != ){
//			addAt(waterBlock, i, l);
//		}
//
//		
//	}
}
