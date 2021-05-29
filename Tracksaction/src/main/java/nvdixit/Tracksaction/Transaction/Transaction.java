package nvdixit.Tracksaction.Transaction;

/**
 * An individual transaction on a credit card
 * @author nikhildixit
 *
 */
public class Transaction implements Comparable<Transaction> {

	/** The name of the transaction */
	private String name;
	/** The amount of the transaction */
	private double amount;

	public Transaction(String name, double amount) {
		this.setName(name);
		this.setAmount(amount);
	}
	
	/**
	 * Empty dummy constructor for MongoDB use
	 */
	public Transaction() {}
	
	/**
	 * Returns the name of the transaction
	 * @return the name of the transaction
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the Transaction
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the amount of the transaction
	 * @return the amount of the transaction
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount of the Transaction
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	@Override
	public int compareTo(Transaction o) {
		
		if(this.amount < o.amount) {
			return -1;
		}
		else if(this.amount > o.amount) {
			return 1;
		}
		
		return 0;
	}

	/**
	 * Returns a String of the Transaction
	 * @return a String of the Transaction
	 */
	public String toString() {
		return "\t" + this.getName() + " " + this.getAmount();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
