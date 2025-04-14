package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MTable;
import org.compiere.model.MTableAccess;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Table_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Table_AccessResolver extends POResolver<MTableAccess> implements GraphQLResolver<MTableAccess> {


	public static Map<String, String> ACCESSTYPERULE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "e0f06392-7622-471b-95e6-11b222030fa3"); // Accessing
			put("R", "5d787615-4084-4740-9030-be3ff730b2d0"); // Reporting
			put("E", "dfbce347-aa5e-460c-bfbb-6c21892ee396"); // Exporting
		}
	};
	public CompletableFuture<MRefList_BH> AccessTypeRule(MTableAccess entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccessTypeRule())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACCESSTYPERULE_UUIDS_BY_VALUE.get(entity.getAccessTypeRule()));
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MTableAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MTableAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean IsExclude(MTableAccess entity, DataFetchingEnvironment environment) {
		return entity.isExclude();
	}

	public Boolean IsReadOnly(MTableAccess entity, DataFetchingEnvironment environment) {
		return entity.isReadOnly();
	}

}
