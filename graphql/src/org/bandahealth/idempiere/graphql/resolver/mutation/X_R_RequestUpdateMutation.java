package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_RequestUpdateInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_RequestUpdateInput;
import org.compiere.model.MRequestUpdate;

import java.util.List;

/**
 * Generated Query Resolver for R_RequestUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestUpdateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestUpdateInput.Table_Name;
	}

	public MRequestUpdate R_RequestUpdateSave(I_R_RequestUpdateInput input, DataFetchingEnvironment environment) {
		return (MRequestUpdate) super.save((X_R_RequestUpdateInput) input, environment);
	}

	public boolean R_RequestUpdateDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
