package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;

import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

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
		// get original stock
		List<MStorageOnHand> listExistingStorage = new Query(getCtx(), MStorageOnHand.Table_Name,
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID
						+ "=?", get_TrxName())
				.setParameters(productID, attributeSetInstanceId)
				.setOnlyActiveRecords(true)
				.list();
		if (listExistingStorage == null) {
			return null;
		}

		for (MStorageOnHand existingStorage : listExistingStorage) {
			UpdateStock.updateStock(existingStorage, new BigDecimal(quantity));
		}

		return null;
	}
}
