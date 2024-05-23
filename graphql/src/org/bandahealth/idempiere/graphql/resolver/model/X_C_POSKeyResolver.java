package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFontDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_POSKeyLayoutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.compiere.model.MImage;
import org.compiere.model.MPOSKey;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_POSKeyResolver extends POResolver<MPOSKey> implements GraphQLResolver<MPOSKey> {



	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public CompletableFuture<MImage> AD_Image(MPOSKey entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Image_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MImage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImageDataLoader.DATALOADER_AD_Image_BY_ID);
		return dataLoader.load(entity.getAD_Image_ID());
	}


	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(MPOSKey entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.DATALOADER_AD_PrintColor_BY_ID);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}


	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	public CompletableFuture<X_AD_PrintFont> AD_PrintFont(MPOSKey entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFont_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFont> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFontDataLoader.DATALOADER_AD_PrintFont_BY_ID);
		return dataLoader.load(entity.getAD_PrintFont_ID());
	}


	/**
	 * Get POS Key Layout.
	 *
	 * @return POS Function Key Layout
	 */
	public CompletableFuture<MPOSKeyLayout> C_POSKeyLayout(MPOSKey entity, DataFetchingEnvironment environment) {
		if (entity.getC_POSKeyLayout_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPOSKeyLayout> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_POSKeyLayoutDataLoader.DATALOADER_C_POSKeyLayout_BY_ID);
		return dataLoader.load(entity.getC_POSKeyLayout_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MPOSKey entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Key Layout.
	 *
	 * @return Key Layout to be displayed when this key is pressed
	 */
	public CompletableFuture<MPOSKeyLayout> SubKeyLayout(MPOSKey entity, DataFetchingEnvironment environment) {
		if (entity.getSubKeyLayout_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPOSKeyLayout> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_POSKeyLayoutDataLoader.DATALOADER_C_POSKeyLayout_BY_ID);
		return dataLoader.load(entity.getSubKeyLayout_ID());
	}

}
