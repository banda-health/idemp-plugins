package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LotCtlDataLoader;
import org.compiere.model.MLotCtl;
import org.compiere.model.X_M_LotCtlExclude;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LotCtlExcludeResolver extends POResolver<X_M_LotCtlExclude> implements GraphQLResolver<X_M_LotCtlExclude> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable_BH> AD_Table(X_M_LotCtlExclude entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean IsSOTrx(X_M_LotCtlExclude entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}


	/**
	 * Get Lot Control.
	 *
	 * @return Product Lot Control
	 */
	public CompletableFuture<MLotCtl> M_LotCtl(X_M_LotCtlExclude entity, DataFetchingEnvironment environment) {
		if (entity.getM_LotCtl_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLotCtl> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LotCtlDataLoader.DATALOADER_M_LotCtl_BY_ID);
		return dataLoader.load(entity.getM_LotCtl_ID());
	}

}
