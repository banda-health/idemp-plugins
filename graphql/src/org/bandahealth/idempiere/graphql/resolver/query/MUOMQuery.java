package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.compiere.model.MUOM;

public class MUOMQuery extends X_C_UOMQuery {
	public MUOM C_UOMGetDefault(DataFetchingEnvironment environment) {
		return MUOM.get(BandaGraphQLContext.getCtx(environment),
				MUOM.getDefault_UOM_ID(BandaGraphQLContext.getCtx(environment)));
	}
}
