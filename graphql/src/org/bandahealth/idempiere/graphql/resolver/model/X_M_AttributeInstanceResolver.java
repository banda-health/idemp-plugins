package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeValueDataLoader;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeInstance;
import org.compiere.model.MAttributeValue;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_AttributeInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeInstanceResolver extends POResolver<MAttributeInstance> implements GraphQLResolver<MAttributeInstance> {



	/**
	 * Get Attribute.
	 *
	 * @return Product Attribute
	 */
	public CompletableFuture<MAttribute> M_Attribute(MAttributeInstance entity, DataFetchingEnvironment environment) {
		if (entity.getM_Attribute_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttribute> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeDataLoader.DATALOADER_M_Attribute_BY_ID);
		return dataLoader.load(entity.getM_Attribute_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MAttributeInstance entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Attribute Value.
	 *
	 * @return Product Attribute Value
	 */
	public CompletableFuture<MAttributeValue> M_AttributeValue(MAttributeInstance entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeValue_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeValueDataLoader.DATALOADER_M_AttributeValue_BY_ID);
		return dataLoader.load(entity.getM_AttributeValue_ID());
	}

}
