package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChatType;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatTypeResolver extends POResolver<MChatType> implements GraphQLResolver<MChatType> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable_BH> AD_Table(MChatType entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	static Map<String, String> MODERATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "09318ba5-7fc0-4f9c-9470-4df2fbe8fb8d");
			put("B", "e6f0ed41-923b-46a7-ad1c-962173583ac4");
			put("A", "16fa5956-4594-4cfc-a406-7d76d60c8876");
		}
	};
	public CompletableFuture<MRefList_BH> ModerationType(MChatType entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getModerationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MODERATIONTYPE_UUIDS_BY_VALUE.get(entity.getModerationType()));
	}

}
