--Update the role name column to be longer
UPDATE ad_column
SET
	fieldlength = 400
WHERE
	ad_column_id = 532;

-- First drop views that depend on this column
DROP VIEW ad_allroles_v;
DROP VIEW ad_alluserroles_v;
DROP VIEW ad_sessioninfo_v;
DROP VIEW ad_user_roles_v;

ALTER TABLE ad_role
	ALTER COLUMN name TYPE VARCHAR(400);

-- Recreate drop views that depend on this column
CREATE OR REPLACE VIEW ad_allroles_v
		(ad_client_id, ad_org_id, ad_allroles_v_id, ad_allroles_v_uu, created, createdby, updated, updatedby, isactive,
		 name, description, userlevel, ismanual, isshowacct, ispersonallock, ispersonalaccess, iscanexport, iscanreport,
		 isaccessallorgs, ischangelog, preferencetype, isuseuserorgaccess, ismasterrole, isaccessadvanced, roletype,
		 ad_allclients_v_id)
AS
SELECT
	0            AS ad_client_id,
	0            AS ad_org_id,
	ad_role_id   AS ad_allroles_v_id,
	ad_role_uu   AS ad_allroles_v_uu,
	created,
	createdby,
	updated,
	updatedby,
	isactive,
	name,
	description,
	userlevel,
	ismanual,
	isshowacct,
	ispersonallock,
	ispersonalaccess,
	iscanexport,
	iscanreport,
	isaccessallorgs,
	ischangelog,
	preferencetype,
	isuseuserorgaccess,
	ismasterrole,
	isaccessadvanced,
	roletype,
	ad_client_id AS ad_allclients_v_id
FROM
	ad_role;
CREATE OR REPLACE VIEW ad_alluserroles_v
		(ad_client_id, ad_org_id, ad_allusers_v_id, ad_allclients_v_id, isactive, created, createdby, updated, updatedby,
		 ad_alluserroles_v_uu, name, description, userlevel, ismanual, isshowacct, ispersonallock, ispersonalaccess,
		 iscanexport, iscanreport, isaccessallorgs, ischangelog, preferencetype, isuseuserorgaccess, ismasterrole,
		 isaccessadvanced, roletype, ad_allroles_v_id)
AS
SELECT
	0                              AS ad_client_id,
	0                              AS ad_org_id,
	ad_user_roles.ad_user_id       AS ad_allusers_v_id,
	ad_role.ad_client_id           AS ad_allclients_v_id,
	CASE
		WHEN ad_user_roles.isactive = 'N'::bpchar THEN ad_user_roles.isactive
		ELSE ad_role.isactive
		END                          AS isactive,
	ad_user_roles.created,
	ad_user_roles.createdby,
	ad_user_roles.updated,
	ad_user_roles.updatedby,
	ad_user_roles.ad_user_roles_uu AS ad_alluserroles_v_uu,
	ad_role.name,
	ad_role.description,
	ad_role.userlevel,
	ad_role.ismanual,
	ad_role.isshowacct,
	ad_role.ispersonallock,
	ad_role.ispersonalaccess,
	ad_role.iscanexport,
	ad_role.iscanreport,
	ad_role.isaccessallorgs,
	ad_role.ischangelog,
	ad_role.preferencetype,
	ad_role.isuseuserorgaccess,
	ad_role.ismasterrole,
	ad_role.isaccessadvanced,
	ad_role.roletype,
	ad_role.ad_role_id             AS ad_allroles_v_id
FROM
	ad_user_roles
		JOIN ad_role
		ON ad_role.ad_role_id = ad_user_roles.ad_role_id;
CREATE OR REPLACE VIEW ad_sessioninfo_v
		(ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, websession, remote_addr, remote_host,
		 rolename, logindate, ad_session_uu, servername, clientname, orgname, ad_sessioninfo_v_id, ad_sessioninfo_v_uu,
		 loginname, email, ldapuser, description, ad_session_id)
AS
SELECT
	0                                    AS ad_client_id,
	0                                    AS ad_org_id,
	s.isactive,
	s.created,
	s.createdby,
	s.updated,
	s.updatedby,
	SUBSTR(s.websession::text, 1, 40)    AS websession,
	SUBSTR(s.remote_addr::text, 1, 60)   AS remote_addr,
	SUBSTR(s.remote_host::text, 1, 120)  AS remote_host,
	SUBSTR(r.name::text, 1, 60)          AS rolename,
	s.logindate,
	s.ad_session_uu,
	SUBSTR(s.servername::text, 1, 80)    AS servername,
	SUBSTR(c.name::text, 1, 60)          AS clientname,
	SUBSTR(o.name::text, 1, 60)          AS orgname,
	s.ad_session_id                      AS ad_sessioninfo_v_id,
	s.ad_session_uu                      AS ad_sessioninfo_v_uu,
	SUBSTR(u.name::text, 1, 60)          AS loginname,
	SUBSTR(u.email::text, 1, 60)         AS email,
	SUBSTR(u.ldapuser::text, 1, 60)      AS ldapuser,
	SUBSTR(s.description::text, 1, 2000) AS description,
	s.ad_session_id
FROM
	ad_session s
		JOIN ad_user u
		ON s.createdby = u.ad_user_id
		LEFT JOIN ad_role r
		ON s.ad_role_id = r.ad_role_id
		JOIN ad_client c
		ON s.ad_client_id = c.ad_client_id
		LEFT JOIN ad_org o
		ON s.ad_org_id = o.ad_org_id
WHERE
	s.processed = 'N'::bpchar;
create or replace view ad_user_roles_v(name, rolename) as
	SELECT
	u.name,
	r.name AS rolename
FROM
	ad_user_roles ur
		JOIN ad_user u
		ON ur.ad_user_id = u.ad_user_id
		JOIN ad_role r
		ON ur.ad_role_id = r.ad_role_id;

SELECT
	register_migration_script('202504101045_GO-3260.sql')
FROM
	dual;
