package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SysConfigInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SysConfigInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_SysConfig - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SysConfigMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SysConfigInput.Table_Name;
	}

	public MSysConfig_BH AD_SysConfigSave(I_AD_SysConfigInput Entity, DataFetchingEnvironment environment) {
		return (MSysConfig_BH) super.save((X_AD_SysConfigInput) Entity, environment);
	}

	public List<MSysConfig_BH> AD_SysConfigSaveMany(List<I_AD_SysConfigInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_SysConfigInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSysConfig_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_SysConfigDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
