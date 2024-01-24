package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ReportColumnSetInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ReportColumnSetInput;
import org.compiere.model.X_PA_ReportColumnSet;

import java.util.List;

/**
 * Generated Query Resolver for PA_ReportColumnSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportColumnSetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ReportColumnSetInput.Table_Name;
	}

	public X_PA_ReportColumnSet PA_ReportColumnSetSave(I_PA_ReportColumnSetInput input, DataFetchingEnvironment environment) {
		return (X_PA_ReportColumnSet) super.save((X_PA_ReportColumnSetInput) input, environment);
	}

	public boolean PA_ReportColumnSetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
