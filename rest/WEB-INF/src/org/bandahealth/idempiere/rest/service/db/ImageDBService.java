package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Image;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MImage;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class ImageDBService extends BaseDBService<Image, MImage> {

	@Override
	public Image saveEntity(Image entity) {
		try {
			MImage image = getEntityByUuidFromDB(entity.getUuid());
			if (image == null) {
				image = new MImage(Env.getCtx(), 0, null);
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					image.setAD_Image_UU(entity.getUuid());
				}
			}

			image.setName(entity.getName());
			image.setImageURL(entity.getImageUrl());
			image.setBinaryData(Base64.getDecoder().decode(entity.getBinaryData()));
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
		return new Image(instance);
	}

	@Override
	}

	@Override
	protected MImage getModelInstance() {
		return new MImage(Env.getCtx(), 0, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}
}
