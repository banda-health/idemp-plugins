package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ProductInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.MProductUtil;
import org.compiere.model.PO;

public class MProductMutation extends X_M_ProductMutation {
	@Override
	public MProduct_BH M_ProductSave(I_M_ProductInput input, DataFetchingEnvironment environment) {
		// If the product is existing and it already has a PO, make sure the purchase price can't be overridden
		if (input.getM_Product_ID() != 0 &&
				!MProductUtil.getProductIdsWithNoFinishedPurchaseOrders().contains(input.getM_Product_ID())) {
			input.setBH_BuyPrice(
					((MProduct_BH) Repository.getById(BandaGraphQLContext.getCtx(environment), MProduct_BH.Table_Name, null,
							input.getM_Product_ID())).getBH_BuyPrice());
		}
		return super.M_ProductSave(input, environment);
	}
}
