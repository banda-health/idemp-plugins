package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHTag;
import org.bandahealth.idempiere.graphql.model.input.I_BH_TagInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_TagInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Tag - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_TagMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_TagInput.Table_Name;
	}

	public MBHTag BH_TagSave(I_BH_TagInput Entity, DataFetchingEnvironment environment) {
		return (MBHTag) super.save((X_BH_TagInput) Entity, environment);
	}

	public List<MBHTag> BH_TagSaveMany(List<I_BH_TagInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_TagInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHTag) entity).collect(Collectors.toList());
	}

	public boolean BH_TagDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
