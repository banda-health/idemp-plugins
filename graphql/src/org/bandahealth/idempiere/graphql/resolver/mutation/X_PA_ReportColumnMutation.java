package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportColumnInput;
import org.compiere.model.X_PA_ReportColumn;

import java.util.List;

/**
 * Generated Query Resolver for PA_ReportColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportColumnInput.Table_Name;
	}

	public X_PA_ReportColumn PA_ReportColumnSave(I_PA_ReportColumnInput input, DataFetchingEnvironment environment) {
		return (X_PA_ReportColumn) super.save((X_PA_ReportColumnInput) input, environment);
	}

	public boolean PA_ReportColumnDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
