package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_BlockInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_BlockInput;
import org.compiere.model.X_AD_WF_Block;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_Block - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WF_BlockMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_BlockInput.Table_Name;
	}

	public X_AD_WF_Block AD_WF_BlockSave(I_AD_WF_BlockInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_Block) super.save((X_AD_WF_BlockInput) Entity, environment);
	}

	public List<X_AD_WF_Block> AD_WF_BlockSaveMany(List<I_AD_WF_BlockInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_WF_BlockInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_Block) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_BlockDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
