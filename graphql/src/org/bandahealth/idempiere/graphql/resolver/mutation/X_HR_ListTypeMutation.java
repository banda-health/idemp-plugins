package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ListTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ListTypeInput;
import org.eevolution.model.X_HR_ListType;

import java.util.List;

/**
 * Generated Query Resolver for HR_ListType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListTypeInput.Table_Name;
	}

	public X_HR_ListType HR_ListTypeSave(I_HR_ListTypeInput input, DataFetchingEnvironment environment) {
		return (X_HR_ListType) super.save((X_HR_ListTypeInput) input, environment);
	}

	public boolean HR_ListTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
