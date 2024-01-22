package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AllocationLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AllocationLineInput;
import org.compiere.model.MAllocationLine;

import java.util.List;

/**
 * Generated Query Resolver for C_AllocationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AllocationLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AllocationLineInput.Table_Name;
	}

	public MAllocationLine C_AllocationLineSave(I_C_AllocationLineInput input, DataFetchingEnvironment environment) {
		return (MAllocationLine) super.save((X_C_AllocationLineInput) input, environment);
	}

	public boolean C_AllocationLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
