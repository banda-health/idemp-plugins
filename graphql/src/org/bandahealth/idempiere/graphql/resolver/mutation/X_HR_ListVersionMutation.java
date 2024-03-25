package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_ListVersionInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_ListVersionInput;
import org.eevolution.model.X_HR_ListVersion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for HR_ListVersion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListVersionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListVersionInput.Table_Name;
	}

	public X_HR_ListVersion HR_ListVersionSave(I_HR_ListVersionInput entity, DataFetchingEnvironment environment) {
		return (X_HR_ListVersion) super.save((X_HR_ListVersionInput) entity, environment);
	}

	public List<X_HR_ListVersion> HR_ListVersionSaveMany(List<I_HR_ListVersionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_HR_ListVersionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_ListVersion) entity).collect(Collectors.toList());
	}

	public boolean HR_ListVersionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
