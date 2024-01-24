package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ListVersionInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ListVersionInput;
import org.eevolution.model.X_HR_ListVersion;

import java.util.List;

/**
 * Generated Query Resolver for HR_ListVersion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_ListVersionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListVersionInput.Table_Name;
	}

	public X_HR_ListVersion HR_ListVersionSave(I_HR_ListVersionInput input, DataFetchingEnvironment environment) {
		return (X_HR_ListVersion) super.save((X_HR_ListVersionInput) input, environment);
	}

	public boolean HR_ListVersionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
