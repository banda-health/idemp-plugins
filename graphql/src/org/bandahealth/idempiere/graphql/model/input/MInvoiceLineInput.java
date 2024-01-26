package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.compiere.model.Query;

import java.math.BigDecimal;

public class MInvoiceLineInput extends X_C_InvoiceLineInput {

	private BigDecimal Qty;
	private BigDecimal Price;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_InvoiceLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInvoiceLineInput(@JsonProperty("UUID") String UUID,
			@JsonProperty("C_Invoice") ForeignEntityInput C_InvoiceInput,
			@JsonProperty("C_OrderLine") ForeignEntityInput C_OrderLineInput) {
		super(UUID);
		setC_InvoiceInput(C_InvoiceInput);
		if (getC_Invoice_ID() > 0) {
			this.setInvoice(new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?",
					get_TrxName()).setParameters(getC_Invoice_ID()).first());
		}
		setC_OrderLineInput(C_OrderLineInput);
		if (getC_OrderLine_ID() > 0) {
			this.setOrderLine(new Query(getCtx(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_OrderLine_ID + "=?",
					get_TrxName()).setParameters(getC_OrderLine_ID()).first());
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
		super.setPrice(price);
	}
}
