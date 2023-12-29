package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_CashPlanLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_CashPlanLineInput;
import org.compiere.model.MCashPlanLine;

import java.util.List;

/**
 * Generated Query Resolver for C_CashPlanLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashPlanLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_CashPlanLineInput.Table_Name;
	}

	public MCashPlanLine C_CashPlanLineSave(I_C_CashPlanLineInput input, DataFetchingEnvironment environment) {
		return (MCashPlanLine) super.save((X_C_CashPlanLineInput) input, environment);
	}

	public boolean C_CashPlanLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
