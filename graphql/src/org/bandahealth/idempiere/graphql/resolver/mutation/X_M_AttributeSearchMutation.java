package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeSearchInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeSearchInput;
import org.compiere.model.X_M_AttributeSearch;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_AttributeSearch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeSearchMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSearchInput.Table_Name;
	}

	public X_M_AttributeSearch M_AttributeSearchSave(I_M_AttributeSearchInput Entity, DataFetchingEnvironment environment) {
		return (X_M_AttributeSearch) super.save((X_M_AttributeSearchInput) Entity, environment);
	}

	public List<X_M_AttributeSearch> M_AttributeSearchSaveMany(List<I_M_AttributeSearchInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_AttributeSearchInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_AttributeSearch) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeSearchDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
