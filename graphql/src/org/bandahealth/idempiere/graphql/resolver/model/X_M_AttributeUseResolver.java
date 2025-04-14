package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetDataLoader;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeUse;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_AttributeUseResolver extends POResolver<MAttributeUse> implements GraphQLResolver<MAttributeUse> {



	/**
	 * Get Attribute.
	 *
	 * @return Product Attribute
	 */
	public CompletableFuture<MAttribute> M_Attribute(MAttributeUse entity, DataFetchingEnvironment environment) {
		if (entity.getM_Attribute_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAttribute> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeDataLoader.DATALOADER_M_Attribute_BY_ID);
		return dataLoader.load(entity.getM_Attribute_ID());
	}


	/**
	 * Get Attribute Set.
	 *
	 * @return Product Attribute Set
	 */
	public CompletableFuture<MAttributeSet_BH> M_AttributeSet(MAttributeUse entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSet_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSet_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetDataLoader.DATALOADER_M_AttributeSet_BY_ID);
		return dataLoader.load(entity.getM_AttributeSet_ID());
	}

}
