package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MUserPreference;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserPreferenceResolver extends POResolver<MUserPreference> implements GraphQLResolver<MUserPreference> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MUserPreference entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean AutoCommit(MUserPreference entity, DataFetchingEnvironment environment) {
		return entity.isAutoCommit();
	}

	public Boolean AutoNew(MUserPreference entity, DataFetchingEnvironment environment) {
		return entity.isAutoNew();
	}

	public Boolean IsDetailedZoomAcross(MUserPreference entity, DataFetchingEnvironment environment) {
		return entity.isDetailedZoomAcross();
	}

	public Boolean IsUseSimilarTo(MUserPreference entity, DataFetchingEnvironment environment) {
		return entity.isUseSimilarTo();
	}

	public Boolean ToggleOnDoubleClick(MUserPreference entity, DataFetchingEnvironment environment) {
		return entity.isToggleOnDoubleClick();
	}

	static Map<String, String> VIEWFINDRESULT_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("0", "f4ec3670-1ae8-4442-afb3-c74d2df7a06e");
			put("1", "ca0109d2-766d-4123-832c-f614c8c52ef2");
			put("2", "a81e98ac-ddae-410c-8a20-d447ceed5486");
		}
	};
	public CompletableFuture<MRefList_BH> ViewFindResult(MUserPreference entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getViewFindResult())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(VIEWFINDRESULT_UUIDS_BY_VALUE.get(entity.getViewFindResult()));
	}

}
