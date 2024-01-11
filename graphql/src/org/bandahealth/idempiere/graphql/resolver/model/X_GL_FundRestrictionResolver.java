package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_FundDataLoader;
import org.compiere.model.MElementValue;
import org.compiere.model.X_GL_Fund;
import org.compiere.model.X_GL_FundRestriction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for GL_FundRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_FundRestrictionResolver extends POResolver<X_GL_FundRestriction> implements GraphQLResolver<X_GL_FundRestriction> {



	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public CompletableFuture<MElementValue> C_ElementValue(X_GL_FundRestriction entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValue_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.C_ElementValue_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_ElementValue_ID());
	}


	/**
	 * Get GL Fund.
	 *
	 * @return General Ledger Funds Control
	 */
	public CompletableFuture<X_GL_Fund> GL_Fund(X_GL_FundRestriction entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Fund_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_GL_Fund> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_FundDataLoader.GL_Fund_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getGL_Fund_ID());
	}

}
