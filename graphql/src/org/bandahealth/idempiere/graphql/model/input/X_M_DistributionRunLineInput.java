package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDistributionList;
import org.compiere.model.MDistributionRun;
import org.compiere.model.MDistributionRunLine;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DistributionRunLineInput extends MDistributionRunLine implements I_M_DistributionRunLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_DistributionList;
	private ForeignEntityInput mM_DistributionRun;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_DistributionRunLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_DistributionRunLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDistributionRunLine(null, (ResultSet) null, null),
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
	 * Set Distribution List.
	 *
	 * @param M_DistributionList Distribution Lists allow to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionList")
	public void setM_DistributionListInput(ForeignEntityInput M_DistributionList) {
		this.mM_DistributionList = M_DistributionList;
		if (M_DistributionList != null) {
			// Since an entity was passed, make sure it's in the DB
			MDistributionList foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DistributionList", "M_DistributionList_UU=?", get_TrxName())
							.setParameters(M_DistributionList.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DistributionList_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DistributionList with UUID " + M_DistributionList.getUUID());
			}
		} else {
			this.setM_DistributionList_ID(0);
		}
	}

	/**
	 * Get Distribution List.
	 *
	 * @return Distribution Lists allow to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionList")
	public ForeignEntityInput M_DistributionList() {
		return mM_DistributionList;
	}

	/**
	 * Set Distribution Run.
	 *
	 * @param M_DistributionRun Distribution Run create Orders to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionRun")
	public void setM_DistributionRunInput(ForeignEntityInput M_DistributionRun) {
		this.mM_DistributionRun = M_DistributionRun;
		if (get_ID() != 0) {
			return;
		}
		if (M_DistributionRun != null) {
			// Since an entity was passed, make sure it's in the DB
			MDistributionRun foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DistributionRun", "M_DistributionRun_UU=?", get_TrxName())
							.setParameters(M_DistributionRun.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_DistributionRun_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DistributionRun with UUID " + M_DistributionRun.getUUID());
			}
		} else {
			this.setM_DistributionRun_ID(0);
		}
	}

	/**
	 * Get Distribution Run.
	 *
	 * @return Distribution Run create Orders to distribute products to a selected list of partners
	 */
	@JsonProperty("M_DistributionRun")
	public ForeignEntityInput M_DistributionRun() {
		return mM_DistributionRun;
	}
	/**
	 * Set Distribution Run Line.
	 *
	 * @param M_DistributionRunLine_ID Distribution Run Lines define Distribution List, the Product and Quantities
	 */

	public void setM_DistributionRunLine_ID(int M_DistributionRunLine_ID) {
		if (get_ID() == 0) {
			super.setM_DistributionRunLine_ID(M_DistributionRunLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_DistributionRunLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_DistributionRunLine_UU();
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
}
