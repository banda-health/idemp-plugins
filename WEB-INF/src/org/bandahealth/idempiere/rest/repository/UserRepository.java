package org.bandahealth.idempiere.rest.repository;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.util.Env;

import java.sql.Timestamp;
import java.util.Properties;

public class UserRepository extends BaseRepository<MUser_BH> {
	@Override
	protected MUser_BH createModelInstance() {
		return new MUser_BH(Env.getCtx(), 0, null);
	}

	@Override
	public MUser_BH mapInputModelToModel(MUser_BH entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	/**
	 * User accepts terms of service.
	 */
	public MUser_BH acceptTermsOfUse() {
		MUser_BH user = new MUser_BH(Env.getCtx(), Env.getAD_User_ID(Env.getCtx()), null);
		user.setBH_HasAcceptedTermsOfUse(true);
		user.setBH_TOSDateAccepted(new Timestamp(System.currentTimeMillis()));
		user.save();

		return user;
	}
}
