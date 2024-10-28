package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeDataLoader;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeValue;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_AttributeValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeValueResolver extends POResolver<MAttributeValue> implements GraphQLResolver<MAttributeValue> {



	/**
	 * Get Attribute.
	 *
	 * @return Product Attribute
	 */
	public CompletableFuture<MAttribute> M_Attribute(MAttributeValue entity, DataFetchingEnvironment environment) {
		if (entity.getM_Attribute_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAttribute> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeDataLoader.DATALOADER_M_Attribute_BY_ID);
		return dataLoader.load(entity.getM_Attribute_ID());
	}

}
