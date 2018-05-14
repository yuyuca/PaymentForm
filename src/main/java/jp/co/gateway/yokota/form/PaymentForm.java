package jp.co.gateway.yokota.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PaymentForm {

	@Min(0)
	@NotNull
	private String amount;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
