package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Package_Imp;
import org.compiere.model.X_AD_Package_Imp_Backup;
import org.compiere.model.X_AD_Package_Imp_Detail;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Imp_Backup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Package_Imp_BackupInput extends X_AD_Package_Imp_Backup implements I_AD_Package_Imp_BackupInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Package_Imp;
	private ForeignEntityInput mAD_Package_Imp_Detail;
	private ForeignEntityInput mAD_Reference;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Package_Imp_Backup_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Package_Imp_BackupInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_Package_Imp_Backup(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		if (AD_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UUID " + AD_Column.getUUID());
			}
		} else {
			this.setAD_Column_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Package_Imp_Backup_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Package_Imp_Detail != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Package_Imp_Detail foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Package_Imp_Detail", "AD_Package_Imp_Detail_UU=?", get_TrxName())
							.setParameters(AD_Package_Imp_Detail.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Package_Imp_Detail_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Package_Imp_Detail with UUID " + AD_Package_Imp_Detail.getUUID());
			}
		} else {
			this.setAD_Package_Imp_Detail_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Package_Imp != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Package_Imp foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Package_Imp", "AD_Package_Imp_UU=?", get_TrxName())
							.setParameters(AD_Package_Imp.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Package_Imp_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Package_Imp with UUID " + AD_Package_Imp.getUUID());
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		if (AD_Reference != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference.getUUID());
			}
		} else {
			this.setAD_Reference_ID(0);
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
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UUID " + AD_Table.getUUID());
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
}
