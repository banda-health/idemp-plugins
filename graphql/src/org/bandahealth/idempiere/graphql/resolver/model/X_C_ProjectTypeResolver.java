package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MProjectType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_ProjectType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectTypeResolver extends POResolver<MProjectType> implements GraphQLResolver<MProjectType> {


	static Map<String, String> PROJECTCATEGORY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "0ee15c1f-fd85-4277-a4ba-5019cfefa415");
			put("A", "8325d87d-5eb8-482e-803d-215889471ef5");
			put("W", "7e8413bf-2c7a-4ecd-b00e-684ef95ff4eb");
			put("S", "8a6796ad-4e16-412c-a34b-0e92bf6f5e00");
		}
	};
	public CompletableFuture<MRefList_BH> ProjectCategory(MProjectType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getProjectCategory())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PROJECTCATEGORY_UUIDS_BY_VALUE.get(entity.getProjectCategory()));
	}

}
