package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_InventoryLineInput;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class MInventoryLineMutation extends X_M_InventoryLineMutation {
	@Override
	public MInventoryLine_BH M_InventoryLineSave(I_M_InventoryLineInput input, DataFetchingEnvironment environment) {
		// Override the quantity book with what's currently in the DB
		input.setQtyBook(new Query(Env.getCtx(), MStorageOnHand.Table_Name,
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID +
						"=? AND " + MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?", null).setParameters(input.getM_Product_ID(),
						input.getM_AttributeSetInstance_ID(), input.getM_Locator_ID())
				.sum(MStorageOnHand.COLUMNNAME_QtyOnHand));
		return super.M_InventoryLineSave(input, environment);
	}
}
