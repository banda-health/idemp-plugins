package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.X_C_SalesStage;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_SalesStage - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SalesStageResolver extends POResolver<X_C_SalesStage> implements GraphQLResolver<X_C_SalesStage> {


	public Boolean IsClosed(X_C_SalesStage entity, DataFetchingEnvironment environment) {
		return entity.isClosed();
	}

	public Boolean IsWon(X_C_SalesStage entity, DataFetchingEnvironment environment) {
		return entity.isWon();
	}

}
