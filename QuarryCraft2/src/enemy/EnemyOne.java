package enemy;
import quarry.QCraft2;
import jgame.ImageCache;
public class EnemyOne extends Enemies {
	public EnemyOne() {
		super(ImageCache.forClass(QCraft2.class).get("hero.png"), 200, 100);
	}
	@Override
	public double getSlowness() {
		return 3.5;
	}
}