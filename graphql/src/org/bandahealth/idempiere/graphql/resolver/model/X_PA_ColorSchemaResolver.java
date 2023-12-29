package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.compiere.model.MColorSchema;
import org.compiere.model.MEntityType;
import org.compiere.model.X_AD_PrintColor;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ColorSchemaResolver extends POResolver<MColorSchema> implements GraphQLResolver<MColorSchema> {



	/**
	 * Get Color 1.
	 *
	 * @return First color used
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor1(MColorSchema entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor1_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintColor1_ID());
	}


	/**
	 * Get Color 2.
	 *
	 * @return Second color used
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor2(MColorSchema entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor2_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintColor2_ID());
	}


	/**
	 * Get Color 3.
	 *
	 * @return Third color used
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor3(MColorSchema entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor3_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintColor3_ID());
	}


	/**
	 * Get Color 4.
	 *
	 * @return Forth color used
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor4(MColorSchema entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor4_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintColor4_ID());
	}


	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MColorSchema entity, DataFetchingEnvironment environment) {
		if (entity.getEntityType() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.AD_EntityType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getEntityType());
	}

}
