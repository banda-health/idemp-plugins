package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.logging.Level;

import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;

public class StockTakeProcess extends SvrProcess {

	private int productID, attributeSetInstanceId, quantity;

	@Override
	protected void prepare() {
		ProcessInfoParameter[] parameters = getParameter();
		for (ProcessInfoParameter parameter : parameters) {
			String parameterName = parameter.getParameterName();
			if (parameterName.equalsIgnoreCase("M_Product_ID")) {
				productID = parameter.getParameterAsInt();
			} else if (parameterName.equalsIgnoreCase("M_AttributeSetInstance_ID")) {
				attributeSetInstanceId = parameter.getParameterAsInt();
			} else if (parameterName.equalsIgnoreCase("quantity")) {
				quantity = parameter.getParameterAsInt();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		String whereClause = MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND "
				+ MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID + "=?";
		MStorageOnHand storage = ((MStorageOnHand) new Query(Env.getCtx(), MStorageOnHand.Table_Name, whereClause,
				get_TrxName()).setParameters(productID, attributeSetInstanceId).first());
		storage.setQtyOnHand(new BigDecimal(quantity));
		storage.save();

		return null;
	}
}
