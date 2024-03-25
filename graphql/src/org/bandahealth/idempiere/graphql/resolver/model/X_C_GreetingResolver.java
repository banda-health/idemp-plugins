package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Greeting_TrlDataLoader;
import org.compiere.model.PO;
import org.compiere.model.X_C_Greeting;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Greeting - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_GreetingResolver extends POResolver<X_C_Greeting> implements GraphQLResolver<X_C_Greeting> {


	/**
	 * Get Greeting.
	 *
	 * @return For letters, e.g. "Dear {0}" or "Dear Mr. {0}" - At runtime, "{0}" is replaced by the name
	 */
	public CompletableFuture<String> Greeting(X_C_Greeting entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getGreeting);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Greeting_TrlDataLoader.DATALOADER_C_Greeting_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_C_Greeting.COLUMNNAME_Greeting));
	}

	public Boolean IsDefault(X_C_Greeting entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsFirstNameOnly(X_C_Greeting entity, DataFetchingEnvironment environment) {
		return entity.isFirstNameOnly();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(X_C_Greeting entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Greeting_TrlDataLoader.DATALOADER_C_Greeting_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_C_Greeting.COLUMNNAME_Name));
	}

}
