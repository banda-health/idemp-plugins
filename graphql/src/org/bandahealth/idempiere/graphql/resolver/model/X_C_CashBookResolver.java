package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.compiere.model.MCashBook;
import org.compiere.model.MCurrency;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_CashBook - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashBookResolver extends POResolver<MCashBook> implements GraphQLResolver<MCashBook> {



	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency> C_Currency(MCashBook entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.C_Currency_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Currency_ID());
	}

}
