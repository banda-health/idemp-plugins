package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_CtxHelpInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_CtxHelpInput;
import org.compiere.model.MCtxHelp;

import java.util.List;

/**
 * Generated Query Resolver for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_CtxHelpInput.Table_Name;
	}

	public MCtxHelp AD_CtxHelpSave(I_AD_CtxHelpInput input, DataFetchingEnvironment environment) {
		return (MCtxHelp) super.save((X_AD_CtxHelpInput) input, environment);
	}

	public boolean AD_CtxHelpDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
