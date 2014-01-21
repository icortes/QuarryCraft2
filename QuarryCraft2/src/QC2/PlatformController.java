package QC2;

import java.awt.geom.Point2D;
import java.util.Set;

import jgame.Context;
import jgame.GObject;
import jgame.controller.Controller;

/**
 * A controller that controls an objects location based on keyboard input
 * defined by the given {@link PlatformControlScheme}. This controller cannot be
 * shared.
 * 
 * @author William Chargin
 * 
 */
public class PlatformController implements Controller {

	/**
	 * The default gravitational acceleration, in px/frame<sup>2</sup>.
	 */
	public static final double DEFAULT_GRAVITY = 1;

	/**
	 * The control scheme for this platform controller.
	 */
	private final PlatformControlScheme controlScheme;

	/**
	 * The object to be controlled by this platform controller.
	 */
	private GObject object;

	/**
	 * The current velocity of the target object.
	 */
	private Point2D velocity = new Point2D.Double();

	/**
	 * The maximum horizontal movement speed.
	 */
	private double maxSpeed;

	/**
	 * The maximum jump speed.
	 */
	private double maxJump;

	/**
	 * The gravitational acceleration, in px/frame<sup>2</sup>.
	 */
	private double gravity;

	/**
	 * Creates the controller with the given parameters. The default
	 * gravitational acceleration will be used.
	 * 
	 * @param controlScheme
	 *            the control scheme to use
	 * @param maxSpeed
	 *            the maximum horizontal speed (in px/frame)
	 * @param maxJump
	 *            the maximum jump speed (in px/frame)
	 */
	public PlatformController(PlatformControlScheme controlScheme,
			double maxSpeed, double maxJump) {
		this(controlScheme, maxSpeed, maxJump, DEFAULT_GRAVITY);
	}

	/**
	 * Creates the controller with the given parameters.
	 * 
	 * @param controlScheme
	 *            the control scheme to use
	 * @param maxSpeed
	 *            the maximum horizontal speed (in px/frame)
	 * @param maxJump
	 *            the maximum jump speed (in px/frame)
	 * @param gravity
	 *            the gravitation acceleration (in px/frame<sup>2</sup>)
	 */
	public PlatformController(PlatformControlScheme controlScheme,
			double maxSpeed, double maxJump, double gravity) {
		super();
		this.controlScheme = controlScheme;
		this.velocity = new Point2D.Double();
		this.maxSpeed = maxSpeed;
		this.maxJump = maxJump;
		this.gravity = gravity;
	}

	@Override
	public void controlObject(GObject target, Context context) {
		// Ensure that this is locked to one object
		if (object == null) {
			target = object;
		} else if (object != target) {
			throw new IllegalArgumentException(
					"This PlatformController already belongs to " + object);
		}

		// Get a list of all keys pressed.
		Set<Integer> keys = context.getKeyCodesPressed();

		int horizontal = 0;
		boolean jump = false;

		// Check each key.
		for (int key : keys) {
			
			 /* TODO insert code here to modify the variables "horizontal" and
			 * "jump" appropriately:
			 * 
			 * "horizontal" should be 1 if the right key is pressed, -1 if the
			 * left key is pressed, or 0 if neither or both are pressed
			 * 
			 * "jump" should be true if the jump key is pressed or false if it
			 * is not
			 * 
			 * hint: compare the value of "key" to the controlScheme's
			 * properties (controlScheme.lt, controlScheme.rt, and
			 * controlScheme.jump)
			 */
		}

		// TODO insert code to check if the target is touching solid ground
		// hint: check if the target is colliding with any SolidGround object
		// the method context.getInstancesOfClass will be helpful
		boolean onSolidGround = false;

		if (onSolidGround) {
			if (jump) {
				// TODO set the vertical velocity to the jumping speed, upward
			} else {
				// TODO stop vertical movement
			}
		} else {
			// TODO increase the downward vertical velocity by "gravity"
			// limit velocity to the height of the object (to avoid passing
			// through stuff)
		}

		// TODO set the horizontal velocity to the desired velocity
		// remember that "horizontal" is -1/0/1 for left/stop/right
		// and that maxSpeed contains the horizontal speed

		// Move the object in the desired manner
		target.setLocation(target.getX() + velocity.getX(), target.getY()
				+ velocity.getY());
	}

	/**
	 * Gets the current maximum jump.
	 * 
	 * @return the maximum jump, in px/frame
	 */
	public double getMaxJump() {
		return maxJump;
	}

	/**
	 * Gets the current maximum horizontal speed.
	 * 
	 * @return the maximum horizontal speed, in px/frame
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * Sets the new maximum jump.
	 * 
	 * @param maxJump
	 *            the maximum jump, in px/frame
	 */
	public void setMaxJump(double maxJump) {
		this.maxJump = maxJump;
	}

	/**
	 * Sets the maximum horizontal speed.
	 * 
	 * @param maxSpeed
	 *            the new maximum horizontal speed, in px/frame
	 */
	public void setMaxSpeed(double maxSpeed) {
		if (maxSpeed < 0) {
			throw new IllegalArgumentException("maxSpeed must be nonnegative: "
					+ maxSpeed);
		}
		this.maxSpeed = maxSpeed;
	}

}
