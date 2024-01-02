package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetDelivery;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrg;
import org.compiere.model.MProductDownload;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_DeliveryInput extends MAssetDelivery implements I_A_Asset_DeliveryInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_UserInput mAD_User;
	 private I_A_AssetInput mA_Asset;
	 private I_M_InOutLineInput mM_InOutLine;
	 private I_M_ProductDownloadInput mM_ProductDownload;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_DeliveryInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Delivery_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Delivery_UU();
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(I_A_AssetInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 &&A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public I_A_AssetInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set User/Contact.
	 *
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(I_AD_UserInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (get_ID() == 0 &&AD_User != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public I_AD_UserInput AD_User() {
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
	public void setM_InOutLineInput(I_M_InOutLineInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 &&M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOutLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public I_M_InOutLineInput M_InOutLine() {
		return mM_InOutLine;
	}

	/**
	 * Set Product Download.
	 *
	 * @param M_ProductDownload Product downloads
	 */
	@JsonProperty("M_ProductDownload")
	public void setM_ProductDownloadInput(I_M_ProductDownloadInput M_ProductDownload) {
		this.mM_ProductDownload = M_ProductDownload;
		MProductDownload foreignEntity;
		if (M_ProductDownload != null &&
				(foreignEntity = new Query(getCtx(), MProductDownload.Table_Name, MProductDownload.COLUMNNAME_M_ProductDownload_UU + "=?", get_TrxName())
						.setParameters(M_ProductDownload.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductDownload_ID(foreignEntity.get_ID());
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
	public I_M_ProductDownloadInput M_ProductDownload() {
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
