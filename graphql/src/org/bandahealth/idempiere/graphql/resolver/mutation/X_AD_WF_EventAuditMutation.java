package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_EventAuditInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_EventAuditInput;
import org.compiere.model.X_AD_WF_EventAudit;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_EventAudit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_EventAuditMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_EventAuditInput.Table_Name;
	}

	public X_AD_WF_EventAudit AD_WF_EventAuditSave(I_AD_WF_EventAuditInput entity, DataFetchingEnvironment environment) {
		return (X_AD_WF_EventAudit) super.save((X_AD_WF_EventAuditInput) entity, environment);
	}

	public List<X_AD_WF_EventAudit> AD_WF_EventAuditSaveMany(List<I_AD_WF_EventAuditInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_WF_EventAuditInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_WF_EventAudit) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_EventAuditDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
