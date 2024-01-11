package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColor_TrlDataLoader;
import org.compiere.model.PO;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintColor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintColorResolver extends POResolver<X_AD_PrintColor> implements GraphQLResolver<X_AD_PrintColor> {


	public Boolean IsDefault(X_AD_PrintColor entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(X_AD_PrintColor entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintColor_TrlDataLoader.AD_PrintColor_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(X_AD_PrintColor.COLUMNNAME_Name));
	}

}
