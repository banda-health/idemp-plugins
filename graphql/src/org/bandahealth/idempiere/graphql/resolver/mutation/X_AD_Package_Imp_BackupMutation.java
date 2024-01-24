package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Package_Imp_BackupInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Package_Imp_BackupInput;
import org.compiere.model.X_AD_Package_Imp_Backup;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Package_Imp_Backup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_BackupMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_BackupInput.Table_Name;
	}

	public X_AD_Package_Imp_Backup AD_Package_Imp_BackupSave(I_AD_Package_Imp_BackupInput entity, DataFetchingEnvironment environment) {
		return (X_AD_Package_Imp_Backup) super.save((X_AD_Package_Imp_BackupInput) entity, environment);
	}

	public List<X_AD_Package_Imp_Backup> AD_Package_Imp_BackupSaveMany(List<I_AD_Package_Imp_BackupInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Package_Imp_BackupInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Package_Imp_Backup) entity).collect(Collectors.toList());
	}

	public boolean AD_Package_Imp_BackupDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
