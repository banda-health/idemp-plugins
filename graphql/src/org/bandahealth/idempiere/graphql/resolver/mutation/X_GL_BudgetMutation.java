package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_BudgetInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_BudgetInput;
import org.compiere.model.X_GL_Budget;

import java.util.List;

/**
 * Generated Query Resolver for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_BudgetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_BudgetInput.Table_Name;
	}

	public X_GL_Budget GL_BudgetSave(I_GL_BudgetInput input, DataFetchingEnvironment environment) {
		return (X_GL_Budget) super.save((X_GL_BudgetInput) input, environment);
	}

	public boolean GL_BudgetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
