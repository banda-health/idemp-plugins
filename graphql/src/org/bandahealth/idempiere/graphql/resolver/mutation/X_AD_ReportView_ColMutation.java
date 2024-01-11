package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReportView_ColInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReportView_ColInput;
import org.compiere.model.X_AD_ReportView_Col;

import java.util.List;

/**
 * Generated Query Resolver for AD_ReportView_Col - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReportView_ColMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReportView_ColInput.Table_Name;
	}

	public X_AD_ReportView_Col AD_ReportView_ColSave(I_AD_ReportView_ColInput input, DataFetchingEnvironment environment) {
		return (X_AD_ReportView_Col) super.save((X_AD_ReportView_ColInput) input, environment);
	}

	public boolean AD_ReportView_ColDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
