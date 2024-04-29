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
 * @version Release 11 - $Id$
 */
public class X_M_AttributeValueMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeValueInput.Table_Name;
	}

	public MAttributeValue M_AttributeValueSave(I_M_AttributeValueInput Entity, DataFetchingEnvironment environment) {
		return (MAttributeValue) super.save((X_M_AttributeValueInput) Entity, environment);
	}

	public List<MAttributeValue> M_AttributeValueSaveMany(List<I_M_AttributeValueInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_AttributeValueInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAttributeValue) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeValueDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
