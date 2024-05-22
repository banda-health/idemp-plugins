package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ShippingProcessorInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ShippingProcessorInput;
import org.compiere.model.MShippingProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShippingProcessorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ShippingProcessorInput.Table_Name;
	}

	public MShippingProcessor M_ShippingProcessorSave(I_M_ShippingProcessorInput Entity, DataFetchingEnvironment environment) {
		return (MShippingProcessor) super.save((X_M_ShippingProcessorInput) Entity, environment);
	}

	public List<MShippingProcessor> M_ShippingProcessorSaveMany(List<I_M_ShippingProcessorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ShippingProcessorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MShippingProcessor) entity).collect(Collectors.toList());
	}

	public boolean M_ShippingProcessorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
