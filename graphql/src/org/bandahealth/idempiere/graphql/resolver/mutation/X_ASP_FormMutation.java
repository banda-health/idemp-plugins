package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_ASP_FormInput;
import org.bandahealth.idempiere.graphql.model.input.X_ASP_FormInput;
import org.compiere.model.X_ASP_Form;

import java.util.List;

/**
 * Generated Query Resolver for ASP_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_FormMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_ASP_FormInput.Table_Name;
	}

	public X_ASP_Form ASP_FormSave(I_ASP_FormInput input, DataFetchingEnvironment environment) {
		return (X_ASP_Form) super.save((X_ASP_FormInput) input, environment);
	}

	public boolean ASP_FormDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
