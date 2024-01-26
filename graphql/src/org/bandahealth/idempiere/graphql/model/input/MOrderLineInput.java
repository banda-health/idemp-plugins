package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.Query;

import java.math.BigDecimal;

public class MOrderLineInput extends X_C_OrderLineInput {

	private BigDecimal Qty;
	private BigDecimal Price;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_OrderLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MOrderLineInput(@JsonProperty("UUID") String UUID,
			@JsonProperty("C_Order") ForeignEntityInput C_OrderInput) {
		super(UUID);
		setC_OrderInput(C_OrderInput);
		if (getC_Order_ID() > 0) {
			this.setHeaderInfo(new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?",
					get_TrxName()).setParameters(getC_Order_ID()).first());
		}
		super.setPrice();
	}

	public BigDecimal getQty() {
		return Qty;
	}

	@Override
	public void setQty(BigDecimal qty) {
		Qty = qty;
		super.setQty(qty);
	}

	public BigDecimal getPrice() {
		return Price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		Price = price;
	}
}
