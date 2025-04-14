package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeSetExcludeInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeSetExcludeInput;
import org.compiere.model.MAttributeSetExclude;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_AttributeSetExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_AttributeSetExcludeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSetExcludeInput.Table_Name;
	}

	public MAttributeSetExclude M_AttributeSetExcludeSave(I_M_AttributeSetExcludeInput Entity, DataFetchingEnvironment environment) {
		return (MAttributeSetExclude) super.save((X_M_AttributeSetExcludeInput) Entity, environment);
	}

	public List<MAttributeSetExclude> M_AttributeSetExcludeSaveMany(List<I_M_AttributeSetExcludeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_AttributeSetExcludeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAttributeSetExclude) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeSetExcludeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
