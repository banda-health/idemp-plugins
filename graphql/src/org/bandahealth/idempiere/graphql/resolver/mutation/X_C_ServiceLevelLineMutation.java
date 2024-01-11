package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ServiceLevelLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ServiceLevelLineInput;
import org.compiere.model.X_C_ServiceLevelLine;

import java.util.List;

/**
 * Generated Query Resolver for C_ServiceLevelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ServiceLevelLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ServiceLevelLineInput.Table_Name;
	}

	public X_C_ServiceLevelLine C_ServiceLevelLineSave(I_C_ServiceLevelLineInput input, DataFetchingEnvironment environment) {
		return (X_C_ServiceLevelLine) super.save((X_C_ServiceLevelLineInput) input, environment);
	}

	public boolean C_ServiceLevelLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
