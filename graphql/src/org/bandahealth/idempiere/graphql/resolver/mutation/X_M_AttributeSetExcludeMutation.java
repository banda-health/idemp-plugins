package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeSetExcludeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeSetExcludeInput;
import org.compiere.model.X_M_AttributeSetExclude;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_AttributeSetExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_AttributeSetExcludeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSetExcludeInput.Table_Name;
	}

	public X_M_AttributeSetExclude M_AttributeSetExcludeSave(I_M_AttributeSetExcludeInput entity, DataFetchingEnvironment environment) {
		return (X_M_AttributeSetExclude) super.save((X_M_AttributeSetExcludeInput) entity, environment);
	}

	public List<X_M_AttributeSetExclude> M_AttributeSetExcludeSaveMany(List<I_M_AttributeSetExcludeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_AttributeSetExcludeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_AttributeSetExclude) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeSetExcludeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
