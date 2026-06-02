package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHFeatureFlag;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Feature_FlagInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Feature_FlagInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Feature_Flag - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_FlagMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Feature_FlagInput.Table_Name;
	}

	public MBHFeatureFlag BH_Feature_FlagSave(I_BH_Feature_FlagInput Entity, DataFetchingEnvironment environment) {
		return (MBHFeatureFlag) super.save((X_BH_Feature_FlagInput) Entity, environment);
	}

	public List<MBHFeatureFlag> BH_Feature_FlagSaveMany(List<I_BH_Feature_FlagInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Feature_FlagInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHFeatureFlag) entity).collect(Collectors.toList());
	}

	public boolean BH_Feature_FlagDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
