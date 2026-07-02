package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHSickOff;
import org.bandahealth.idempiere.graphql.model.input.I_BH_SickOffInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_SickOffInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_SickOff - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_SickOffMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_SickOffInput.Table_Name;
	}

	public MBHSickOff BH_SickOffSave(I_BH_SickOffInput Entity, DataFetchingEnvironment environment) {
		return (MBHSickOff) super.save((X_BH_SickOffInput) Entity, environment);
	}

	public List<MBHSickOff> BH_SickOffSaveMany(List<I_BH_SickOffInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_SickOffInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHSickOff) entity).collect(Collectors.toList());
	}

	public boolean BH_SickOffDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
