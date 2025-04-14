package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DocTypeCounterInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DocTypeCounterInput;
import org.compiere.model.MDocTypeCounter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_DocTypeCounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_DocTypeCounterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DocTypeCounterInput.Table_Name;
	}

	public MDocTypeCounter C_DocTypeCounterSave(I_C_DocTypeCounterInput Entity, DataFetchingEnvironment environment) {
		return (MDocTypeCounter) super.save((X_C_DocTypeCounterInput) Entity, environment);
	}

	public List<MDocTypeCounter> C_DocTypeCounterSaveMany(List<I_C_DocTypeCounterInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_DocTypeCounterInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDocTypeCounter) entity).collect(Collectors.toList());
	}

	public boolean C_DocTypeCounterDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
