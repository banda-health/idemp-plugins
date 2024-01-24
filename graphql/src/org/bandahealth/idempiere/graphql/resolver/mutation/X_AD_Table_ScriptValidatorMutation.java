package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Table_ScriptValidatorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Table_ScriptValidatorInput;
import org.compiere.model.MTableScriptValidator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Table_ScriptValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Table_ScriptValidatorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Table_ScriptValidatorInput.Table_Name;
	}

	public MTableScriptValidator AD_Table_ScriptValidatorSave(I_AD_Table_ScriptValidatorInput entity, DataFetchingEnvironment environment) {
		return (MTableScriptValidator) super.save((X_AD_Table_ScriptValidatorInput) entity, environment);
	}

	public List<MTableScriptValidator> AD_Table_ScriptValidatorSaveMany(List<I_AD_Table_ScriptValidatorInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Table_ScriptValidatorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTableScriptValidator) entity).collect(Collectors.toList());
	}

	public boolean AD_Table_ScriptValidatorDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
