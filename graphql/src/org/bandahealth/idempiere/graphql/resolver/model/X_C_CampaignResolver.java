package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Campaign_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChannelDataLoader;
import org.compiere.model.MCampaign;
import org.compiere.model.PO;
import org.compiere.model.X_C_Channel;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Campaign - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CampaignResolver extends POResolver<MCampaign> implements GraphQLResolver<MCampaign> {



	/**
	 * Get Channel.
	 *
	 * @return Sales Channel
	 */
	public CompletableFuture<X_C_Channel> C_Channel(MCampaign entity, DataFetchingEnvironment environment) {
		if (entity.getC_Channel_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_C_Channel> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChannelDataLoader.C_Channel_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Channel_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MCampaign entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Campaign_TrlDataLoader.C_Campaign_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MCampaign.COLUMNNAME_Description));
	}

	public Boolean IsSummary(MCampaign entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MCampaign entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Campaign_TrlDataLoader.C_Campaign_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MCampaign.COLUMNNAME_Name));
	}

}
