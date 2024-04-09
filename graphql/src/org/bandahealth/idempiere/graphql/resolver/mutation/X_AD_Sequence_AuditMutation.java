package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Sequence_AuditInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Sequence_AuditInput;
import org.compiere.model.X_AD_Sequence_Audit;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Sequence_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Sequence_AuditMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Sequence_AuditInput.Table_Name;
	}

	public X_AD_Sequence_Audit AD_Sequence_AuditSave(I_AD_Sequence_AuditInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_Sequence_Audit) super.save((X_AD_Sequence_AuditInput) Entity, environment);
	}

	public List<X_AD_Sequence_Audit> AD_Sequence_AuditSaveMany(List<I_AD_Sequence_AuditInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Sequence_AuditInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Sequence_Audit) entity).collect(Collectors.toList());
	}

	public boolean AD_Sequence_AuditDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
