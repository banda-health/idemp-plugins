package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_UserDef_Info_RelatedInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_UserDef_Info_RelatedInput;
import org.compiere.model.MUserDefInfoRelated;

import java.util.List;

/**
 * Generated Query Resolver for AD_UserDef_Info_Related - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_Info_RelatedMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_UserDef_Info_RelatedInput.Table_Name;
	}

	public MUserDefInfoRelated AD_UserDef_Info_RelatedSave(I_AD_UserDef_Info_RelatedInput input, DataFetchingEnvironment environment) {
		return (MUserDefInfoRelated) super.save((X_AD_UserDef_Info_RelatedInput) input, environment);
	}

	public boolean AD_UserDef_Info_RelatedDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
