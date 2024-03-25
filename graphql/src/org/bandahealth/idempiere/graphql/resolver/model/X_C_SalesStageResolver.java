package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesStage_TrlDataLoader;
import org.compiere.model.PO;
import org.compiere.model.X_C_SalesStage;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_SalesStage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_SalesStageResolver extends POResolver<X_C_SalesStage> implements GraphQLResolver<X_C_SalesStage> {


	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(X_C_SalesStage entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_SalesStage_TrlDataLoader.DATALOADER_C_SalesStage_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_C_SalesStage.COLUMNNAME_Description));
	}

	public Boolean IsClosed(X_C_SalesStage entity, DataFetchingEnvironment environment) {
		return entity.isClosed();
	}

	public Boolean IsWon(X_C_SalesStage entity, DataFetchingEnvironment environment) {
		return entity.isWon();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(X_C_SalesStage entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_SalesStage_TrlDataLoader.DATALOADER_C_SalesStage_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_C_SalesStage.COLUMNNAME_Name));
	}

}
