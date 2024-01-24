package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRequest;
import org.compiere.model.MRequestUpdate;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_RequestUpdateResolver extends POResolver<MRequestUpdate> implements GraphQLResolver<MRequestUpdate> {


	static Map<String, String> CONFIDENTIALTYPEENTRY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "1eb43dd1-53c0-4b5c-aae4-585c7d3fc9c2");
			put("C", "0f1983c1-e543-4a8f-9b8a-4a00d2a111f4");
			put("I", "7c6def43-3d72-4c5b-93ce-dfbefd8545e4");
			put("P", "467c826c-2a44-4f65-8026-8dc6b1d7edec");
		}
	};
	public CompletableFuture<MRefList_BH> ConfidentialTypeEntry(MRequestUpdate entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getConfidentialTypeEntry())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CONFIDENTIALTYPEENTRY_UUIDS_BY_VALUE.get(entity.getConfidentialTypeEntry()));
	}


	/**
	 * Get Product Used.
	 *
	 * @return Product/Resource/Service used in Request
	 */
	public CompletableFuture<MProduct_BH> M_ProductSpent(MRequestUpdate entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductSpent_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_ProductSpent_ID());
	}


	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	public CompletableFuture<MRequest> R_Request(MRequestUpdate entity, DataFetchingEnvironment environment) {
		if (entity.getR_Request_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestDataLoader.DATALOADER_R_Request_BY_ID);
		return dataLoader.load(entity.getR_Request_ID());
	}

}
