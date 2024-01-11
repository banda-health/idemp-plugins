package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AlertInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AlertInput;
import org.compiere.model.MAlert;

import java.util.List;

/**
 * Generated Query Resolver for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AlertInput.Table_Name;
	}

	public MAlert AD_AlertSave(I_AD_AlertInput input, DataFetchingEnvironment environment) {
		return (MAlert) super.save((X_AD_AlertInput) input, environment);
	}

	public boolean AD_AlertDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
