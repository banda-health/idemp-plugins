package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_LabelPrinterInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_LabelPrinterInput;
import org.compiere.model.X_AD_LabelPrinter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_LabelPrinter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LabelPrinterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_LabelPrinterInput.Table_Name;
	}

	public X_AD_LabelPrinter AD_LabelPrinterSave(I_AD_LabelPrinterInput entity, DataFetchingEnvironment environment) {
		return (X_AD_LabelPrinter) super.save((X_AD_LabelPrinterInput) entity, environment);
	}

	public List<X_AD_LabelPrinter> AD_LabelPrinterSaveMany(List<I_AD_LabelPrinterInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_LabelPrinterInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_LabelPrinter) entity).collect(Collectors.toList());
	}

	public boolean AD_LabelPrinterDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
