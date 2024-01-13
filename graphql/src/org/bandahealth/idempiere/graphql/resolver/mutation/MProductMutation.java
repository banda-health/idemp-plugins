package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.MProductUtil;
import org.compiere.model.PO;

public class MProductMutation extends X_M_ProductMutation {
	@Override
	protected PO save(PO entity, DataFetchingEnvironment environment) {
		MProduct_BH castEntity = (MProduct_BH) entity;
		// If the product is existing and it already has a PO, make sure the purchase price can't be overridden
		if (castEntity.getM_Product_ID() != 0 &&
				!MProductUtil.getProductIdsWithNoFinishedPurchaseOrders().contains(castEntity.getM_Product_ID())) {
			castEntity.setBH_BuyPrice(
					((MProduct_BH) Repository.getById(BandaGraphQLContext.getCtx(environment), MProduct_BH.Table_Name, null,
							castEntity.getM_Product_ID())).getBH_BuyPrice());
		}
		return super.save(castEntity, environment);
	}
}
