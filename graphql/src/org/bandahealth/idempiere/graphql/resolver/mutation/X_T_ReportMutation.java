package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_ReportInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_ReportInput;
import org.compiere.model.X_T_Report;

import java.util.List;

/**
 * Generated Query Resolver for T_Report - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_ReportMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_ReportInput.Table_Name;
	}

	public X_T_Report T_ReportSave(I_T_ReportInput input, DataFetchingEnvironment environment) {
		return (X_T_Report) super.save((X_T_ReportInput) input, environment);
	}

	public boolean T_ReportDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
