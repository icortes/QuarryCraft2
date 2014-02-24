package quarry;
import jgame.ImageCache;
import quarry.QCraft2;
public class Minions extends FriendlyObjects {
	public Minions() {
		super(ImageCache.forClass(QCraft2.class).get("hero.png"), 500);
	}
	@Override
	public double getSlowness() {
		return 3.5;
	}
}