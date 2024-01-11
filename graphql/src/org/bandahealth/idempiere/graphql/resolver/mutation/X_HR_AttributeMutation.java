package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_AttributeInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_AttributeInput;
import org.eevolution.model.X_HR_Attribute;

import java.util.List;

/**
 * Generated Query Resolver for HR_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_AttributeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_HR_AttributeInput.Table_Name;
	}

	public X_HR_Attribute HR_AttributeSave(I_HR_AttributeInput input, DataFetchingEnvironment environment) {
		return (X_HR_Attribute) super.save((X_HR_AttributeInput) input, environment);
	}

	public boolean HR_AttributeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
