package breakout;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Represents the state of a powerup block in the breakout game.
 * 
 * @invar | getLocation() != null
 * @invar | getHealth() <= 3 && getHealth() >= 0
 * @immutable
 */
public class PowerupBallBlockState extends BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;	
	private final Color color = new Color(255,0,0);
	
	/**
	 * Construct a powerup Block with a certain location.
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public PowerupBallBlockState(Rect location) {
		this.location = location;
	}
	
	/**
	 * Return the rectangle occupied by this block in the field.
	 * @post | result != null
	 */
	public Rect getLocation() {
		return location;
	}
	
	/**
	 * Return the colour of this Block.
	 * @post | result != null
	 * @inspects | this
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Removes THIS block from the Blockstate[] and/or makes it lose 1 health.
	 * @pre | blocks != null
	 * @creates | result
	 * @post | result != null
	 * @post | (result.length == blocks.length && this.getHealth() != 1) || result.length == blocks.length - 1
	 * @post | result.length == blocks.length - 1 
	 */
	public BlockState[] removeBlock(BlockState[] blocks) {
		ArrayList<BlockState> nblocks = new ArrayList<BlockState>();
		for( BlockState b : blocks ) {
			if(b != this) {
				nblocks.add(b);
			}
		}
		return nblocks.toArray(new BlockState[] {});
	}
	
	/**
	 * Return the health of this Block.
	 * @post | result > 0
	 */
	public int getHealth() {
		return 1;
	}
	
	/**
	 * Changes the ball's subclass if needed and resets its lifetime to 10000 if needed.
	 * @pre | ball != null
	 * @mutates | ball
	 * @creates | result
	 * @post | result != null
	 * @post | result.getLifetime() == 10000
	 * @post | ball.getLocation().equals(result.getLocation())
	 * @post | ball.getVelocity().equals(result.getVelocity())
	 */
	public Ball ballChange(Ball ball) {
		ball.setLifetime(10000);
		ball = ball.changeBall();
		return ball;
	}
	
	/**
	 * Returns a new paddle with a different subclass if needed and resets its lifetime to 10000 if needed.
	 * @pre | paddle != null
	 * @pre | paddle.getHits() <= 3
	 * @pre | paddle.getHits() >= 0
	 * @post | result != null
	 * @post | paddle.getCenter().equals(result.getCenter())
	 * @post | result.getHits() <= 3
	 * @post | result.getHits() >= 0
	 */
	public PaddleState paddleChange(PaddleState paddle) {
		return paddle;
	}

}