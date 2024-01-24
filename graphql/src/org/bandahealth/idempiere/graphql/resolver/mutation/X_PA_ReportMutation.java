package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportInput;
import org.compiere.model.X_PA_Report;

import java.util.List;

/**
 * Generated Query Resolver for PA_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportInput.Table_Name;
	}

	public X_PA_Report PA_ReportSave(I_PA_ReportInput input, DataFetchingEnvironment environment) {
		return (X_PA_Report) super.save((X_PA_ReportInput) input, environment);
	}

	public boolean PA_ReportDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
