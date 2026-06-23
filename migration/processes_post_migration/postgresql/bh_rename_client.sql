-- Reusable function to rename a clinic (AD_Client) and cascade the new name to every
-- display name derived from it: the client itself, its org, its store rooms (warehouses,
-- including multi-store-room names like "<clinic> Pharmacy"),
-- the prefixed role and tree names, the accounting schema, the calendar, any bank /
-- bank account named with the full clinic name as a prefix, and the value (search-key)
-- columns that hold the clinic name (ad_client/ad_org/m_warehouse/m_locator .value).
-- All rewrites are anchored full-prefix, so value columns holding an abbreviation ("MCH"),
-- "Standard", or a numeric id simply do not match and are left untouched. Runs in the
-- caller's transaction so the whole rename commits or rolls back atomically. Returns a
-- human-readable summary.
--
-- NOTE: this does raw UPDATEs and therefore bypasses the iDempiere PO layer -- it does
-- NOT write AD_ChangeLog rows and does NOT reset the in-memory cache. The calling
-- process (RenameClientProcess) is responsible for CacheMgt.reset() and audit lives in
-- AD_PInstance.
--
-- Params: _ad_client_id : the client (clinic) to rename
--         _new_name      : the new clinic name
--         _updatedby     : AD_User_ID performing the change (for audit columns)
DROP FUNCTION IF EXISTS bh_rename_client(_ad_client_id numeric, _new_name character varying, _updatedby numeric);
CREATE OR REPLACE FUNCTION bh_rename_client(_ad_client_id numeric, _new_name character varying, _updatedby numeric)
	RETURNS text
	LANGUAGE plpgsql
AS
$$
DECLARE
	_old_name      varchar;
	_old_clientval varchar;
	_new_name_trim varchar := BTRIM(_new_name);
	_orgs          integer := 0;
	_warehouses    integer := 0;
	_roles         integer := 0;
	_trees         integer := 0;
	_acctschemas   integer := 0;
	_calendars     integer := 0;
	_banks         integer := 0;
	_bankaccounts  integer := 0;
	_locators      integer := 0;
	_clientvals    integer := 0;
	_orgvals       integer := 0;
	_warehousevals integer := 0;
BEGIN
	-- Guard: client must exist (and not be the system client)
	SELECT name INTO _old_name FROM ad_client WHERE ad_client_id = _ad_client_id AND ad_client_id > 0;
	IF _old_name IS NULL THEN
		RAISE EXCEPTION 'No client found with AD_Client_ID = %', _ad_client_id;
	END IF;

	-- Guard: new name must be non-blank
	IF _new_name_trim IS NULL OR _new_name_trim = '' THEN
		RAISE EXCEPTION 'New clinic name must not be blank';
	END IF;

	-- Guard: nothing to do if unchanged
	IF _new_name_trim = _old_name THEN
		RAISE EXCEPTION 'New clinic name is the same as the current name (%)', _old_name;
	END IF;

	-- Guard: the name must not collide with another client
	IF EXISTS (
		SELECT 1 FROM ad_client WHERE name = _new_name_trim AND ad_client_id <> _ad_client_id
	) THEN
		RAISE EXCEPTION 'Another client is already named "%"', _new_name_trim;
	END IF;

	-- Guard: updating user must be provided (audit columns updatedby are NOT NULL)
	IF _updatedby IS NULL THEN
		RAISE EXCEPTION 'Updating user (AD_User_ID) must be provided';
	END IF;

	-- Guard: the existing name must be non-blank, otherwise the prefix anchor LEFT(x, 0) = ''
	-- would match and rewrite every client-scoped row.
	IF BTRIM(_old_name) = '' THEN
		RAISE EXCEPTION 'Current clinic name is blank; cannot safely rename';
	END IF;

	-- Over-length derived names/values are truncated per column in the UPDATEs below (value=40, name=60,
	-- ad_role.name=400), matching how iDempiere's PO layer (set_Value) truncates over-length values. A
	-- NOTICE is emitted so it is visible in the log, mirroring set_Value's "Value too long - truncated"
	-- warning. (ad_client.name / ad_org.name are set to the name directly, so a name > 60 is also clipped.)
	IF LENGTH(_new_name_trim) > 40 THEN
		RAISE NOTICE 'New clinic name is % characters; derived names/values longer than their column (value=40, name=60) are truncated', LENGTH(_new_name_trim);
	END IF;

	-- Guard: the rewritten client value must not collide with another client's value. ad_client.value
	-- has a GLOBAL unique index, which the name-collision guard above does not cover.
	SELECT value INTO _old_clientval FROM ad_client WHERE ad_client_id = _ad_client_id;
	IF LEFT(_old_clientval, LENGTH(_old_name)) = _old_name
		AND EXISTS (
			SELECT
				1
			FROM
				ad_client
			WHERE
				value = LEFT(_new_name_trim || SUBSTR(_old_clientval, LENGTH(_old_name) + 1), 40)
				AND ad_client_id <> _ad_client_id
		) THEN
		RAISE EXCEPTION 'Another client already uses the search key "%"',
			LEFT(_new_name_trim || SUBSTR(_old_clientval, LENGTH(_old_name) + 1), 40);
	END IF;

	-- Guard: the renamed warehouse must not collide with another warehouse in the same client
	-- (m_warehouse has a unique index on (ad_client_id, name); e.g. renaming a clinic to "Standard").
	IF EXISTS (
		SELECT
			1
		FROM
			m_warehouse
		WHERE
			ad_client_id = _ad_client_id
			AND name = _new_name_trim
			AND name <> _old_name
	) THEN
		RAISE EXCEPTION 'Client already has a warehouse named "%"', _new_name_trim;
	END IF;

	-- The remaining per-client unique indexes (ad_org.value, ad_tree.name, c_acctschema.name,
	-- c_calendar.name, m_warehouse.value) are near-unreachable here and remain protected by the
	-- atomic transaction: any violation rolls back the whole rename.

	-- 1. The client record itself
	UPDATE ad_client
	SET
		name      = LEFT(_new_name_trim, 60),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id;

	-- 2. The client's org(s) named after the clinic (skip the system/* org 0)
	UPDATE ad_org
	SET
		name      = LEFT(_new_name_trim, 60),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND ad_org_id > 0
		AND name = _old_name;
	GET DIAGNOSTICS _orgs = ROW_COUNT;

	-- 3. Store rooms (warehouses): anchored prefix rewrite "<old> <suffix>" -> "<new> <suffix>".
	-- A client can have several store rooms named "<clinic> Pharmacy", "<clinic> Maternity", etc., as
	-- well as the base "<clinic>" one - all carry the clinic-name prefix. "Standard" and custom-named
	-- store rooms ("Maternity", "Main Store") do not start with the old name and are left alone.
	UPDATE m_warehouse
	SET
		name      = LEFT(_new_name_trim || SUBSTR(name, LENGTH(_old_name) + 1), 60),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(name, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _warehouses = ROW_COUNT;

	-- 4. Roles: anchored prefix rewrite "<old> <suffix>" -> "<new> <suffix>".
	-- left(name, len) = _old_name avoids LIKE wildcard pitfalls if the name has % or _.
	UPDATE ad_role
	SET
		name      = LEFT(_new_name_trim || SUBSTR(name, LENGTH(_old_name) + 1), 400),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(name, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _roles = ROW_COUNT;

	-- 5. Trees: anchored prefix rewrite, same approach as roles
	UPDATE ad_tree
	SET
		name      = LEFT(_new_name_trim || SUBSTR(name, LENGTH(_old_name) + 1), 60),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(name, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _trees = ROW_COUNT;

	-- 6. Accounting schema: anchored prefix rewrite "<old> <currency suffix>" -> "<new> <currency suffix>"
	UPDATE c_acctschema
	SET
		name      = LEFT(_new_name_trim || SUBSTR(name, LENGTH(_old_name) + 1), 60),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(name, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _acctschemas = ROW_COUNT;

	-- 7. Calendar: anchored prefix rewrite "<old> Calendar" -> "<new> Calendar"
	UPDATE c_calendar
	SET
		name      = LEFT(_new_name_trim || SUBSTR(name, LENGTH(_old_name) + 1), 60),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(name, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _calendars = ROW_COUNT;

	-- 8. Banks: anchored FULL-prefix rewrite only. c_bank.name is free-form, so this updates only banks
	-- named with the complete old clinic name as a prefix (e.g. "<clinic> Account/Bank/Banker" or exact).
	-- Real bank names ("Equity Bank") and partial/abbreviated ones ("Matangwe Bank") are intentionally
	-- left alone, since rewriting those would be a wrong guess.
	UPDATE c_bank
	SET
		name      = LEFT(_new_name_trim || SUBSTR(name, LENGTH(_old_name) + 1), 60),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(name, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _banks = ROW_COUNT;

	-- 9. Bank accounts: same conservative FULL-prefix rewrite as banks. Setup names them
	-- "<clinic> <accountName> Account", but they are often manually shortened (e.g. "Matangwe Hospital
	-- Account"), so only accounts starting with the complete old clinic name are updated.
	UPDATE c_bankaccount
	SET
		name      = LEFT(_new_name_trim || SUBSTR(name, LENGTH(_old_name) + 1), 60),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(name, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _bankaccounts = ROW_COUNT;

	-- 10. Locators: the locator VALUE holds the clinic name (setup sets value = org name). This is the one
	-- value column that carries the name rather than an identifier, so rewrite it (full-prefix only).
	-- "Standard" locators and numeric-id values are left alone.
	UPDATE m_locator
	SET
		value     = LEFT(_new_name_trim || SUBSTR(value, LENGTH(_old_name) + 1), 40),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(value, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _locators = ROW_COUNT;

	-- 11-13. Value columns that hold the clinic name. Setup sets these search keys to the client/org name
	-- for most clients, but some hold an abbreviation ("MCH"), "Standard", or a numeric id. Use the same
	-- full-prefix rewrite so only the name-bearing ones change; abbreviations/ids/Standard are left alone.
	UPDATE ad_client
	SET
		value     = LEFT(_new_name_trim || SUBSTR(value, LENGTH(_old_name) + 1), 40),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(value, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _clientvals = ROW_COUNT;

	UPDATE ad_org
	SET
		value     = LEFT(_new_name_trim || SUBSTR(value, LENGTH(_old_name) + 1), 40),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND ad_org_id > 0
		AND LEFT(value, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _orgvals = ROW_COUNT;

	UPDATE m_warehouse
	SET
		value     = LEFT(_new_name_trim || SUBSTR(value, LENGTH(_old_name) + 1), 40),
		updated   = NOW(),
		updatedby = _updatedby
	WHERE
		ad_client_id = _ad_client_id
		AND LEFT(value, LENGTH(_old_name)) = _old_name;
	GET DIAGNOSTICS _warehousevals = ROW_COUNT;

	-- NOTE: deliberately NOT renamed - ad_user names and emails (setup derives "<NoSpaceClinic>Admin/User"
	-- and "admin@<clinic>.org", but users are people / login identity) and default-named records
	-- (price lists, charges, product categories, attribute sets) which are not client-derived.

	RETURN FORMAT(
			'Renamed client %s from "%s" to "%s": %s org(s), %s warehouse(s), %s role(s), %s tree(s), '
				|| '%s acct schema(s), %s calendar(s), %s bank(s), %s bank account(s), %s locator(s), '
				|| '%s client value(s), %s org value(s), %s warehouse value(s) updated.',
			_ad_client_id, _old_name, _new_name_trim, _orgs, _warehouses, _roles, _trees, _acctschemas,
			_calendars, _banks, _bankaccounts, _locators, _clientvals, _orgvals, _warehousevals);
END;
$$;
