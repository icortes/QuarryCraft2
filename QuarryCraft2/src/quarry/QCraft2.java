package quarry;	

import java.awt.Color;

import quarry.GameViewMain;
import quarry.QCraft2;
import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;

public class QCraft2 extends Game {

	public enum View {
		GAMEMAIN, GAME, OPTIONS, GAME_OVER, GAMEANDENEMIES;

	}
	public static void main(String[] args) {
		ImageCache.create(QCraft2.class, "/QC2/rsc/");
		QCraft2 craftyness = new QCraft2();
		craftyness.startGame("QCraft2");
	}

	public QCraft2() {
		GRootContainer root = new GRootContainer(Color.BLACK);
		setRootContainer(root);

		GameViewMain gameViewMain = new GameViewMain();
		root.addView(View.GAMEMAIN, gameViewMain);
		
		GameView game = new GameView();
		root.addView(View.GAME, game);
		
		GameViewAndEnemies gameAndEnemies = new GameViewAndEnemies();
		root.addView(View.GAMEANDENEMIES, gameAndEnemies);
	}
}
