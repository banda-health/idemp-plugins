package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AllocationHdrInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AllocationHdrInput;
import org.compiere.model.MAllocationHdr;

import java.util.List;

/**
 * Generated Query Resolver for C_AllocationHdr - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AllocationHdrMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AllocationHdrInput.Table_Name;
	}

	public MAllocationHdr C_AllocationHdrSave(I_C_AllocationHdrInput input, DataFetchingEnvironment environment) {
		return (MAllocationHdr) super.save((X_C_AllocationHdrInput) input, environment);
	}

	public boolean C_AllocationHdrDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
