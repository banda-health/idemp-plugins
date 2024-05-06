package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StatusCategoryDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRequestType;
import org.compiere.model.MStatusCategory;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_RequestType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestTypeResolver extends POResolver<MRequestType> implements GraphQLResolver<MRequestType> {


	static Map<String, String> CONFIDENTIALTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "1eb43dd1-53c0-4b5c-aae4-585c7d3fc9c2");
			put("C", "0f1983c1-e543-4a8f-9b8a-4a00d2a111f4");
			put("I", "7c6def43-3d72-4c5b-93ce-dfbefd8545e4");
			put("P", "467c826c-2a44-4f65-8026-8dc6b1d7edec");
		}
	};
	public CompletableFuture<MRefList_BH> ConfidentialType(MRequestType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getConfidentialType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(CONFIDENTIALTYPE_UUIDS_BY_VALUE.get(entity.getConfidentialType()));
	}

	public Boolean IsAutoChangeRequest(MRequestType entity, DataFetchingEnvironment environment) {
		return entity.isAutoChangeRequest();
	}

	public Boolean IsConfidentialInfo(MRequestType entity, DataFetchingEnvironment environment) {
		return entity.isConfidentialInfo();
	}

	public Boolean IsDefault(MRequestType entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsEMailWhenDue(MRequestType entity, DataFetchingEnvironment environment) {
		return entity.isEMailWhenDue();
	}

	public Boolean IsEMailWhenOverdue(MRequestType entity, DataFetchingEnvironment environment) {
		return entity.isEMailWhenOverdue();
	}

	public Boolean IsIndexed(MRequestType entity, DataFetchingEnvironment environment) {
		return entity.isIndexed();
	}

	public Boolean IsInvoiced(MRequestType entity, DataFetchingEnvironment environment) {
		return entity.isInvoiced();
	}

	public Boolean IsSelfService(MRequestType entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}


	/**
	 * Get Status Category.
	 *
	 * @return Request Status Category
	 */
	public CompletableFuture<MStatusCategory> R_StatusCategory(MRequestType entity, DataFetchingEnvironment environment) {
		if (entity.getR_StatusCategory_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MStatusCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_StatusCategoryDataLoader.DATALOADER_R_StatusCategory_BY_ID);
		return dataLoader.load(entity.getR_StatusCategory_ID());
	}

}
