alter table c_order alter column bh_primarycodeddiagnosis_id type numeric(10) using bh_primarycodeddiagnosis_id::numeric(10);

alter table c_order alter column bh_secondarycodeddiagnosis_id type numeric(10) using bh_secondarycodeddiagnosis_id::numeric(10);

SELECT register_migration_script('202109141331_GO-1837.sql') FROM dual;
