package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPInstance;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_PInstance_Log;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PInstance_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PInstance_LogResolver extends POResolver<X_AD_PInstance_Log> implements GraphQLResolver<X_AD_PInstance_Log> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_AD_PInstance_Log entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_PInstance_Log entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	static Map<String, String> PINSTANCELOGTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "c168a678-1b2b-4fe2-9270-8aeb29b635c3");
			put("P", "2cc965b7-abf2-413a-930e-eff43afd5f81");
			put("R", "aadce9f4-214c-4c52-b89d-d2696649172b");
		}
	};
	public CompletableFuture<MRefList_BH> PInstanceLogType(X_AD_PInstance_Log entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPInstanceLogType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PINSTANCELOGTYPE_UUIDS_BY_VALUE.get(entity.getPInstanceLogType()));
	}

}
