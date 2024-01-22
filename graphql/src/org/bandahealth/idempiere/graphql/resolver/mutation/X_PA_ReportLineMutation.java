package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReportLine_BH;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportLineInput;

import java.util.List;

/**
 * Generated Query Resolver for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_ReportLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportLineInput.Table_Name;
	}

	public MReportLine_BH PA_ReportLineSave(I_PA_ReportLineInput input, DataFetchingEnvironment environment) {
		return (MReportLine_BH) super.save((X_PA_ReportLineInput) input, environment);
	}

	public boolean PA_ReportLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
