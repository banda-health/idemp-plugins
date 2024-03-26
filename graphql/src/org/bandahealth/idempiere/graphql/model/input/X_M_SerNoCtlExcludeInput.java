package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MSerNoCtlExclude;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_SerNoCtlExcludeInput extends MSerNoCtlExclude implements I_M_SerNoCtlExcludeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mM_SerNoCtl;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_SerNoCtlExclude_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_SerNoCtlExcludeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Table.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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

	/**
	 * Set Serial No Control.
	 *
	 * @param M_SerNoCtl Product Serial Number Control
	 */
	@JsonProperty("M_SerNoCtl")
	public void setM_SerNoCtlInput(ForeignEntityInput M_SerNoCtl) {
		this.mM_SerNoCtl = M_SerNoCtl;
		if (get_ID() != 0) {
			return;
		}
		if (M_SerNoCtl != null) {
			// Since an entity was passed, make sure it's in the DB
			MSerNoCtl_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_SerNoCtl", "M_SerNoCtl_UU=?", get_TrxName())
							.setParameters(M_SerNoCtl.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_SerNoCtl_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_SerNoCtl with UUID " + M_SerNoCtl.getUUID());
			}
		} else {
			this.setM_SerNoCtl_ID(0);
		}
	}

	/**
	 * Get Serial No Control.
	 *
	 * @return Product Serial Number Control
	 */
	@JsonProperty("M_SerNoCtl")
	public ForeignEntityInput M_SerNoCtl() {
		return mM_SerNoCtl;
	}
	/**
	 * Set Exclude Ser No.
	 *
	 * @param M_SerNoCtlExclude_ID Exclude the ability to create Serial Numbers in Attribute Sets
	 */

	public void setM_SerNoCtlExclude_ID(int M_SerNoCtlExclude_ID) {
		if (get_ID() == 0) {
			super.setM_SerNoCtlExclude_ID(M_SerNoCtlExclude_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_SerNoCtlExclude_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_SerNoCtlExclude_UU();
	}
}
