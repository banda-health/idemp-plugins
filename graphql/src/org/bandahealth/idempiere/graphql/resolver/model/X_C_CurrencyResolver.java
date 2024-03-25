package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Currency_TrlDataLoader;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Currency - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CurrencyResolver extends POResolver<MCurrency_BH> implements GraphQLResolver<MCurrency_BH> {


	/**
	 * Get Symbol.
	 *
	 * @return Symbol of the currency (opt used for printing only)
	 */
	public CompletableFuture<String> CurSymbol(MCurrency_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getCurSymbol);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Currency_TrlDataLoader.DATALOADER_C_Currency_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MCurrency_BH.COLUMNNAME_CurSymbol));
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MCurrency_BH entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Currency_TrlDataLoader.DATALOADER_C_Currency_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MCurrency_BH.COLUMNNAME_Description));
	}

	public Boolean IsEMUMember(MCurrency_BH entity, DataFetchingEnvironment environment) {
		return entity.isEMUMember();
	}

	public Boolean IsEuro(MCurrency_BH entity, DataFetchingEnvironment environment) {
		return entity.isEuro();
	}

}
