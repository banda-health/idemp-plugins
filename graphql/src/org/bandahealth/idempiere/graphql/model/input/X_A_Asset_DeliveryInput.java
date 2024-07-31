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
 * @version Release 11 - $Id$
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
	 * @param UU The A_Asset_Delivery_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_DeliveryInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Asset Delivery.
	 *
	 * @param A_Asset_Delivery_ID Delivery of Asset
	 */
	@JsonProperty("A_Asset_Delivery_ID")
	public void setA_Asset_Delivery_IDFromJson(int A_Asset_Delivery_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Delivery_ID(A_Asset_Delivery_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Asset_Delivery_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Asset.getUU());
			}
		} else {
			this.setA_Asset_ID(0);
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
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (get_ID() != 0) {
			return;
		}
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
	@JsonProperty("EMail")
	public void setEMailFromJson(String EMail) {
		if (get_ID() == 0) {
			super.setEMail(EMail);
		}
	}
	/**
	 * Set Lot No.
	 *
	 * @param Lot Lot number (alphanumeric)
	 */
	@JsonProperty("Lot")
	public void setLotFromJson(String Lot) {
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
		if (get_ID() != 0) {
			return;
		}
		if (M_InOutLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInOutLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
							.setParameters(M_InOutLine.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_InOutLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOutLine with UU " + M_InOutLine.getUU());
			}
		} else {
			this.setM_InOutLine_ID(0);
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
		if (M_ProductDownload != null) {
			// Since an entity was passed, make sure it's in the DB
			MProductDownload foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ProductDownload", "M_ProductDownload_UU=?", get_TrxName())
							.setParameters(M_ProductDownload.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ProductDownload_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ProductDownload with UU " + M_ProductDownload.getUU());
			}
		} else {
			this.setM_ProductDownload_ID(0);
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
	@JsonProperty("MessageID")
	public void setMessageIDFromJson(String MessageID) {
		if (get_ID() == 0) {
			super.setMessageID(MessageID);
		}
	}
	/**
	 * Set Movement Date.
	 *
	 * @param MovementDate Date a product was moved in or out of inventory
	 */
	@JsonProperty("MovementDate")
	public void setMovementDateFromJson(Timestamp MovementDate) {
		if (get_ID() == 0) {
			super.setMovementDate(MovementDate);
		}
	}
	/**
	 * Set Referrer.
	 *
	 * @param Referrer Referring web address
	 */
	@JsonProperty("Referrer")
	public void setReferrerFromJson(String Referrer) {
		if (get_ID() == 0) {
			super.setReferrer(Referrer);
		}
	}
	/**
	 * Set Remote Addr.
	 *
	 * @param Remote_Addr Remote Address
	 */
	@JsonProperty("Remote_Addr")
	public void setRemote_AddrFromJson(String Remote_Addr) {
		if (get_ID() == 0) {
			super.setRemote_Addr(Remote_Addr);
		}
	}
	/**
	 * Set Remote Host.
	 *
	 * @param Remote_Host Remote host Info
	 */
	@JsonProperty("Remote_Host")
	public void setRemote_HostFromJson(String Remote_Host) {
		if (get_ID() == 0) {
			super.setRemote_Host(Remote_Host);
		}
	}
	/**
	 * Set Serial No.
	 *
	 * @param SerNo Product Serial Number 
	 */
	@JsonProperty("SerNo")
	public void setSerNoFromJson(String SerNo) {
		if (get_ID() == 0) {
			super.setSerNo(SerNo);
		}
	}
	/**
	 * Set URL.
	 *
	 * @param URL Full URL address - e.g. http://www.idempiere.org
	 */
	@JsonProperty("URL")
	public void setURLFromJson(String URL) {
		if (get_ID() == 0) {
			super.setURL(URL);
		}
	}
	/**
	 * Set Version No.
	 *
	 * @param VersionNo Version Number
	 */
	@JsonProperty("VersionNo")
	public void setVersionNoFromJson(String VersionNo) {
		if (get_ID() == 0) {
			super.setVersionNo(VersionNo);
		}
	}
}
