package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeValueInput;
import org.compiere.model.MAttributeValue;

import java.util.List;

/**
 * Generated Query Resolver for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeValueInput.Table_Name;
	}

	public MAttributeValue M_AttributeValueSave(I_M_AttributeValueInput input, DataFetchingEnvironment environment) {
		return (MAttributeValue) super.save((X_M_AttributeValueInput) input, environment);
	}

	public boolean M_AttributeValueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
