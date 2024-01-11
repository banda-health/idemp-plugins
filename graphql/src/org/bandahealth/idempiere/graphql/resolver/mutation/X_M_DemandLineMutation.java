package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DemandLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DemandLineInput;
import org.compiere.model.X_M_DemandLine;

import java.util.List;

/**
 * Generated Query Resolver for M_DemandLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DemandLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DemandLineInput.Table_Name;
	}

	public X_M_DemandLine M_DemandLineSave(I_M_DemandLineInput input, DataFetchingEnvironment environment) {
		return (X_M_DemandLine) super.save((X_M_DemandLineInput) input, environment);
	}

	public boolean M_DemandLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
