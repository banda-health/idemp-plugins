package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.input.I_M_ProductInput;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.MProductUtil;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.PO;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MProductMutation extends X_M_ProductMutation {
	@Override
	public MProduct_BH M_ProductSave(I_M_ProductInput input, DataFetchingEnvironment environment) {
		Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
		// If the product exists and it already has a PO, make sure the purchase price can't be overridden
		if (input.getM_Product_ID() != 0 && !MProductUtil.getProductIdsWithNoFinishedPurchaseOrders(idempiereProperties,
				Collections.singleton(input.getM_Product_ID())).contains(input.getM_Product_ID())) {
			input.setBH_BuyPrice(
					((MProduct_BH) Repository.getById(BandaGraphQLContext.getCtx(environment), MProduct_BH.Table_Name, null,
							input.getM_Product_ID())).getBH_BuyPrice());
		}
		return super.M_ProductSave(input, environment);
	}

	public Boolean M_ProductMerge(String OldUU, String NewUU, DataFetchingEnvironment environment) {
		try {
			// Security checks
			ModelUtil.getTableAndCheckAccess(BandaGraphQLContext.getCtx(environment), MProduct_BH.Table_Name, true);
			Map<String, PO> productsByUU =
					Repository.getByUuids(BandaGraphQLContext.getCtx(environment), MProduct_BH.Table_Name, null,
							Set.of(OldUU, NewUU));
			if (productsByUU.get(OldUU).getAD_Client_ID() != productsByUU.get(NewUU).getAD_Client_ID()) {
				return false;
			}
			//
			// Merge away
			try (CPreparedStatement statement = DB.prepareStatement("SELECT bh_merge_records(?, ?::uuid, ?::uuid)", null)) {
				DB.setParameters(statement, List.of(MProduct_BH.Table_Name, OldUU, NewUU).toArray());
				statement.execute();
			}
			return true;
		} catch (DBException | SQLException e) {
			log.severe(e.getMessage());
		}
		return false;
	}
}
