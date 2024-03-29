CREATE TABLE "TGBotSchema"."testTable"
(
    "TestId" bigserial NOT NULL,
    "TestText" character varying,
    "TestInt" bigint,
    "TestData" timestamp with time zone,
    PRIMARY KEY ("TestId")
);

ALTER TABLE IF EXISTS "TGBotSchema"."testTable"
    OWNER to "TGBotSU";