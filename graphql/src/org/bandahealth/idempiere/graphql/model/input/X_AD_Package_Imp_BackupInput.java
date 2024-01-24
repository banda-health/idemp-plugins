package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Package_Imp;
import org.compiere.model.X_AD_Package_Imp_Backup;
import org.compiere.model.X_AD_Package_Imp_Detail;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Imp_Backup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_BackupInput extends X_AD_Package_Imp_Backup implements I_AD_Package_Imp_BackupInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Package_Imp;
	private ForeignEntityInput mAD_Package_Imp_Detail;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Package_Imp_BackupInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_Package_Imp_Backup(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		MColumn foreignEntity;
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
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
	 * Set Imp. Package Backup.
	 *
	 * @param AD_Package_Imp_Backup_ID Imp. Package Backup
	 */

	public void setAD_Package_Imp_Backup_ID(int AD_Package_Imp_Backup_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Imp_Backup_ID(AD_Package_Imp_Backup_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Package_Imp_Backup_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Package_Imp_Backup_UU();
	}

	/**
	 * Set Imp. Package Detail.
	 *
	 * @param AD_Package_Imp_Detail Imp. Package Detail
	 */
	@JsonProperty("AD_Package_Imp_Detail")
	public void setAD_Package_Imp_DetailInput(ForeignEntityInput AD_Package_Imp_Detail) {
		this.mAD_Package_Imp_Detail = AD_Package_Imp_Detail;
		X_AD_Package_Imp_Detail foreignEntity;
		if (get_ID() == 0 && AD_Package_Imp_Detail != null &&
				(foreignEntity = new Query(getCtx(), "AD_Package_Imp_Detail", "AD_Package_Imp_Detail_UU=?", get_TrxName())
						.setParameters(AD_Package_Imp_Detail.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Package_Imp_Detail_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Imp. Package Detail.
	 *
	 * @return Imp. Package Detail
	 */
	@JsonProperty("AD_Package_Imp_Detail")
	public ForeignEntityInput AD_Package_Imp_Detail() {
		return mAD_Package_Imp_Detail;
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		MReference_BH foreignEntity;
		if (AD_Reference != null &&
				(foreignEntity = new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
						.setParameters(AD_Reference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Reference_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Reference_ID(0);
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public ForeignEntityInput AD_Reference() {
		return mAD_Reference;
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
}
