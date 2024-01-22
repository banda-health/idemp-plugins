package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_BOMAlternativeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_BOMAlternativeInput;
import org.compiere.model.X_M_BOMAlternative;

import java.util.List;

/**
 * Generated Query Resolver for M_BOMAlternative - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_BOMAlternativeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_BOMAlternativeInput.Table_Name;
	}

	public X_M_BOMAlternative M_BOMAlternativeSave(I_M_BOMAlternativeInput input, DataFetchingEnvironment environment) {
		return (X_M_BOMAlternative) super.save((X_M_BOMAlternativeInput) input, environment);
	}

	public boolean M_BOMAlternativeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
