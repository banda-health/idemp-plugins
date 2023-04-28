package org.bandahealth.idempiere.base.process;

import org.compiere.model.MProduct;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MTransaction;
import org.compiere.util.CLogger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Level;

/**
 * Update Stock quantity
 *
 * @author andrew
 */
public class UpdateStock {

	private static CLogger log = CLogger.getCLogger(UpdateStock.class);

	// TODO: DO NOT USE!!!! Delete this method
	@Deprecated
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
}
