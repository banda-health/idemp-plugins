package org.bandahealth.idempiere.base.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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
				transactionName).setParameters(productID, attributeSetInstanceId).setOnlyActiveRecords(true)
				.setOrderBy(MStorageOnHand.COLUMNNAME_DateMaterialPolicy + " DESC")
				.list();

		if (listExistingStorage.isEmpty()) {
			return;
		}

		// We don't want to update every record (since iDempiere creates a new MStorageOnHand record each time
		// a product is received on a new date, though it matches the attribute set instance). Instead, take
		// the total the user entered and only update the most recent MStorageOnHand record (and subtract out
		// the old values, zeroing them out if need be)
		BigDecimal currentQuantity =
				listExistingStorage.stream().map(MStorageOnHand::getQtyOnHand).reduce(BigDecimal.ZERO, BigDecimal::add);
		MStorageOnHand mostRecentStorageRecord = listExistingStorage.get(0);
		// Get the counts of all other stocks beyond the most recent, in case we need it
		BigDecimal quantityBesidesMostRecent = currentQuantity.subtract(mostRecentStorageRecord.getQtyOnHand());
		// If the quantity the user wants is more than now, just update the last value
		if (quantity.compareTo(currentQuantity) > 0) {
			// If we only have one storage record, just update it
			if (listExistingStorage.size() == 1) {
				updateStock(mostRecentStorageRecord, quantity);
			} else {
				// Subtract the quantity besides most recent from the entered quantity so totals will still match
				updateStock(mostRecentStorageRecord, quantity.subtract(quantityBesidesMostRecent));
			}
		} else {
			// Now, we have to do some magic. To be consistent, we'll skip the case where we could just update the most
			// recent record (assuming it would still have a quantity greater than zero) and just start reducing the quantities of
			// old records
			// As a helpful example, imagine we have a list of storage records with the following quantities: 4, 3, 2, 5, 1
			// This would show a total of 15 on the UI. Say the user wants it now to be 10. We now have to cycle through
			// those values so the quantities now become the following for the records: 4, 3, 2, 1, 0
			BigDecimal newTotal = BigDecimal.ZERO;
			for (MStorageOnHand storageToUpdate : listExistingStorage) {
				// If this record has no quantity, just skip it
				if (storageToUpdate.getQtyOnHand().compareTo(BigDecimal.ZERO) == 0) {
					continue;
				}
				// If the we're already at the requested total and there are still records to handle, set this record's
				// quantity to zero
				if (newTotal.compareTo(quantity) == 0) {
					updateStock(storageToUpdate, BigDecimal.ZERO);
					continue;
				}
				newTotal = newTotal.add(storageToUpdate.getQtyOnHand());
				// If this storage quantity pushes the total over the requested quantity, reduce it's current quantity so
				// that the new quantity matches the total requested by the user
				if (newTotal.compareTo(quantity) > 0) {
					// Following our example above: By the time we get to the fourth record, storageToUpdate.getQtyOnHand()
					// will be 5, the requested quantity will still be 10, and newTotal is now 14. So, we'll get the new
					// quantity for this record by doing 5 - 14 + 10 = 1
					updateStock(storageToUpdate, storageToUpdate.getQtyOnHand().subtract(newTotal).add(quantity));
					// Since the above adjustment will make the new total and requested quantity match, just set that
					newTotal = quantity;
				}
			}
		}
	}
}
