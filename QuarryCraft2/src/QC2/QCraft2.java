package QC2;

import QC2.QCraft2;
import jgame.ImageCache;

public class QCraft2 {
	public enum View {
		GAMEMAIN, GAME, OPTIONS, GAME_OVER;

	}
	public static void main(String[] args) {
		ImageCache.create(QCraft2.class, "/QC2/rsc/");
		QCraft2 craftyness = new QCraft2();
		craftyness.startGame("QCraft2");
	}

	public QCraft2() {
		
	}
}
