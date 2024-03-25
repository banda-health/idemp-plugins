package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LabelPrinterFunctionInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LabelPrinterFunctionInput;
import org.compiere.model.X_AD_LabelPrinterFunction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LabelPrinterFunctionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LabelPrinterFunctionInput.Table_Name;
	}

	public X_AD_LabelPrinterFunction AD_LabelPrinterFunctionSave(I_AD_LabelPrinterFunctionInput entity, DataFetchingEnvironment environment) {
		return (X_AD_LabelPrinterFunction) super.save((X_AD_LabelPrinterFunctionInput) entity, environment);
	}

	public List<X_AD_LabelPrinterFunction> AD_LabelPrinterFunctionSaveMany(List<I_AD_LabelPrinterFunctionInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_LabelPrinterFunctionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_LabelPrinterFunction) entity).collect(Collectors.toList());
	}

	public boolean AD_LabelPrinterFunctionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
