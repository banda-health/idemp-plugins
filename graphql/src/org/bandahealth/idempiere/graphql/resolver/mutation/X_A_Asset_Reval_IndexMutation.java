package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Reval_IndexInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Reval_IndexInput;
import org.compiere.model.X_A_Asset_Reval_Index;

import java.util.List;

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

	public X_A_Asset_Reval_Index A_Asset_Reval_IndexSave(I_A_Asset_Reval_IndexInput input, DataFetchingEnvironment environment) {
		return (X_A_Asset_Reval_Index) super.save((X_A_Asset_Reval_IndexInput) input, environment);
	}

	public boolean A_Asset_Reval_IndexDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
