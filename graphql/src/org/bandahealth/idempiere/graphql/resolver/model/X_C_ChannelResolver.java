package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_C_Channel;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Channel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChannelResolver extends POResolver<X_C_Channel> implements GraphQLResolver<X_C_Channel> {



	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(X_C_Channel entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}

}
