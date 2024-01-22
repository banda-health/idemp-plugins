package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PP_MRPInput;
import org.bandahealth.idempiere.graphql.model.input.X_PP_MRPInput;
import org.eevolution.model.X_PP_MRP;

import java.util.List;

/**
 * Generated Query Resolver for PP_MRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_MRPMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PP_MRPInput.Table_Name;
	}

	public X_PP_MRP PP_MRPSave(I_PP_MRPInput input, DataFetchingEnvironment environment) {
		return (X_PP_MRP) super.save((X_PP_MRPInput) input, environment);
	}

	public boolean PP_MRPDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
