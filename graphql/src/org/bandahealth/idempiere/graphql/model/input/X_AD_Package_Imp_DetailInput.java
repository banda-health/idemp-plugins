package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Package_Imp;
import org.compiere.model.X_AD_Package_Imp_Detail;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Imp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Package_Imp_DetailInput extends X_AD_Package_Imp_Detail implements I_AD_Package_Imp_DetailInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Package_Imp;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Package_Imp_Detail_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Package_Imp_DetailInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * Set Imp. Package Detail.
	 *
	 * @param AD_Package_Imp_Detail_ID Imp. Package Detail
	 */
	@JsonProperty("AD_Package_Imp_Detail_ID")
	public void setAD_Package_Imp_Detail_IDFromJson(int AD_Package_Imp_Detail_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Imp_Detail_ID(AD_Package_Imp_Detail_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Package_Imp_Detail_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Package_Imp != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Package_Imp foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Package_Imp", "AD_Package_Imp_UU=?", get_TrxName())
							.setParameters(AD_Package_Imp.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Package_Imp_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Package_Imp with UU " + AD_Package_Imp.getUU());
			}
		} else {
			this.setAD_Package_Imp_ID(0);
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
	 * Set Result.
	 *
	 * @param Result Result of the action taken
	 */
	@JsonProperty("Result")
	public void setResultFromJson(String Result) {
		if (get_ID() == 0) {
			super.setResult(Result);
		}
	}
	/**
	 * Set Uninstall.
	 *
	 * @param Uninstall Uninstall
	 */
	@JsonProperty("Uninstall")
	public void setUninstallFromJson(boolean Uninstall) {
		if (get_ID() == 0) {
			super.setUninstall(Uninstall);
		}
	}
}
