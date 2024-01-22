package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ProjectLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ProjectLineInput;
import org.compiere.model.MProjectLine;

import java.util.List;

/**
 * Generated Query Resolver for C_ProjectLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ProjectLineInput.Table_Name;
	}

	public MProjectLine C_ProjectLineSave(I_C_ProjectLineInput input, DataFetchingEnvironment environment) {
		return (MProjectLine) super.save((X_C_ProjectLineInput) input, environment);
	}

	public boolean C_ProjectLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
