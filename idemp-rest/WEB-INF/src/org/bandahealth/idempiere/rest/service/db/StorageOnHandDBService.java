package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.StorageOnHand;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StorageOnHandDBService extends BaseDBService<StorageOnHand, MStorageOnHand> {
	@Override
	public StorageOnHand saveEntity(StorageOnHand entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected StorageOnHand createInstanceWithDefaultFields(MStorageOnHand instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected StorageOnHand createInstanceWithAllFields(MStorageOnHand instance) {
		return new StorageOnHand(instance);
	}

	@Override
	protected StorageOnHand createInstanceWithSearchFields(MStorageOnHand instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MStorageOnHand getModelInstance() {
		return new MStorageOnHand(Env.getCtx(), 0, null);
	}

	/**
	 * Get the quantity on hand for a particular product/ASI/locator set
	 *
	 * @param productId              The ID of the product
	 * @param attributeSetInstanceId The ID of the attribute set instance
	 * @param locatorId              The ID of the locator
	 * @return The sum of the quantities of the storage on hand records
	 */
	public BigDecimal getQuantityOnHand(int productId, int attributeSetInstanceId, int locatorId) {
		return new Query(Env.getCtx(), MStorageOnHand.Table_Name,
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID +
						"=? AND " + MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?", null).setParameters(productId,
				attributeSetInstanceId, locatorId).sum(MStorageOnHand.COLUMNNAME_QtyOnHand);
	}
}
