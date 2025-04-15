package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AllocationLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AllocationLineInput;
import org.compiere.model.MAllocationLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AllocationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AllocationLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AllocationLineInput.Table_Name;
	}

	public MAllocationLine C_AllocationLineSave(I_C_AllocationLineInput Entity, DataFetchingEnvironment environment) {
		return (MAllocationLine) super.save((X_C_AllocationLineInput) Entity, environment);
	}

	public List<MAllocationLine> C_AllocationLineSaveMany(List<I_C_AllocationLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_AllocationLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAllocationLine) entity).collect(Collectors.toList());
	}

	public boolean C_AllocationLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
