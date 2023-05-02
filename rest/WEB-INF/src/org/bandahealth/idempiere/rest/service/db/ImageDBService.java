package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Image;
import org.compiere.model.ImageFileStorageImpl;
import org.compiere.model.MImage;
import org.compiere.model.MStorageProvider;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageDBService extends BaseDBService<Image, MImage> {

	private CLogger log = CLogger.getCLogger(ImageDBService.class);

	private MStorageProvider imageProvider;
	private ImageFileStorageImpl fileStorage;

	@Override
	public Image saveEntity(Image entity) {
		try {
			MImage image = new Query(Env.getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + " =?", null)
					.setParameters(entity.getUuid()).first();
			if (image == null) {
				image = new MImage(Env.getCtx(), 0, null);
				image.saveEx(); // an existing image is required to save the image in the file storage.
			}

			image.setName(entity.getName());

			getFileStorage().save(image, getImageProvider(), Base64.getDecoder().decode(entity.getBinaryData()));

			image.saveEx();

			return createInstanceWithAllFields(image);

		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Image createInstanceWithDefaultFields(MImage instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Image createInstanceWithAllFields(MImage instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected Image createInstanceWithSearchFields(MImage instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	public List<Image> transformData(List<MImage> dbModels) {
		return dbModels.stream().map(mImage -> {
			Image image = new Image(mImage);
			try {
				// load image from drive and encode to string.
				byte[] imageBytes = getFileStorage().load(mImage, getImageProvider());
				if (imageBytes != null) {
					image.setBinaryData(Base64.getEncoder().encodeToString(imageBytes));
				}
			} catch (Exception ex) {
				log.severe(ex.getMessage());
			}

			return image;

		}).collect(Collectors.toList());
	}

	@Override
	protected MImage getModelInstance() {
		return new MImage(Env.getCtx(), 0, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	private MStorageProvider getImageProvider() {
		if (imageProvider != null) {
			return imageProvider;
		}

		imageProvider = new Query(Env.getCtx(), MStorageProvider.Table_Name,
				MStorageProvider.COLUMNNAME_AD_StorageProvider_UU + " =?", null)
						.setParameters(MOrgInfo_BH.LOGO_STORAGEPROVIDER_UU).first();

		return imageProvider;
	}

	private ImageFileStorageImpl getFileStorage() {
		if (fileStorage != null) {
			return fileStorage;
		}

		return fileStorage = new ImageFileStorageImpl();
	}
}
