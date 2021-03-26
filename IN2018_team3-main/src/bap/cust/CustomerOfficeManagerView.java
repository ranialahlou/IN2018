package bap.cust;

import java.util.ArrayList;
import java.util.List;

public class CustomerOfficeManagerView implements CustomerFullAccess {
	private String name;
	private String email;
	private String phone;
	private List<Job> jobs;
	private DiscountType discountType;
	private AccountType accountType;

	public CustomerOfficeManagerView(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.jobs = new ArrayList<Job>();
		this.discountType = DiscountType.NONE;
		this.accountType = AccountType.STANDARD;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPhone() {
		return this.phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public List<Job> getJobs() {
		return this.jobs;
	}

	@Override
	public DiscountType getDiscountType() {
		return this.discountType;
	}

	@Override
	public AccountType getAccountType() {
		return this.accountType;
	}

	@Override
	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	@Override
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
