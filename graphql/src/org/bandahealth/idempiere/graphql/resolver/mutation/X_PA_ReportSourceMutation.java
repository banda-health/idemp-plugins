package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportSourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportSourceInput;
import org.compiere.report.MReportSource;

import java.util.List;

/**
 * Generated Query Resolver for PA_ReportSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_ReportSourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportSourceInput.Table_Name;
	}

	public MReportSource PA_ReportSourceSave(I_PA_ReportSourceInput input, DataFetchingEnvironment environment) {
		return (MReportSource) super.save((X_PA_ReportSourceInput) input, environment);
	}

	public boolean PA_ReportSourceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
