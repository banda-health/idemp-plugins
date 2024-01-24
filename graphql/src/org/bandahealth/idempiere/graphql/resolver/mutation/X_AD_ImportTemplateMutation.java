package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ImportTemplateInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ImportTemplateInput;
import org.compiere.model.MImportTemplate;

import java.util.List;

/**
 * Generated Query Resolver for AD_ImportTemplate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ImportTemplateMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ImportTemplateInput.Table_Name;
	}

	public MImportTemplate AD_ImportTemplateSave(I_AD_ImportTemplateInput input, DataFetchingEnvironment environment) {
		return (MImportTemplate) super.save((X_AD_ImportTemplateInput) input, environment);
	}

	public boolean AD_ImportTemplateDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
