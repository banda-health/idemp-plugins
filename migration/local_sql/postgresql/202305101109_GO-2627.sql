UPDATE ad_process_para
SET
	ad_reference_id = 16
WHERE
		ad_process_para_uu IN ('9788edef-8eab-4a03-afc8-2a5f5ed8fc0d', '2955a2c9-94a6-4b5f-88ed-e209c5569c40',
		                       '1b6a1b5a-b39c-40d5-ab8b-8ee030d6078e', 'debc8a5e-668c-4c60-a2e6-b03b9fe96d34',
		                       '3bb17224-f468-432e-9774-52c8883e452a', '8cca960f-8a4c-4538-9fc1-8dcddc306574',
		                       '935825a6-edd6-4bd6-a0d2-792f7820631f', '09d25fd2-a707-4431-b4b3-14ea2968ff12',
		                       'ceece17f-3608-40da-acf7-efb824a305d4', '3c2fdafc-8abd-4116-8184-62f8bd26499a',
		                       '1c79b0bb-112f-4498-9fa4-43a954771c4c', 'c511e591-8964-420e-9760-eb2ba320673a',
		                       '0f3c1738-f978-43c4-99e1-60985cef05c8', '3f937523-ec0b-46ad-95eb-b5f858b29347',
		                       '6b2729cb-66b0-42be-ae58-80b398fbb1d3', 'bd243ede-3264-4673-847a-f1f8b7091c01',
		                       '949898d5-2efb-4c39-b3f2-61138049c6e8', 'e45d6f7a-80cb-4211-9f83-96268da83aa0',
		                       '67768cbd-b786-4c32-ad18-30d778320a94', 'add93b18-80d7-4ece-b938-ea74388bc252',
		                       'cb31eb7a-c1ef-4afd-8443-86c657060000', '23fcb57c-e97e-4339-8228-65f2ad473d2a',
		                       'f2133f92-105e-40e3-992a-be654a2bcafa', '47722f80-e783-488b-8b75-d482ccf66176');

SELECT
	register_migration_script('202305101109_GO-2627.sql')
FROM
	dual;
