package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShipper;
import org.compiere.model.MShipperPackaging;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShipperPackagingCfg;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingInput extends MShipperPackaging implements I_M_ShipperPackagingInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Shipper;
	private ForeignEntityInput mM_ShipperPackagingCfg;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShipperPackagingInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MShipperPackaging(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Shipper.
	 *
	 * @param M_Shipper Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public void setM_ShipperInput(ForeignEntityInput M_Shipper) {
		this.mM_Shipper = M_Shipper;
		MShipper foreignEntity;
		if (get_ID() == 0 && M_Shipper != null &&
				(foreignEntity = new Query(getCtx(), "M_Shipper", "M_Shipper_UU=?", get_TrxName())
						.setParameters(M_Shipper.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Shipper_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipper.
	 *
	 * @return Method or manner of product delivery
	 */
	@JsonProperty("M_Shipper")
	public ForeignEntityInput M_Shipper() {
		return mM_Shipper;
	}
	/**
	 * Set Shipper Packaging.
	 *
	 * @param M_ShipperPackaging_ID Shipper Packaging
	 */

	public void setM_ShipperPackaging_ID(int M_ShipperPackaging_ID) {
		if (get_ID() == 0) {
			super.setM_ShipperPackaging_ID(M_ShipperPackaging_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShipperPackaging_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShipperPackaging_UU();
	}

	/**
	 * Set Shipper Packaging Configuration.
	 *
	 * @param M_ShipperPackagingCfg Shipper Packaging Configuration
	 */
	@JsonProperty("M_ShipperPackagingCfg")
	public void setM_ShipperPackagingCfgInput(ForeignEntityInput M_ShipperPackagingCfg) {
		this.mM_ShipperPackagingCfg = M_ShipperPackagingCfg;
		X_M_ShipperPackagingCfg foreignEntity;
		if (M_ShipperPackagingCfg != null &&
				(foreignEntity = new Query(getCtx(), "M_ShipperPackagingCfg", "M_ShipperPackagingCfg_UU=?", get_TrxName())
						.setParameters(M_ShipperPackagingCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShipperPackagingCfg_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShipperPackagingCfg_ID(0);
		}
	}

	/**
	 * Get Shipper Packaging Configuration.
	 *
	 * @return Shipper Packaging Configuration
	 */
	@JsonProperty("M_ShipperPackagingCfg")
	public ForeignEntityInput M_ShipperPackagingCfg() {
		return mM_ShipperPackagingCfg;
	}
}
