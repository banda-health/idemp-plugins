package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_SerNoCtlDataLoader;
import org.compiere.model.MSerNoCtlExclude;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_SerNoCtlExcludeResolver extends POResolver<MSerNoCtlExclude> implements GraphQLResolver<MSerNoCtlExclude> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MSerNoCtlExclude entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean IsSOTrx(MSerNoCtlExclude entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}


	/**
	 * Get Serial No Control.
	 *
	 * @return Product Serial Number Control
	 */
	public CompletableFuture<MSerNoCtl_BH> M_SerNoCtl(MSerNoCtlExclude entity, DataFetchingEnvironment environment) {
		if (entity.getM_SerNoCtl_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MSerNoCtl_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_SerNoCtlDataLoader.DATALOADER_M_SerNoCtl_BY_ID);
		return dataLoader.load(entity.getM_SerNoCtl_ID());
	}

}
