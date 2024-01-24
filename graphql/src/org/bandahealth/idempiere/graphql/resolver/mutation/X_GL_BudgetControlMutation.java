package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_BudgetControlInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_BudgetControlInput;
import org.compiere.model.X_GL_BudgetControl;

import java.util.List;

/**
 * Generated Query Resolver for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_BudgetControlMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_BudgetControlInput.Table_Name;
	}

	public X_GL_BudgetControl GL_BudgetControlSave(I_GL_BudgetControlInput input, DataFetchingEnvironment environment) {
		return (X_GL_BudgetControl) super.save((X_GL_BudgetControlInput) input, environment);
	}

	public boolean GL_BudgetControlDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
