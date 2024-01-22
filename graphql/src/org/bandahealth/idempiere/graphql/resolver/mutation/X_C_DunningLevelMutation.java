package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_DunningLevelInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_DunningLevelInput;
import org.compiere.model.MDunningLevel;

import java.util.List;

/**
 * Generated Query Resolver for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningLevelMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_DunningLevelInput.Table_Name;
	}

	public MDunningLevel C_DunningLevelSave(I_C_DunningLevelInput input, DataFetchingEnvironment environment) {
		return (MDunningLevel) super.save((X_C_DunningLevelInput) input, environment);
	}

	public boolean C_DunningLevelDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
