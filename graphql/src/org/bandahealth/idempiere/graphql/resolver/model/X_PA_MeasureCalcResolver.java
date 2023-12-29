package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.compiere.model.MEntityType;
import org.compiere.model.MMeasureCalc;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_MeasureCalc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_MeasureCalcResolver extends POResolver<MMeasureCalc> implements GraphQLResolver<MMeasureCalc> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MMeasureCalc entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MMeasureCalc entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

}
