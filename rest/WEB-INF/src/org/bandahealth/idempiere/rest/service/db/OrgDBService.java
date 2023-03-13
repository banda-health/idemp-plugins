package org.bandahealth.idempiere.rest.service.db;

import java.util.Base64;
import java.util.Collections;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.rest.model.Image;
import org.bandahealth.idempiere.rest.model.Location;
import org.bandahealth.idempiere.rest.model.Org;
import org.bandahealth.idempiere.rest.model.OrgInfo;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.ImageFileStorageImpl;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MStorageProvider;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class OrgDBService extends BaseDBService<Org, MOrg> {

	private final LocationDBService locationDBService = new LocationDBService();
	private MStorageProvider imageProvider;
	private ImageFileStorageImpl fileStorage;

	/**
	 * Updates the OrgInfo object that's nested in Org. Updating the Org object is
	 * not yet supported.
	 * 
	 */
	@Override
	public Org saveEntity(Org entity) {
		// get org
		MOrg org = new Query(Env.getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + " =?", null)
				.setParameters(entity.getUuid()).first();
		if (org == null) {
			throw new AdempiereException("Organisation not found.");
		}

		MOrgInfo_BH orgInfo = (MOrgInfo_BH) MOrgInfo_BH.get(Env.getCtx(), org.get_ID(), null); // this method checks
																								// cache..
		if (orgInfo == null) {
			throw new AdempiereException("Missing organisation information");
		}

		OrgInfo orgInfoEntity = entity.getOrgInfo();
		// safe check in the event the implementation logic doesn't set this as a
		// required field
		if (orgInfoEntity != null) {
			if (StringUtil.isNotNullAndEmpty(orgInfoEntity.getHeaderMessage())) {
				orgInfo.setBH_Header(orgInfoEntity.getHeaderMessage());
			}

			if (StringUtil.isNotNullAndEmpty(orgInfoEntity.getFacilityNumber())) {
				orgInfo.setBH_FacilityNumber(orgInfoEntity.getFacilityNumber());
			}

			if (StringUtil.isNotNullAndEmpty(orgInfoEntity.getPaymentInformation())) {
				orgInfo.setBH_PaymentInformation(orgInfoEntity.getPaymentInformation());
			}

			if (StringUtil.isNotNullAndEmpty(orgInfoEntity.getPhone())) {
				orgInfo.setPhone(orgInfoEntity.getPhone());
			}

			if (StringUtil.isNotNullAndEmpty(orgInfoEntity.getReceiptFooterMessage())) {
				orgInfo.setReceiptFooterMsg(orgInfoEntity.getReceiptFooterMessage());
			}

			// set location
			Location locationEntity = orgInfoEntity.getLocation();
			if (locationEntity != null) {
				MLocation location = locationDBService.getEntityByUuidFromDB(locationEntity.getUuid());
				if (location == null) {
					location = new MLocation(Env.getCtx(), 0, null);
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress1())) {
					location.setAddress1(locationEntity.getAddress1());
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress2())) {
					location.setAddress1(locationEntity.getAddress1());
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress3())) {
					location.setAddress1(locationEntity.getAddress1());
				}

				location.saveEx();

				orgInfo.setC_Location_ID(location.get_ID());
			}

			// set logo
			if (orgInfoEntity.getLogo() != null
					&& StringUtil.isNotNullAndEmpty(orgInfoEntity.getLogo().getBinaryData())) {
				Image imageEntity = orgInfoEntity.getLogo();

				MImage image = new Query(Env.getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + " =?", null)
						.setParameters(imageEntity.getUuid()).first();
				if (image == null) {
					image = new MImage(Env.getCtx(), 0, null);
					image.saveEx(); // an existing image is required inorder to save the image in the file storage.
				}

				image.setName(imageEntity.getName());

				getFileStorage().save(image, getImageProvider(),
						Base64.getDecoder().decode(imageEntity.getBinaryData()));

				image.saveEx();

				orgInfo.setLogo_ID(image.get_ID());
			}

			orgInfo.saveEx();
		}

		return transformData(Collections.singletonList(getEntityByUuidFromDB(org.getAD_Org_UU()))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Operation Not Supported");
	}

	@Override
	protected Org createInstanceWithDefaultFields(MOrg instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Org createInstanceWithAllFields(MOrg instance) {
		Org result = new Org(instance);

		MOrgInfo_BH mOrgInfo = (MOrgInfo_BH) instance.getInfo();
		OrgInfo orgInfo = new OrgInfo(mOrgInfo);
		if (mOrgInfo.getLogo_ID() > 0) {
			MImage mImage = MImage.get(Env.getCtx(), mOrgInfo.getLogo_ID());
			Image image = new Image(mImage);
			// load image from drive and encode to string.
			image.setBinaryData(Base64.getEncoder().encodeToString(getFileStorage().load(mImage, getImageProvider())));
			orgInfo.setLogo(image);
		}

		result.setOrgInfo(orgInfo);

		return result;
	}

	@Override
	protected Org createInstanceWithSearchFields(MOrg instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MOrg getModelInstance() {
		return new MOrg(Env.getCtx(), 0, null);
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
