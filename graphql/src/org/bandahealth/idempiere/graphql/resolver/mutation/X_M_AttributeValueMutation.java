package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeValueInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeValueInput;
import org.compiere.model.MAttributeValue;

import java.util.List;
import java.util.stream.Collectors;

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

	public MAttributeValue M_AttributeValueSave(I_M_AttributeValueInput entity, DataFetchingEnvironment environment) {
		return (MAttributeValue) super.save((X_M_AttributeValueInput) entity, environment);
	}

	public List<MAttributeValue> M_AttributeValueSaveMany(List<I_M_AttributeValueInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_AttributeValueInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAttributeValue) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeValueDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
