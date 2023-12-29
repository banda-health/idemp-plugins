package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSKeyLayoutInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSKeyLayoutInput;
import org.compiere.model.MPOSKeyLayout;

import java.util.List;

/**
 * Generated Query Resolver for C_POSKeyLayout - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSKeyLayoutMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSKeyLayoutInput.Table_Name;
	}

	public MPOSKeyLayout C_POSKeyLayoutSave(I_C_POSKeyLayoutInput input, DataFetchingEnvironment environment) {
		return (MPOSKeyLayout) super.save((X_C_POSKeyLayoutInput) input, environment);
	}

	public boolean C_POSKeyLayoutDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
