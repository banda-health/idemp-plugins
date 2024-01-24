package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Package_Imp;
import org.compiere.model.X_AD_Package_Imp_Detail;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Imp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_DetailInput extends X_AD_Package_Imp_Detail implements I_AD_Package_Imp_DetailInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Package_Imp;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Package_Imp_DetailInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_Package_Imp_Detail(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Imp. Package Detail.
	 *
	 * @param AD_Package_Imp_Detail_ID Imp. Package Detail
	 */

	public void setAD_Package_Imp_Detail_ID(int AD_Package_Imp_Detail_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Imp_Detail_ID(AD_Package_Imp_Detail_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Package_Imp_Detail_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Package_Imp_Detail_UU();
	}

	/**
	 * Set Package Imp..
	 *
	 * @param AD_Package_Imp Package Imp.
	 */
	@JsonProperty("AD_Package_Imp")
	public void setAD_Package_ImpInput(ForeignEntityInput AD_Package_Imp) {
		this.mAD_Package_Imp = AD_Package_Imp;
		X_AD_Package_Imp foreignEntity;
		if (get_ID() == 0 && AD_Package_Imp != null &&
				(foreignEntity = new Query(getCtx(), "AD_Package_Imp", "AD_Package_Imp_UU=?", get_TrxName())
						.setParameters(AD_Package_Imp.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Package_Imp_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Package Imp..
	 *
	 * @return Package Imp.
	 */
	@JsonProperty("AD_Package_Imp")
	public ForeignEntityInput AD_Package_Imp() {
		return mAD_Package_Imp;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
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
	 * Set Uninstall.
	 *
	 * @param Uninstall Uninstall
	 */

	public void setUninstall(boolean Uninstall) {
		if (get_ID() == 0) {
			super.setUninstall(Uninstall);
		}
	}
}
