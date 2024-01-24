package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.compiere.model.MHouseKeeping;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_HouseKeeping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_HouseKeepingResolver extends POResolver<MHouseKeeping> implements GraphQLResolver<MHouseKeeping> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MHouseKeeping entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean IsExportXMLBackup(MHouseKeeping entity, DataFetchingEnvironment environment) {
		return entity.isExportXMLBackup();
	}

	public Boolean IsSaveInHistoric(MHouseKeeping entity, DataFetchingEnvironment environment) {
		return entity.isSaveInHistoric();
	}

	public Boolean Processing(MHouseKeeping entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
