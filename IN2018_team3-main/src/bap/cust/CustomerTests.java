/*package bap.cust;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CustomerTests {
	
	@Test
	public void createdCustomerFullAccess_whenFieldsAreSet_valuesAreCorrect() {
		String name = "John Doe";
		String email = "jd@johnsgroup.co.uk";
		String phone = "07123123456";
		AccountType accountType = AccountType.VALUED;
		DiscountType discountType = DiscountType.FIXED;
		
		CustomerOfficeManagerView c = new CustomerOfficeManagerView(name, email, phone);
		c.setAccountType(accountType);
		c.setDiscountType(discountType);
		
		assertEquals(name, c.getName());
		assertEquals(email, c.getEmail());
		assertEquals(phone, c.getPhone());
		assertEquals(accountType, c.getAccountType());
		assertEquals(discountType, c.getDiscountType());
	}
	
	@Test
	public void customerFullAccess_whenNameIsChanged_valueIsSavedWithinClass() {
		String name = "John Doe";
		String email = "jd@johnsgroup.co.uk";
		String phone = "07123123456";
		AccountType accountType = AccountType.VALUED;
		DiscountType discountType = DiscountType.FIXED;
		
		CustomerOfficeManagerView c = new CustomerOfficeManagerView(name, email, phone);
		c.setAccountType(accountType);
		c.setDiscountType(discountType);
		
		String name2 = "Mary Smith";
		
		c.setName(name2);
		
		assertNotEquals(name, c.getName());
		assertEquals(name2, c.getName());
	}
	
	@Test
	public void customerFullAccess_whenEmailIsChanged_valueIsSavedWithinClass() {
		String name = "John Doe";
		String email = "jd@johnsgroup.co.uk";
		String phone = "07123123456";
		AccountType accountType = AccountType.VALUED;
		DiscountType discountType = DiscountType.FIXED;
		
		CustomerOfficeManagerView c = new CustomerOfficeManagerView(name, email, phone);
		c.setAccountType(accountType);
		c.setDiscountType(discountType);
		
		String email2 = "iwantedtorock@yahoo.co.uk";
		
		c.setEmail(email2);
		
		assertNotEquals(email, c.getEmail());
		assertEquals(email2, c.getEmail());
	}
}

 */
