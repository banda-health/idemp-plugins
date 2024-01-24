package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReportView_ColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReportView_ColumnInput;
import org.compiere.model.X_AD_ReportView_Column;

import java.util.List;

/**
 * Generated Query Resolver for AD_ReportView_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReportView_ColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReportView_ColumnInput.Table_Name;
	}

	public X_AD_ReportView_Column AD_ReportView_ColumnSave(I_AD_ReportView_ColumnInput input, DataFetchingEnvironment environment) {
		return (X_AD_ReportView_Column) super.save((X_AD_ReportView_ColumnInput) input, environment);
	}

	public boolean AD_ReportView_ColumnDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
