package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.MProduct;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MTransaction;
import org.compiere.model.Query;
import org.compiere.util.CLogger;

/**
 * Update Stock quantity
 * 
 * @author andrew
 *
 */
public class UpdateStock {

	private static CLogger log = CLogger.getCLogger(UpdateStock.class);

	public static void updateStock(MStorageOnHand mStorage, BigDecimal updatedQuantity) {
		String movementType = MTransaction.MOVEMENTTYPE_ProductionPlus;
		try {

			int compare = mStorage.getQtyOnHand().compareTo(updatedQuantity);
			if (compare == 0) {
				log.log(Level.SEVERE, "Can't update with the same Quantity Value.");
				return;
			} else if (compare > 0) {
				movementType = MTransaction.MOVEMENTTYPE_Production_;
			}

			// get product
			MProduct product = MProduct.get(mStorage.getCtx(), mStorage.getM_Product_ID());

			if (product != null) {
				// create transaction
				MTransaction mTransaction = new MTransaction(mStorage.getCtx(), 0, mStorage.get_TrxName());
				mTransaction.setAD_Org_ID(mStorage.getAD_Org_ID());
				mTransaction.setMovementQty(updatedQuantity.subtract(mStorage.getQtyOnHand()));
				mTransaction.setM_AttributeSetInstance_ID(mStorage.getM_AttributeSetInstance_ID());
				mTransaction.setMovementDate(new Timestamp(System.currentTimeMillis()));
				mTransaction.setM_Product_ID(mStorage.getM_Product_ID());
				mTransaction.setM_Locator_ID(mStorage.getM_Locator_ID());
				mTransaction.setMovementType(movementType);
				mTransaction.save();
			}
		} catch (Exception ex) {
			log.log(Level.SEVERE, "Can't create transaction: " + ex.getMessage());
		}

		mStorage.setQtyOnHand(updatedQuantity);
		mStorage.save();
	}

	public static void updateStock(Properties context, String transactionName, int productID,
			int attributeSetInstanceId, BigDecimal quantity) {
		// get original stock
		List<MStorageOnHand> listExistingStorage = new Query(context, MStorageOnHand.Table_Name,
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID
						+ "=?",
				transactionName).setParameters(productID, attributeSetInstanceId).setOnlyActiveRecords(true).list();
		if (listExistingStorage == null) {
			return;
		}
		
		for (MStorageOnHand existingStorage : listExistingStorage) {
			updateStock(existingStorage, quantity);
		}
	}
}
