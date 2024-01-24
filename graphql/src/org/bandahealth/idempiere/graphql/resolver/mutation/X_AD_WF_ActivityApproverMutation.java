package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_WF_ActivityApproverInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_WF_ActivityApproverInput;
import org.compiere.model.MWFActivityApprover;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_WF_ActivityApprover - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ActivityApproverMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_ActivityApproverInput.Table_Name;
	}

	public MWFActivityApprover AD_WF_ActivityApproverSave(I_AD_WF_ActivityApproverInput entity, DataFetchingEnvironment environment) {
		return (MWFActivityApprover) super.save((X_AD_WF_ActivityApproverInput) entity, environment);
	}

	public List<MWFActivityApprover> AD_WF_ActivityApproverSaveMany(List<I_AD_WF_ActivityApproverInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_WF_ActivityApproverInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MWFActivityApprover) entity).collect(Collectors.toList());
	}

	public boolean AD_WF_ActivityApproverDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
