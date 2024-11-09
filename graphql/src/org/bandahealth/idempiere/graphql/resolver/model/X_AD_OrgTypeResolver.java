package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.compiere.model.X_AD_OrgType;
import org.compiere.model.X_AD_PrintColor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_OrgType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_OrgTypeResolver extends POResolver<X_AD_OrgType> implements GraphQLResolver<X_AD_OrgType> {



	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(X_AD_OrgType entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.DATALOADER_AD_PrintColor_BY_ID);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}

}
