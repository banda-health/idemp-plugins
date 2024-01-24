package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_CtxHelpMsgInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_CtxHelpMsgInput;
import org.compiere.model.MCtxHelpMsg;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_CtxHelpMsg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_CtxHelpMsgMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_CtxHelpMsgInput.Table_Name;
	}

	public MCtxHelpMsg AD_CtxHelpMsgSave(I_AD_CtxHelpMsgInput entity, DataFetchingEnvironment environment) {
		return (MCtxHelpMsg) super.save((X_AD_CtxHelpMsgInput) entity, environment);
	}

	public List<MCtxHelpMsg> AD_CtxHelpMsgSaveMany(List<I_AD_CtxHelpMsgInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_CtxHelpMsgInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MCtxHelpMsg) entity).collect(Collectors.toList());
	}

	public boolean AD_CtxHelpMsgDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
