package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Depreciation_Table_HeaderInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Depreciation_Table_HeaderInput;
import org.compiere.model.X_A_Depreciation_Table_Header;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_Table_HeaderMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_HeaderInput.Table_Name;
	}

	public X_A_Depreciation_Table_Header A_Depreciation_Table_HeaderSave(I_A_Depreciation_Table_HeaderInput entity, DataFetchingEnvironment environment) {
		return (X_A_Depreciation_Table_Header) super.save((X_A_Depreciation_Table_HeaderInput) entity, environment);
	}

	public List<X_A_Depreciation_Table_Header> A_Depreciation_Table_HeaderSaveMany(List<I_A_Depreciation_Table_HeaderInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Depreciation_Table_HeaderInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Depreciation_Table_Header) entity).collect(Collectors.toList());
	}

	public boolean A_Depreciation_Table_HeaderDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
