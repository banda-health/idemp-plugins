package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAttachment;
import org.compiere.model.MOrg;
import org.compiere.model.MStorageProvider;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Attachment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AttachmentInput extends MAttachment implements I_AD_AttachmentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_StorageProvider;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Attachment_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AttachmentInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Attachment.
	 *
	 * @param AD_Attachment_ID Attachment for the document
	 */
	@JsonProperty("AD_Attachment_ID")
	public void setAD_Attachment_IDFromJson(int AD_Attachment_ID) {
		if (get_ID() == 0) {
			super.setAD_Attachment_ID(AD_Attachment_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Attachment_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Attachment_UU();
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
							.setParameters(AD_StorageProvider.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_StorageProvider_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_StorageProvider with UU " + AD_StorageProvider.getUU());
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}
	/**
	 * Set Binary Data.
	 *
	 * @param BinaryData Binary Data
	 */
	@JsonProperty("BinaryData")
	public void setBinaryDataFromJson(byte[] BinaryData) {
		if (get_ID() == 0) {
			super.setBinaryData(BinaryData);
		}
	}
}
