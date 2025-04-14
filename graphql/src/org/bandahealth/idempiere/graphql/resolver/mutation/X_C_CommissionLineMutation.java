package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CommissionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CommissionLineInput;
import org.compiere.model.MCommissionLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_CommissionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CommissionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CommissionLineInput.Table_Name;
	}

	public MCommissionLine C_CommissionLineSave(I_C_CommissionLineInput Entity, DataFetchingEnvironment environment) {
		return (MCommissionLine) super.save((X_C_CommissionLineInput) Entity, environment);
	}

	public List<MCommissionLine> C_CommissionLineSaveMany(List<I_C_CommissionLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_CommissionLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCommissionLine) entity).collect(Collectors.toList());
	}

	public boolean C_CommissionLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
