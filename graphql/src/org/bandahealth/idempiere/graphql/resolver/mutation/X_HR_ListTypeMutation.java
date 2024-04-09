package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ListTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ListTypeInput;
import org.eevolution.model.X_HR_ListType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_ListType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListTypeInput.Table_Name;
	}

	public X_HR_ListType HR_ListTypeSave(I_HR_ListTypeInput Entity, DataFetchingEnvironment environment) {
		return (X_HR_ListType) super.save((X_HR_ListTypeInput) Entity, environment);
	}

	public List<X_HR_ListType> HR_ListTypeSaveMany(List<I_HR_ListTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_HR_ListTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_ListType) entity).collect(Collectors.toList());
	}

	public boolean HR_ListTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
