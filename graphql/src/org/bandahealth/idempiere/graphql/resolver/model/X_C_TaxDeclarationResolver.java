package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MTaxDeclaration;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_TaxDeclaration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxDeclarationResolver extends POResolver<MTaxDeclaration> implements GraphQLResolver<MTaxDeclaration> {


	public Boolean Processed(MTaxDeclaration entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MTaxDeclaration entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
