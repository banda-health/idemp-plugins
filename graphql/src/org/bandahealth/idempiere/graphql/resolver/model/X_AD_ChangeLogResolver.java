package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ChangeLogDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SessionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MChangeLog;
import org.compiere.model.MColumn;
import org.compiere.model.MSession;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_ChangeLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ChangeLogResolver extends POResolver<MChangeLog> implements GraphQLResolver<MChangeLog> {



	/**
	 * Get Change Log.
	 *
	 * @return Log of data changes
	 */
	public CompletableFuture<MChangeLog> AD_ChangeLog(MChangeLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ChangeLog_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChangeLog> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ChangeLogDataLoader.DATALOADER_AD_ChangeLog_BY_ID);
		return dataLoader.load(entity.getAD_ChangeLog_ID());
	}


	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(MChangeLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Session.
	 *
	 * @return User Session Online or Web
	 */
	public CompletableFuture<MSession> AD_Session(MChangeLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Session_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSession> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SessionDataLoader.DATALOADER_AD_Session_BY_ID);
		return dataLoader.load(entity.getAD_Session_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MChangeLog entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	static Map<String, String> EVENTCHANGELOG_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "7bf66e6f-3037-4085-85a8-ab787a14083b");
			put("D", "8e18b7c8-bb4c-45b4-be70-805050354079");
			put("U", "998022c1-9cdb-48e6-bb4e-7f06563ea5e0");
		}
	};
	public CompletableFuture<MRefList_BH> EventChangeLog(MChangeLog entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEventChangeLog())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(EVENTCHANGELOG_UUIDS_BY_VALUE.get(entity.getEventChangeLog()));
	}

	public Boolean IsCustomization(MChangeLog entity, DataFetchingEnvironment environment) {
		return entity.isCustomization();
	}

}
