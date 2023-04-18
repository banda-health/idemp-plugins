package org.bandahealth.idempiere.rest.service.db;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Image;
import org.bandahealth.idempiere.rest.model.Location;
import org.bandahealth.idempiere.rest.model.OrganizationInformation;
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
public class OrganizationInformationDBService extends BaseDBService<OrganizationInformation, MOrgInfo_BH> {

	private MStorageProvider imageProvider;
	private ImageFileStorageImpl fileStorage;

	/**
	 * Updates the OrganizationInfo object that's nested in Organization.
	 * 
	 */
	@Override
	public OrganizationInformation saveEntity(OrganizationInformation entity) {
		// get organization information
		MOrgInfo_BH organizationInfo = new Query(Env.getCtx(), MOrg.Table_Name, MOrgInfo_BH.COLUMNNAME_AD_OrgInfo_UU + " =?", null)
				.setParameters(entity.getUuid()).first();
		if (organizationInfo == null) {
			throw new AdempiereException("Missing organization information.");
		}

		// safe check in the event the implementation logic doesn't set this as a
		// required field
		if (entity != null) {
			if (StringUtil.isNotNullAndEmpty(entity.getHeaderMessage())) {
				organizationInfo.setBH_Header(entity.getHeaderMessage());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getFacilityNumber())) {
				organizationInfo.setBH_FacilityNumber(entity.getFacilityNumber());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getPaymentInformation())) {
				organizationInfo.setBH_PaymentInformation(entity.getPaymentInformation());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getPhone())) {
				organizationInfo.setPhone(entity.getPhone());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getReceiptFooterMessage())) {
				organizationInfo.setReceiptFooterMsg(entity.getReceiptFooterMessage());
			}

			// set location
			Location locationEntity = entity.getLocation();
			if (locationEntity != null) {
				MLocation location = MLocation.get(Env.getCtx(), organizationInfo.getC_Location_ID(), null);
				if (location == null) {
					location = new MLocation(Env.getCtx(), 0, null);
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress1())) {
					location.setAddress1(locationEntity.getAddress1());
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress2())) {
					location.setAddress2(locationEntity.getAddress2());
				}

				if (StringUtil.isNotNullAndEmpty(locationEntity.getAddress3())) {
					location.setAddress3(locationEntity.getAddress3());
				}

				location.saveEx();

				organizationInfo.setC_Location_ID(location.get_ID());
			}

			// set logo
			if (entity.getLogo() != null
					&& StringUtil.isNotNullAndEmpty(entity.getLogo().getBinaryData())) {
				Image imageEntity = entity.getLogo();

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

				organizationInfo.setLogo_ID(image.get_ID());
			}

			organizationInfo.saveEx();
		}

		return createInstanceWithAllFields(organizationInfo);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected OrganizationInformation createInstanceWithDefaultFields(MOrgInfo_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected OrganizationInformation createInstanceWithAllFields(MOrgInfo_BH instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected OrganizationInformation createInstanceWithSearchFields(MOrgInfo_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	public List<OrganizationInformation> transformData(List<MOrgInfo_BH> dbModels) {
		return dbModels.stream().map(mOrganizationInformation -> {
			OrganizationInformation organizationInfo = new OrganizationInformation(mOrganizationInformation);
			if (mOrganizationInformation.getLogo_ID() > 0) {	
				MImage mImage = MImage.get(Env.getCtx(), mOrganizationInformation.getLogo_ID());
				Image image = new Image(mImage);
				try {
					// load image from drive and encode to string.
					byte[] imageBytes = getFileStorage().load(mImage, getImageProvider());
					if (imageBytes != null) {
						image.setBinaryData(Base64.getEncoder().encodeToString(imageBytes));
						organizationInfo.setLogo(image);
					}
				} catch (Exception ex) {
					log.severe(ex.getMessage());
				}
			}

			if (mOrganizationInformation.getC_Location_ID() > 0) {
				MLocation mLocation = MLocation.get(Env.getCtx(), mOrganizationInformation.getC_Location_ID(), null);
				organizationInfo.setLocation(new Location(mLocation));
			}

			return organizationInfo;

		}).collect(Collectors.toList());
	}

	@Override
	protected MOrgInfo_BH getModelInstance() {
		return new MOrgInfo_BH(Env.getCtx(), null, null);
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
