package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_Info_ColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_Info_ColumnInput;
import org.compiere.model.MUserDefInfoColumn;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_UserDef_Info_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserDef_Info_ColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_Info_ColumnInput.Table_Name;
	}

	public MUserDefInfoColumn AD_UserDef_Info_ColumnSave(I_AD_UserDef_Info_ColumnInput Entity, DataFetchingEnvironment environment) {
		return (MUserDefInfoColumn) super.save((X_AD_UserDef_Info_ColumnInput) Entity, environment);
	}

	public List<MUserDefInfoColumn> AD_UserDef_Info_ColumnSaveMany(List<I_AD_UserDef_Info_ColumnInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_UserDef_Info_ColumnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUserDefInfoColumn) entity).collect(Collectors.toList());
	}

	public boolean AD_UserDef_Info_ColumnDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
