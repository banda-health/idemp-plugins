package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeInstanceInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeInstanceInput;
import org.compiere.model.MAttributeInstance;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_AttributeInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeInstanceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeInstanceInput.Table_Name;
	}

	public MAttributeInstance M_AttributeInstanceSave(I_M_AttributeInstanceInput entity, DataFetchingEnvironment environment) {
		return (MAttributeInstance) super.save((X_M_AttributeInstanceInput) entity, environment);
	}

	public List<MAttributeInstance> M_AttributeInstanceSaveMany(List<I_M_AttributeInstanceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_AttributeInstanceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAttributeInstance) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeInstanceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
