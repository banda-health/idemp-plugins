package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_TableIndexInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_TableIndexInput;
import org.compiere.model.MTableIndex;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_TableIndex - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TableIndexMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_TableIndexInput.Table_Name;
	}

	public MTableIndex AD_TableIndexSave(I_AD_TableIndexInput Entity, DataFetchingEnvironment environment) {
		return (MTableIndex) super.save((X_AD_TableIndexInput) Entity, environment);
	}

	public List<MTableIndex> AD_TableIndexSaveMany(List<I_AD_TableIndexInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_TableIndexInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTableIndex) entity).collect(Collectors.toList());
	}

	public boolean AD_TableIndexDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
