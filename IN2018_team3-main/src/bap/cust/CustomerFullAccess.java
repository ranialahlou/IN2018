package bap.cust;

public interface CustomerFullAccess extends CustomerLimitedAccess {
	public void setDiscountType(DiscountType discountType);
	public void setAccountType(AccountType accountType);
}
