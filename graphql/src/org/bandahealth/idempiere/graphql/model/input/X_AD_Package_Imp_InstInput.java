package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Package_Imp_Inst;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Package_Imp_Inst - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_InstInput extends X_AD_Package_Imp_Inst implements I_AD_Package_Imp_InstInput {

	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Package_Imp_Inst_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Package_Imp_InstInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_Package_Imp_Inst(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Package Imp. Inst..
	 *
	 * @param AD_Package_Imp_Inst_ID Package Imp. Inst.
	 */

	public void setAD_Package_Imp_Inst_ID(int AD_Package_Imp_Inst_ID) {
		if (get_ID() == 0) {
			super.setAD_Package_Imp_Inst_ID(AD_Package_Imp_Inst_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Package_Imp_Inst_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Package_Imp_Inst_UU();
	}
	/**
	 * Set CreatedDate.
	 *
	 * @param CreatedDate CreatedDate
	 */

	public void setCreatedDate(String CreatedDate) {
		if (get_ID() == 0) {
			super.setCreatedDate(CreatedDate);
		}
	}
}
