package nvdixit.Tracksaction.Transaction;

import java.time.LocalDate;

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
	/** The date of the transaction */
	private LocalDate dateOfTransaction;

	public Transaction(String name, double amount, LocalDate dateOfTransaction) {
		this.setName(name);
		this.setAmount(amount);
		this.setDateOfTransaction(dateOfTransaction);
	}
	
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

	/**
	 * Returns the date of the transaction
	 * @return the date of the transaction
	 */
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	/**
	 * Sets the date of the Transaction
	 * @param dateOfTransaction the date to set
	 */
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	
	
	@Override
	public int compareTo(Transaction o) {
		
		if(this.dateOfTransaction.compareTo(o.dateOfTransaction) < 0) {
			return -1;
		}
		else if(this.dateOfTransaction.compareTo(o.dateOfTransaction) > 0) {
			return 1;
		}
		
		if(this.amount < o.amount) {
			return -1;
		}
		else if(this.amount > o.amount) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateOfTransaction == null) ? 0 : dateOfTransaction.hashCode());
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
		if (dateOfTransaction == null) {
			if (other.dateOfTransaction != null)
				return false;
		} else if (!dateOfTransaction.equals(other.dateOfTransaction))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}