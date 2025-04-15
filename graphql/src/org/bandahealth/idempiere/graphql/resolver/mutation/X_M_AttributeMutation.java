package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeInput;
import org.compiere.model.MAttribute;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_AttributeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeInput.Table_Name;
	}

	public MAttribute M_AttributeSave(I_M_AttributeInput Entity, DataFetchingEnvironment environment) {
		return (MAttribute) super.save((X_M_AttributeInput) Entity, environment);
	}

	public List<MAttribute> M_AttributeSaveMany(List<I_M_AttributeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_AttributeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAttribute) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
