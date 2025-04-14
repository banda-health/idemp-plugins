package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintHeaderFooterInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintHeaderFooterInput;
import org.compiere.model.X_AD_PrintHeaderFooter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintHeaderFooter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintHeaderFooterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintHeaderFooterInput.Table_Name;
	}

	public X_AD_PrintHeaderFooter AD_PrintHeaderFooterSave(I_AD_PrintHeaderFooterInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintHeaderFooter) super.save((X_AD_PrintHeaderFooterInput) Entity, environment);
	}

	public List<X_AD_PrintHeaderFooter> AD_PrintHeaderFooterSaveMany(List<I_AD_PrintHeaderFooterInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_PrintHeaderFooterInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintHeaderFooter) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintHeaderFooterDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
