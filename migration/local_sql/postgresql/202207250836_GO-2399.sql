/**********************************************************************************************************/
-- Update the diagnosis window access: 1f29f7ab-bc9a-427c-b35b-87589e4612b5
/**********************************************************************************************************/
-- Grant access to clinic admin role: 461b31c5-cae2-449d-8a0c-7385b12f4685
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 100, 100, 'N', 'N')
ON CONFLICT DO NOTHING;
-- Grant access to clinic user role: e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 100, 100, 'N', 'N')
ON CONFLICT DO NOTHING;
-- Grant access to clinician/nurse advanced role: c54253cf-c86b-4aaa-b472-ed8880635c62
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 100, 100, 'N', 'N')
ON CONFLICT DO NOTHING;
-- Remove from cashier/registration basic role: 09eb7fc8-9cc5-44b0-9d14-15258a066038
DELETE
FROM
	ad_window_access
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '1f29f7ab-bc9a-427c-b35b-87589e4612b5'
	)
	AND ad_role_id = (
	SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
);

/**********************************************************************************************************/
-- Update clinical details window access: 2e37e97b-aeb5-47d7-add3-0d602233c2aa
/**********************************************************************************************************/
-- Remove deactivation from clinician/nurse basic role: 98617c31-55ff-48f9-bd44-253ef323d960
UPDATE ad_window_access
SET
	bh_candeactivate = 'N'
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2e37e97b-aeb5-47d7-add3-0d602233c2aa'
	)
	AND ad_role_id = (
	SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '98617c31-55ff-48f9-bd44-253ef323d960'
);
-- Grant access to inventory/pharmacy role: ec17fee0-a53a-4dbb-b946-423ce14880eb
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2e37e97b-aeb5-47d7-add3-0d602233c2aa'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ec17fee0-a53a-4dbb-b946-423ce14880eb'
	 ), 0, 0, 100, 100, 'N', 'N')
ON CONFLICT DO NOTHING;
-- Grant access to clinician/nurse advanced role: c54253cf-c86b-4aaa-b472-ed8880635c62
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2e37e97b-aeb5-47d7-add3-0d602233c2aa'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 100, 100, 'Y', 'N')
ON CONFLICT DO NOTHING;
-- Remove access from triage role: ae618e24-a47a-40cc-bb5c-8dca64d86daf
DELETE
FROM
	ad_window_access
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2e37e97b-aeb5-47d7-add3-0d602233c2aa'
	)
	AND ad_role_id = (
	SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ae618e24-a47a-40cc-bb5c-8dca64d86daf'
);
-- Remove deactivation access from lab/radiology role: 097feff0-3aa6-41fe-bf76-936b03859846
UPDATE ad_window_access
SET
	bh_candeactivate = 'N'
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2e37e97b-aeb5-47d7-add3-0d602233c2aa'
	)
	AND ad_role_id = (
	SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
);
-- Grant access to clinic user role: e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '2e37e97b-aeb5-47d7-add3-0d602233c2aa'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 100, 100, 'Y', 'Y')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Update the vitals page access: 53b4d743-c311-40e5-aa8e-c0880c42c1b1
/**********************************************************************************************************/
-- Grant access to clinician/nurse advanced role: c54253cf-c86b-4aaa-b472-ed8880635c62
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '53b4d743-c311-40e5-aa8e-c0880c42c1b1'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 100, 100, 'Y', 'N')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Update suppliers page access: 565af89e-8f10-4469-84f5-6cca8d7fae27
/**********************************************************************************************************/
-- Remove deactivation access from lab/radiology role: 097feff0-3aa6-41fe-bf76-936b03859846
UPDATE ad_window_access
SET
	bh_candeactivate = 'N'
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = '565af89e-8f10-4469-84f5-6cca8d7fae27'
	)
	AND ad_role_id = (
	SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
);

/**********************************************************************************************************/
-- Update products page access: c63b9972-1b23-4140-8bbb-0ea2b0b81024
/**********************************************************************************************************/
-- Remove deactivation access from lab/radiology role: 097feff0-3aa6-41fe-bf76-936b03859846
UPDATE ad_window_access
SET
	bh_candeactivate = 'N'
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'c63b9972-1b23-4140-8bbb-0ea2b0b81024'
	)
	AND ad_role_id = (
	SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
);

/**********************************************************************************************************/
-- Update services page access: fd93da00-871d-4996-a3f7-4528bed8b758
/**********************************************************************************************************/
-- Remove deactivation access from lab/radiology role: 097feff0-3aa6-41fe-bf76-936b03859846
UPDATE ad_window_access
SET
	bh_candeactivate = 'N'
WHERE
		ad_window_id = (
		SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'fd93da00-871d-4996-a3f7-4528bed8b758'
	)
	AND ad_role_id = (
	SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
);

/**********************************************************************************************************/
-- Update non-patient payments page: ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d
/**********************************************************************************************************/
-- Grant access to accounting role: 93365778-a2d9-433b-b962-87fb150db4fa
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'
	 ), 0, 0, 100, 100, 'Y', 'N')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Update transfer inventory page: d3c84cad-7306-464d-85da-7e629846f8c0
/**********************************************************************************************************/
-- Grant access to clinic user role: e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd3c84cad-7306-464d-85da-7e629846f8c0'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 100, 100, 'Y', 'N')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Update dashboard page: d91768c8-5c5b-4d7c-9a6f-15b06d45908b
/**********************************************************************************************************/
-- Grant access to clinic user role: e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e
INSERT INTO
	ad_window_access (ad_window_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite,
	                  bh_candeactivate)
VALUES
	((
		 SELECT ad_window_id FROM ad_window WHERE ad_window_uu = 'd91768c8-5c5b-4d7c-9a6f-15b06d45908b'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 100, 100, 'N', 'N')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Update the donor fund report: 3478d341-c6d9-4f52-a865-5bf0ba8a7607
/**********************************************************************************************************/
-- Grant access to clinic admin role: 461b31c5-cae2-449d-8a0c-7385b12f4685
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '3478d341-c6d9-4f52-a865-5bf0ba8a7607'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 100, 100, 'Y');
-- Grant access to accounting role: 93365778-a2d9-433b-b962-87fb150db4fa
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '3478d341-c6d9-4f52-a865-5bf0ba8a7607'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'
	 ), 0, 0, 100, 100, 'Y');

/**********************************************************************************************************/
-- Update the cashier transactions report: 226cdf47-9cde-43e8-b7ef-87b28d7ef2e2
/**********************************************************************************************************/
-- Grant access to clinic admin role: 461b31c5-cae2-449d-8a0c-7385b12f4685
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 100, 100, 'Y')
ON CONFLICT DO NOTHING;
-- Grant access to cashier/registration basic role: 09eb7fc8-9cc5-44b0-9d14-15258a066038
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	 ), 0, 0, 100, 100, 'Y')
ON CONFLICT DO NOTHING;
-- Grant access to cashier/registration basic role: 93365778-a2d9-433b-b962-87fb150db4fa
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'
	 ), 0, 0, 100, 100, 'Y')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Update the cashier patient transactions report: b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1
/**********************************************************************************************************/
-- Grant access to clinic admin role: 461b31c5-cae2-449d-8a0c-7385b12f4685
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '461b31c5-cae2-449d-8a0c-7385b12f4685'
	 ), 0, 0, 100, 100, 'Y')
ON CONFLICT DO NOTHING;
-- Grant access to cashier/registration basic role: 09eb7fc8-9cc5-44b0-9d14-15258a066038
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '09eb7fc8-9cc5-44b0-9d14-15258a066038'
	 ), 0, 0, 100, 100, 'Y')
ON CONFLICT DO NOTHING;
-- Grant access to accounting role: 93365778-a2d9-433b-b962-87fb150db4fa
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '93365778-a2d9-433b-b962-87fb150db4fa'
	 ), 0, 0, 100, 100, 'Y')
ON CONFLICT DO NOTHING;

/**********************************************************************************************************/
-- Update the payment trail report: a7ac9f65-45d7-4ae0-80f3-72019de35a4a
/**********************************************************************************************************/
-- Grant access to cashier/registration advanced role: ee008abc-2c16-4230-b48c-b1f5577ea270
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'a7ac9f65-45d7-4ae0-80f3-72019de35a4a'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'ee008abc-2c16-4230-b48c-b1f5577ea270'
	 ), 0, 0, 100, 100, 'Y');
-- Grant access to clinician/nurse advanced role: c54253cf-c86b-4aaa-b472-ed8880635c62
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'a7ac9f65-45d7-4ae0-80f3-72019de35a4a'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 100, 100, 'Y');

/**********************************************************************************************************/
-- Update the diagnosis report: 7c29028a-8dd3-4025-a5af-87701748d81f
/**********************************************************************************************************/
-- Grant access to clinician/nurse advanced role: c54253cf-c86b-4aaa-b472-ed8880635c62
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '7c29028a-8dd3-4025-a5af-87701748d81f'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'c54253cf-c86b-4aaa-b472-ed8880635c62'
	 ), 0, 0, 100, 100, 'Y');

/**********************************************************************************************************/
-- Update the stock to be ordered report: 03ba009a-68bb-4b12-a5bc-e58a9bce1545
/**********************************************************************************************************/
-- Grant access to lab/radiology role: 097feff0-3aa6-41fe-bf76-936b03859846
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = '03ba009a-68bb-4b12-a5bc-e58a9bce1545'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = '097feff0-3aa6-41fe-bf76-936b03859846'
	 ), 0, 0, 100, 100, 'Y');

/**********************************************************************************************************/
-- Update the open balances report: b4f11e14-b9d8-4f6c-aa46-adfd77c4f773
/**********************************************************************************************************/
-- Grant access to clinic user role: e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e
INSERT INTO
	ad_process_access (ad_process_id, ad_role_id, ad_client_id, ad_org_id, createdby, updatedby, isreadwrite)
VALUES
	((
		 SELECT ad_process_id FROM ad_process WHERE ad_process_uu = 'b4f11e14-b9d8-4f6c-aa46-adfd77c4f773'
	 ), (
		 SELECT ad_role_id FROM ad_role WHERE ad_role_uu = 'e1a9a87d-dc61-4d9e-a6c9-f91d5f42e33e'
	 ), 0, 0, 100, 100, 'Y');

SELECT register_migration_script('202207250836_GO-2399.sql') FROM dual;
