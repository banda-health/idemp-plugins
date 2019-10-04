package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;

import org.compiere.model.MProduct;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MTransaction;
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
		BigDecimal updatedQuantity = new BigDecimal(quantity);
		String movementType = "P+";
		try {

			// get original quantity
			MStorageOnHand existingStorage = (MStorageOnHand) new Query(getCtx(), MStorageOnHand.Table_Name,
					MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND "
							+ MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID + "=?",
					get_TrxName()).setParameters(productID, attributeSetInstanceId).first();
			if (existingStorage == null) {
				return null;
			}

			int compare = existingStorage.getQtyOnHand().compareTo(updatedQuantity);
			if (compare == 0) {
				log.log(Level.SEVERE, "Can't update with the same Quantity Value.");
				return null;
			} else if (compare > 0) {
				movementType = "P-";
			}

			// get product
			MProduct product = MProduct.get(getCtx(), productID);

			if (product != null) {
				// create transaction
				MTransaction mTransaction = new MTransaction(getCtx(), 0, get_TrxName());
				mTransaction.setAD_Org_ID(existingStorage.getAD_Org_ID());
				mTransaction.setMovementQty(updatedQuantity.subtract(existingStorage.getQtyOnHand()));
				mTransaction.setM_AttributeSetInstance_ID(existingStorage.getM_AttributeSetInstance_ID());
				mTransaction.setMovementDate(new Timestamp(System.currentTimeMillis()));
				mTransaction.setM_Product_ID(productID);
				mTransaction.setM_Locator_ID(existingStorage.getM_Locator_ID());
				mTransaction.setMovementType(movementType);
				mTransaction.save();
			}
		} catch (Exception ex) {
			log.log(Level.SEVERE, "Can't create transaction: " + ex.getMessage());
		}

		String whereClause = MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND "
				+ MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID + "=?";
		MStorageOnHand storage = ((MStorageOnHand) new Query(Env.getCtx(), MStorageOnHand.Table_Name, whereClause,
				get_TrxName()).setParameters(productID, attributeSetInstanceId).first());
		storage.setQtyOnHand(updatedQuantity);
		storage.save();

		return null;
	}
}
