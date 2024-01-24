package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_R_ResolutionInput;
import org.bandahealth.idempiere.graphql.model.input.X_R_ResolutionInput;
import org.compiere.model.MResolution;

import java.util.List;

/**
 * Generated Query Resolver for R_Resolution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_ResolutionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_R_ResolutionInput.Table_Name;
	}

	public MResolution R_ResolutionSave(I_R_ResolutionInput input, DataFetchingEnvironment environment) {
		return (MResolution) super.save((X_R_ResolutionInput) input, environment);
	}

	public boolean R_ResolutionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
