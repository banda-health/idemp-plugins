package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHSickOffPrintLog;
import org.bandahealth.idempiere.graphql.model.input.I_BH_SickOff_Print_LogInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_SickOff_Print_LogInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_SickOff_Print_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_SickOff_Print_LogMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_SickOff_Print_LogInput.Table_Name;
	}

	public MBHSickOffPrintLog BH_SickOff_Print_LogSave(I_BH_SickOff_Print_LogInput Entity, DataFetchingEnvironment environment) {
		return (MBHSickOffPrintLog) super.save((X_BH_SickOff_Print_LogInput) Entity, environment);
	}

	public List<MBHSickOffPrintLog> BH_SickOff_Print_LogSaveMany(List<I_BH_SickOff_Print_LogInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_SickOff_Print_LogInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHSickOffPrintLog) entity).collect(Collectors.toList());
	}

	public boolean BH_SickOff_Print_LogDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
