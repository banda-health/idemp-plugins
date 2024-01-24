package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeSetExcludeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeSetExcludeInput;
import org.compiere.model.MAttributeSetExclude;

import java.util.List;

/**
 * Generated Query Resolver for M_AttributeSetExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeSetExcludeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSetExcludeInput.Table_Name;
	}

	public MAttributeSetExclude M_AttributeSetExcludeSave(I_M_AttributeSetExcludeInput input, DataFetchingEnvironment environment) {
		return (MAttributeSetExclude) super.save((X_M_AttributeSetExcludeInput) input, environment);
	}

	public boolean M_AttributeSetExcludeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
