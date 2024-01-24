package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetDelivery;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrg;
import org.compiere.model.MProductDownload;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for A_Asset_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_DeliveryInput extends MAssetDelivery implements I_A_Asset_DeliveryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_ProductDownload;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Delivery_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_DeliveryInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAssetDelivery(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Asset Delivery.
	 *
	 * @param A_Asset_Delivery_ID Delivery of Asset
	 */

	public void setA_Asset_Delivery_ID(int A_Asset_Delivery_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Delivery_ID(A_Asset_Delivery_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Asset_Delivery_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Asset_Delivery_UU();
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 && A_Asset != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
	/**
	 * Set EMail Address.
	 *
	 * @param EMail Electronic Mail Address
	 */

	public void setEMail(String EMail) {
		if (get_ID() == 0) {
			super.setEMail(EMail);
		}
	}
	/**
	 * Set Lot No.
	 *
	 * @param Lot Lot number (alphanumeric)
	 */

	public void setLot(String Lot) {
		if (get_ID() == 0) {
			super.setLot(Lot);
		}
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 && M_InOutLine != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
							.setParameters(M_InOutLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InOutLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOutLine with UUID " + M_InOutLine.getUUID());
			}
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public ForeignEntityInput M_InOutLine() {
		return mM_InOutLine;
	}

	/**
	 * Set Product Download.
	 *
	 * @param M_ProductDownload Product downloads
	 */
	@JsonProperty("M_ProductDownload")
	public void setM_ProductDownloadInput(ForeignEntityInput M_ProductDownload) {
		this.mM_ProductDownload = M_ProductDownload;
		MProductDownload foreignEntity;
		if (M_ProductDownload != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_ProductDownload", "M_ProductDownload_UU=?", get_TrxName())
							.setParameters(M_ProductDownload.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ProductDownload_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ProductDownload with UUID " + M_ProductDownload.getUUID());
			}
		} else {
			super.setM_ProductDownload_ID(0);
		}
	}

	/**
	 * Get Product Download.
	 *
	 * @return Product downloads
	 */
	@JsonProperty("M_ProductDownload")
	public ForeignEntityInput M_ProductDownload() {
		return mM_ProductDownload;
	}
	/**
	 * Set Message ID.
	 *
	 * @param MessageID EMail Message ID
	 */

	public void setMessageID(String MessageID) {
		if (get_ID() == 0) {
			super.setMessageID(MessageID);
		}
	}
	/**
	 * Set Movement Date.
	 *
	 * @param MovementDate Date a product was moved in or out of inventory
	 */

	public void setMovementDate(Timestamp MovementDate) {
		if (get_ID() == 0) {
			super.setMovementDate(MovementDate);
		}
	}
	/**
	 * Set Referrer.
	 *
	 * @param Referrer Referring web address
	 */

	public void setReferrer(String Referrer) {
		if (get_ID() == 0) {
			super.setReferrer(Referrer);
		}
	}
	/**
	 * Set Remote Addr.
	 *
	 * @param Remote_Addr Remote Address
	 */

	public void setRemote_Addr(String Remote_Addr) {
		if (get_ID() == 0) {
			super.setRemote_Addr(Remote_Addr);
		}
	}
	/**
	 * Set Remote Host.
	 *
	 * @param Remote_Host Remote host Info
	 */

	public void setRemote_Host(String Remote_Host) {
		if (get_ID() == 0) {
			super.setRemote_Host(Remote_Host);
		}
	}
	/**
	 * Set Serial No.
	 *
	 * @param SerNo Product Serial Number 
	 */

	public void setSerNo(String SerNo) {
		if (get_ID() == 0) {
			super.setSerNo(SerNo);
		}
	}
	/**
	 * Set URL.
	 *
	 * @param URL Full URL address - e.g. http://www.idempiere.org
	 */

	public void setURL(String URL) {
		if (get_ID() == 0) {
			super.setURL(URL);
		}
	}
	/**
	 * Set Version No.
	 *
	 * @param VersionNo Version Number
	 */

	public void setVersionNo(String VersionNo) {
		if (get_ID() == 0) {
			super.setVersionNo(VersionNo);
		}
	}
}
