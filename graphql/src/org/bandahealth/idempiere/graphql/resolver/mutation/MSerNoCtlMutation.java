package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;

public class MSerNoCtlMutation extends X_M_SerNoCtlMutation {

	public String M_SerNoCtlCreateSerNo(String UU, DataFetchingEnvironment environment) {
		return new MSerNoCtl_BH(BandaGraphQLContext.getCtx(environment), UU, null).createSerNo();
	}
}
