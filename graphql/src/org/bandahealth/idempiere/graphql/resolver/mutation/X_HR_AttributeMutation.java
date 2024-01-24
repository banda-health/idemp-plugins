package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_HR_AttributeInput;
import org.bandahealth.idempiere.graphql.model.input.X_HR_AttributeInput;
import org.eevolution.model.X_HR_Attribute;

import java.util.List;
import java.util.stream.Collectors;

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

	public X_HR_Attribute HR_AttributeSave(I_HR_AttributeInput entity, DataFetchingEnvironment environment) {
		return (X_HR_Attribute) super.save((X_HR_AttributeInput) entity, environment);
	}

	public List<X_HR_Attribute> HR_AttributeSaveMany(List<I_HR_AttributeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_HR_AttributeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_HR_Attribute) entity).collect(Collectors.toList());
	}

	public boolean HR_AttributeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
