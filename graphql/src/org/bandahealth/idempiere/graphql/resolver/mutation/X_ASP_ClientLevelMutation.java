package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_ClientLevelInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_ClientLevelInput;
import org.compiere.model.X_ASP_ClientLevel;

import java.util.List;

/**
 * Generated Query Resolver for ASP_ClientLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_ClientLevelMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_ClientLevelInput.Table_Name;
	}

	public X_ASP_ClientLevel ASP_ClientLevelSave(I_ASP_ClientLevelInput input, DataFetchingEnvironment environment) {
		return (X_ASP_ClientLevel) super.save((X_ASP_ClientLevelInput) input, environment);
	}

	public boolean ASP_ClientLevelDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
