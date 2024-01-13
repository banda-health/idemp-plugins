package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class MInventoryLineMutation extends X_M_InventoryLineMutation {
	@Override
	protected PO save(PO entity, DataFetchingEnvironment environment) {
		MInventoryLine_BH castEntity = (MInventoryLine_BH) entity;
		// Override the quantity book with what's currently in the DB
		castEntity.setQtyBook(new Query(Env.getCtx(), MStorageOnHand.Table_Name,
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID +
						"=? AND " + MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?", null).setParameters(castEntity.getM_Product_ID(),
						castEntity.getM_AttributeSetInstance_ID(), castEntity.getM_Locator_ID())
				.sum(MStorageOnHand.COLUMNNAME_QtyOnHand));
		return super.save(entity, environment);
	}
}
