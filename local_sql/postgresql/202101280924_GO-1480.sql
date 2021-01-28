-- Create a missed index from before to ensure duplicate included roles can't be assigned to a usertype
create unique index if not exists bh_defaultincludedrole_unique
	on bh_defaultincludedrole (db_usertype, included_role_id);

-- Create a new table
create table if not exists bh_default_docaction_access_exclude
(
	ad_client_id numeric(10) not null,
	ad_org_id numeric(10) not null,
	ad_ref_list_id numeric(10) not null,
	bh_default_docaction_access_ex varchar(36) default NULL::character varying,
	c_doctype_id numeric(10) not null,
	created timestamp default statement_timestamp() not null,
	createdby numeric(10) not null,
	db_usertype char default NULL::bpchar,
	isactive char not null,
	updated timestamp default statement_timestamp() not null,
	updatedby numeric(10) not null,
	constraint adreflist_bhdefaultdocactionac
		foreign key (ad_ref_list_id) references ad_ref_list
			deferrable initially deferred,
	constraint cdoctype_bhdefaultdocactionacc
		foreign key (c_doctype_id) references c_doctype
			deferrable initially deferred,
	constraint bh_default_docaction_access_exclude_isactive_check
		check (isactive = ANY (ARRAY['Y'::bpchar, 'N'::bpchar]))
);

-- Create a constraint to ensure duplicate exclusions can't be assigned to a usertype
create unique index if not exists bh_default_docaction_access_exclude_unique
	on bh_default_docaction_access_exclude (db_usertype, c_doctype_id, ad_ref_list_id);

SELECT register_migration_script('202101280924_GO-1480.sql') FROM dual;