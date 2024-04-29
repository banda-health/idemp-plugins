package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AllocationHdrInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AllocationHdrInput;
import org.compiere.model.MAllocationHdr;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AllocationHdr - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AllocationHdrMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AllocationHdrInput.Table_Name;
	}

	public MAllocationHdr C_AllocationHdrSave(I_C_AllocationHdrInput Entity, DataFetchingEnvironment environment) {
		return (MAllocationHdr) super.save((X_C_AllocationHdrInput) Entity, environment);
	}

	public List<MAllocationHdr> C_AllocationHdrSaveMany(List<I_C_AllocationHdrInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_AllocationHdrInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAllocationHdr) entity).collect(Collectors.toList());
	}

	public boolean C_AllocationHdrDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
