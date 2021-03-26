package bap.cust;

import java.util.List;

public interface CustomerLimitedAccess {
	public String getName();
	public void setName(String name);
	public String getEmail();
	public void setEmail(String email);	
	public String getPhone();
	public void setPhone(String phone);
	public List<Job> getJobs();
	public DiscountType getDiscountType();
	public AccountType getAccountType();
}
