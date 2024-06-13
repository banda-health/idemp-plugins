package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LotCtlDataLoader;
import org.compiere.model.MLotCtl;
import org.compiere.model.MLotCtlExclude;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_LotCtlExcludeResolver extends POResolver<MLotCtlExclude> implements GraphQLResolver<MLotCtlExclude> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MLotCtlExclude entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean IsSOTrx(MLotCtlExclude entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}


	/**
	 * Get Lot Control.
	 *
	 * @return Product Lot Control
	 */
	public CompletableFuture<MLotCtl> M_LotCtl(MLotCtlExclude entity, DataFetchingEnvironment environment) {
		if (entity.getM_LotCtl_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MLotCtl> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LotCtlDataLoader.DATALOADER_M_LotCtl_BY_ID);
		return dataLoader.load(entity.getM_LotCtl_ID());
	}

}
