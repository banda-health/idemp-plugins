package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MStorageProvider;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Image - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ImageInput extends MImage implements I_AD_ImageInput {

	private ForeignEntityInput mAD_EntityType;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_StorageProvider;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Image_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_ImageInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Image.
	 *
	 * @param AD_Image_ID Image or Icon
	 */

	public void setAD_Image_ID(int AD_Image_ID) {
		if (get_ID() == 0) {
			super.setAD_Image_ID(AD_Image_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Image_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Image_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Storage Provider.
	 *
	 * @param AD_StorageProvider Storage Provider
	 */
	@JsonProperty("AD_StorageProvider")
	public void setAD_StorageProviderInput(ForeignEntityInput AD_StorageProvider) {
		this.mAD_StorageProvider = AD_StorageProvider;
		if (get_ID() != 0) {
			return;
		}
		if (AD_StorageProvider != null) {
			// Since an entity was passed, make sure it's in the DB
			MStorageProvider foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_StorageProvider", "AD_StorageProvider_UU=?", get_TrxName())
							.setParameters(AD_StorageProvider.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_StorageProvider_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_StorageProvider with UUID " + AD_StorageProvider.getUUID());
			}
		} else {
			this.setAD_StorageProvider_ID(0);
		}
	}

	/**
	 * Get Storage Provider.
	 *
	 * @return Storage Provider
	 */
	@JsonProperty("AD_StorageProvider")
	public ForeignEntityInput AD_StorageProvider() {
		return mAD_StorageProvider;
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public void setAD_EntityTypeInput(ForeignEntityInput AD_EntityType) {
		this.mAD_EntityType = AD_EntityType;
		if (AD_EntityType != null) {
			// Since an entity was passed, make sure it's in the DB
			MEntityType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_EntityType", "AD_EntityType_UU=?", get_TrxName())
							.setParameters(AD_EntityType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setEntityType(foreignEntity.getEntityType());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_EntityType with UUID " + AD_EntityType.getUUID());
			}
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	@JsonProperty("AD_EntityType")
	public ForeignEntityInput AD_EntityType() {
		return mAD_EntityType;
	}
}
