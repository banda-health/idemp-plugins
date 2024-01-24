package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_1099BoxInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_1099BoxInput;
import org.compiere.model.X_C_1099Box;

import java.util.List;

/**
 * Generated Query Resolver for C_1099Box - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_1099BoxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_1099BoxInput.Table_Name;
	}

	public X_C_1099Box C_1099BoxSave(I_C_1099BoxInput input, DataFetchingEnvironment environment) {
		return (X_C_1099Box) super.save((X_C_1099BoxInput) input, environment);
	}

	public boolean C_1099BoxDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
