/**
 * 
 * @author Reid rmb3yz
 * 
 */
public class PiggyBank {

	private int size;
	private int currentCoins;
	private boolean isBroken;

	/**
	 * @param maxNumberOfCoins
	 */
	public PiggyBank(int maxNumberOfCoins) {
		this.size = maxNumberOfCoins;
		this.currentCoins = 0;
		this.isBroken = false;
	}

	/**
	 * 
	 * @return
	 */
	public int countCoins() {
		if (this.isBroken == true) {
			return 0;
		} else {
			return this.currentCoins;
		}
	}

	/**
	 * 
	 * @param c
	 */
	public void addCoins(int c) throws IllegalStateException {
		if (this.isBroken == true) {
			throw new IllegalStateException("Can't add coins to a broken bank.");
		} else {
			this.currentCoins = currentCoins + c;
			if (this.currentCoins > this.size) {
				breakBank();
			}
		}
	}

	/**
	 * 
	 * 
	 */
	public void breakBank() throws RuntimeException {
		int lostCoins = this.currentCoins;
		this.currentCoins = 0;
		this.isBroken = true;
		throw new RuntimeException(lostCoins + " coins fly all over the place!");
	}

	@Override
	public String toString() {
		if (this.isBroken == true) {
			return "A broken bank";
		} else {
			return "A bank with " + this.currentCoins + " coins inside";
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCurrentCoins() {
		return currentCoins;
	}

	public void setCurrentCoins(int currentCoins) {
		this.currentCoins = currentCoins;
	}

	public boolean isBroken() {
		return isBroken;
	}

	public void setIsBroken(boolean isBroken) {
		this.isBroken = isBroken;
	}

}
