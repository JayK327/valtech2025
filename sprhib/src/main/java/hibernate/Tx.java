package hibernate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="disc")
//@DiscriminatorValue(value="tx")
//@Table(name="alltxs")

//@Inheritance(strategy=InheritanceType.JOINED)

//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Table(name="txper")


@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="disc")
@DiscriminatorValue(value="tx")
@Table(name="alltxs")
public class Tx {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="txseq")
	@SequenceGenerator(name="txseq",sequenceName="tx_seq",allocationSize = 1)
	private long id;
	private double amount;
	@ManyToOne(targetEntity = Account.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)//collection fetch lazy,individual fetch eagar
	@JoinColumn(name="account_id",referencedColumnName = "id")  //name=column on the current entity
	private Account account;
	
	
	@Override
	public String toString() {
		return "Tx [id=" + id + ", amount=" + amount + ", account=" + account + "]";
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Tx() {}
	
	public Tx(double amount) {
		this.amount = amount;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
