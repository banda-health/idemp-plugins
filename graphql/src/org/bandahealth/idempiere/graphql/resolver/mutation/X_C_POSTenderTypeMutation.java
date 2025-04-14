package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_POSTenderTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_POSTenderTypeInput;
import org.compiere.model.X_C_POSTenderType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_POSTenderType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_POSTenderTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_POSTenderTypeInput.Table_Name;
	}

	public X_C_POSTenderType C_POSTenderTypeSave(I_C_POSTenderTypeInput Entity, DataFetchingEnvironment environment) {
		return (X_C_POSTenderType) super.save((X_C_POSTenderTypeInput) Entity, environment);
	}

	public List<X_C_POSTenderType> C_POSTenderTypeSaveMany(List<I_C_POSTenderTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_POSTenderTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_POSTenderType) entity).collect(Collectors.toList());
	}

	public boolean C_POSTenderTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
