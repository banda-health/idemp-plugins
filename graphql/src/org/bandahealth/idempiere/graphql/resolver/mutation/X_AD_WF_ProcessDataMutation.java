package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_ProcessDataInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_ProcessDataInput;
import org.compiere.model.X_AD_WF_ProcessData;

import java.util.List;

/**
 * Generated Query Resolver for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ProcessDataMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_ProcessDataInput.Table_Name;
	}

	public X_AD_WF_ProcessData AD_WF_ProcessDataSave(I_AD_WF_ProcessDataInput input, DataFetchingEnvironment environment) {
		return (X_AD_WF_ProcessData) super.save((X_AD_WF_ProcessDataInput) input, environment);
	}

	public boolean AD_WF_ProcessDataDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
