package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MClientShare;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ClientShare - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientShareResolver extends POResolver<MClientShare> implements GraphQLResolver<MClientShare> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MClientShare entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	static Map<String, String> SHARETYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "94999ff0-5a0b-4f23-974e-d6def024337c");
			put("O", "a4b14df4-df8d-498e-ae56-e27ddce00d0d");
			put("x", "de29f581-c452-42b2-a8d7-56ed54267b58");
		}
	};
	public CompletableFuture<MRefList_BH> ShareType(MClientShare entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getShareType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SHARETYPE_UUIDS_BY_VALUE.get(entity.getShareType()));
	}

}
