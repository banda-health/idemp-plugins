package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MConversionType;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for C_ConversionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ConversionTypeResolver extends POResolver<MConversionType> implements GraphQLResolver<MConversionType> {


	public Boolean IsDefault(MConversionType entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

}
