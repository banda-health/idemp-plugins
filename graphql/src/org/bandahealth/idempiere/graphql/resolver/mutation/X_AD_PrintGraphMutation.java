package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintGraphInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintGraphInput;
import org.compiere.model.X_AD_PrintGraph;

import java.util.List;

/**
 * Generated Query Resolver for AD_PrintGraph - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintGraphMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintGraphInput.Table_Name;
	}

	public X_AD_PrintGraph AD_PrintGraphSave(I_AD_PrintGraphInput input, DataFetchingEnvironment environment) {
		return (X_AD_PrintGraph) super.save((X_AD_PrintGraphInput) input, environment);
	}

	public boolean AD_PrintGraphDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
