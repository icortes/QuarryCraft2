package QC2;

import QC2.GameViewMain;
import java.awt.Color;

import QC2.QCraft2;
import jgame.GRootContainer;
import jgame.Game;
import jgame.ImageCache;

public class QCraft2 extends Game {
	public enum View {
		GAMEMAIN, GAME, OPTIONS, GAME_OVER;

	}
	public static void main(String[] args) {
		ImageCache.create(QCraft2.class, "/QC2/rsc/");
		QCraft2 craftyness = new QCraft2();
		craftyness.startGame("QCraft2");
	}

	public QCraft2() {
		GRootContainer root = new GRootContainer(Color.BLACK);
		setRootContainer(root);

		GameViewMain gameView = new GameViewMain();
		root.addView(View.GAMEMAIN, gameView);
	}
}
