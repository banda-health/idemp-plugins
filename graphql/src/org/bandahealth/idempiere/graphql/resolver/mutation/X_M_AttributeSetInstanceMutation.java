package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeSetInstanceInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeSetInstanceInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetInstanceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSetInstanceInput.Table_Name;
	}

	public MAttributeSetInstance_BH M_AttributeSetInstanceSave(I_M_AttributeSetInstanceInput entity, DataFetchingEnvironment environment) {
		return (MAttributeSetInstance_BH) super.save((X_M_AttributeSetInstanceInput) entity, environment);
	}

	public List<MAttributeSetInstance_BH> M_AttributeSetInstanceSaveMany(List<I_M_AttributeSetInstanceInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_AttributeSetInstanceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAttributeSetInstance_BH) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeSetInstanceDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
