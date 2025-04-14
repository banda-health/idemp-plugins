package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSInput;
import org.compiere.model.MPOS;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_POS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_POSMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSInput.Table_Name;
	}

	public MPOS C_POSSave(I_C_POSInput Entity, DataFetchingEnvironment environment) {
		return (MPOS) super.save((X_C_POSInput) Entity, environment);
	}

	public List<MPOS> C_POSSaveMany(List<I_C_POSInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_POSInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPOS) entity).collect(Collectors.toList());
	}

	public boolean C_POSDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
