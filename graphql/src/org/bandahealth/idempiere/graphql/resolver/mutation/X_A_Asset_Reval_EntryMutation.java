package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_A_Asset_Reval_EntryInput;
import org.bandahealth.idempiere.graphql.model.input.X_A_Asset_Reval_EntryInput;
import org.compiere.model.X_A_Asset_Reval_Entry;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for A_Asset_Reval_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Reval_EntryMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Reval_EntryInput.Table_Name;
	}

	public X_A_Asset_Reval_Entry A_Asset_Reval_EntrySave(I_A_Asset_Reval_EntryInput entity, DataFetchingEnvironment environment) {
		return (X_A_Asset_Reval_Entry) super.save((X_A_Asset_Reval_EntryInput) entity, environment);
	}

	public List<X_A_Asset_Reval_Entry> A_Asset_Reval_EntrySaveMany(List<I_A_Asset_Reval_EntryInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_A_Asset_Reval_EntryInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_A_Asset_Reval_Entry) entity).collect(Collectors.toList());
	}

	public boolean A_Asset_Reval_EntryDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
