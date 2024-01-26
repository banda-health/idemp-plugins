package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.Query;

public class MInvoiceInput extends X_C_InvoiceInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Invoice_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInvoiceInput(@JsonProperty("UUID") String UUID, @JsonProperty("C_Order") ForeignEntityInput C_Order) {
		super(UUID);
		setC_OrderInput(C_Order);
		if (getC_Order_ID() > 0) {
			this.setOrder(new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?",
					get_TrxName()).setParameters(getC_Order_ID()).first());
		}
	}
}
