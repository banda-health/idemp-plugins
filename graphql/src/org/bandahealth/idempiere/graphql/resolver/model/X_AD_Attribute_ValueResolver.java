package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AttributeDataLoader;
import org.compiere.model.X_AD_Attribute;
import org.compiere.model.X_AD_Attribute_Value;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Attribute_Value - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Attribute_ValueResolver extends POResolver<X_AD_Attribute_Value> implements GraphQLResolver<X_AD_Attribute_Value> {



	/**
	 * Get System Attribute.
	 *
	 * @return System Attribute
	 */
	public CompletableFuture<X_AD_Attribute> AD_Attribute(X_AD_Attribute_Value entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Attribute_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_Attribute> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AttributeDataLoader.DATALOADER_AD_Attribute_BY_ID);
		return dataLoader.load(entity.getAD_Attribute_ID());
	}

}
