package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Reval_IndexInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Reval_IndexInput;
import org.compiere.model.X_A_Asset_Reval_Index;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Reval_IndexMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Reval_IndexInput.Table_Name;
	}

	public X_A_Asset_Reval_Index A_Asset_Reval_IndexSave(I_A_Asset_Reval_IndexInput entity, DataFetchingEnvironment environment) {
		return (X_A_Asset_Reval_Index) super.save((X_A_Asset_Reval_IndexInput) entity, environment);
	}

	public List<X_A_Asset_Reval_Index> A_Asset_Reval_IndexSaveMany(List<I_A_Asset_Reval_IndexInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Asset_Reval_IndexInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Asset_Reval_Index) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_Reval_IndexDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
