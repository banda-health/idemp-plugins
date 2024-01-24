package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_AttributeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_AttributeInput;
import org.compiere.model.X_AD_Attribute;

import java.util.List;

/**
 * Generated Query Resolver for AD_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AttributeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_AttributeInput.Table_Name;
	}

	public X_AD_Attribute AD_AttributeSave(I_AD_AttributeInput input, DataFetchingEnvironment environment) {
		return (X_AD_Attribute) super.save((X_AD_AttributeInput) input, environment);
	}

	public boolean AD_AttributeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
