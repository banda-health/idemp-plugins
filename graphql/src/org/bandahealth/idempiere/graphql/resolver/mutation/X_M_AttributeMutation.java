package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttribute_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeInput;

import java.util.List;

/**
 * Generated Query Resolver for M_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeInput.Table_Name;
	}

	public MAttribute_BH M_AttributeSave(I_M_AttributeInput input, DataFetchingEnvironment environment) {
		return (MAttribute_BH) super.save((X_M_AttributeInput) input, environment);
	}

	public boolean M_AttributeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
