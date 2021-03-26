package bap.cust;

import java.util.ArrayList;
import java.util.List;

public class Discount {
	private List<DiscountBand> discountBands;
	private DiscountType discountType;
	private double value;

	public Discount(DiscountType discountType, double value) {
		this.discountType = discountType;
		this.value = value;
		this.discountBands = new ArrayList<DiscountBand>();
	}

	public boolean addDiscountBand(DiscountBand discountBand) {
		if (this.discountType != DiscountType.FLEXIBLE) {
			return false;
		}
		this.discountBands.add(discountBand);
		return true;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
