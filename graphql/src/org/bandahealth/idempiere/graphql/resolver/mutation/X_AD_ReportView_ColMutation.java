package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReportView_ColInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReportView_ColInput;
import org.compiere.model.X_AD_ReportView_Col;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ReportView_Col - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ReportView_ColMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReportView_ColInput.Table_Name;
	}

	public X_AD_ReportView_Col AD_ReportView_ColSave(I_AD_ReportView_ColInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_ReportView_Col) super.save((X_AD_ReportView_ColInput) Entity, environment);
	}

	public List<X_AD_ReportView_Col> AD_ReportView_ColSaveMany(List<I_AD_ReportView_ColInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ReportView_ColInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_ReportView_Col) entity).collect(Collectors.toList());
	}

	public boolean AD_ReportView_ColDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
