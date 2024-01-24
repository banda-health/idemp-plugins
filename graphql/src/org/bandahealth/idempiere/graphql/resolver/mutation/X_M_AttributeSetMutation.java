package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeSetInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeSetInput;

import java.util.List;

/**
 * Generated Query Resolver for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeSetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSetInput.Table_Name;
	}

	public MAttributeSet_BH M_AttributeSetSave(I_M_AttributeSetInput input, DataFetchingEnvironment environment) {
		return (MAttributeSet_BH) super.save((X_M_AttributeSetInput) input, environment);
	}

	public boolean M_AttributeSetDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
