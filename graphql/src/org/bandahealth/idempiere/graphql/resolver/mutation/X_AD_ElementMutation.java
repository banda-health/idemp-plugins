package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ElementInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ElementInput;
import org.compiere.model.M_Element;

import java.util.List;

/**
 * Generated Query Resolver for AD_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ElementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ElementInput.Table_Name;
	}

	public M_Element AD_ElementSave(I_AD_ElementInput input, DataFetchingEnvironment environment) {
		return (M_Element) super.save((X_AD_ElementInput) input, environment);
	}

	public boolean AD_ElementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
