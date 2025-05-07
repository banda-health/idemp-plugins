package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHTags;
import org.bandahealth.idempiere.graphql.model.input.I_BH_TagsInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_TagsInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Tags - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_TagsMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_TagsInput.Table_Name;
	}

	public MBHTags BH_TagsSave(I_BH_TagsInput Entity, DataFetchingEnvironment environment) {
		return (MBHTags) super.save((X_BH_TagsInput) Entity, environment);
	}

	public List<MBHTags> BH_TagsSaveMany(List<I_BH_TagsInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_TagsInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHTags) entity).collect(Collectors.toList());
	}

	public boolean BH_TagsDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
