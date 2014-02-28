package enemy;
import quarry.QCraft2;
import jgame.ImageCache;
public class EnemyOne extends Enemies {
	public EnemyOne() {
		super(ImageCache.getSequentialImages("EnemieSequence/b", 1, 20,".png"), 200, 2);	
	}
	@Override
	public double getSlowness() {
		return 3.5;
	}
}