package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_TestInput;
import org.bandahealth.idempiere.graphql.model.input.X_TestInput;
import org.compiere.model.MTest;

import java.util.List;

/**
 * Generated Query Resolver for Test - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_TestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_TestInput.Table_Name;
	}

	public MTest TestSave(I_TestInput input, DataFetchingEnvironment environment) {
		return (MTest) super.save((X_TestInput) input, environment);
	}

	public boolean TestDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
