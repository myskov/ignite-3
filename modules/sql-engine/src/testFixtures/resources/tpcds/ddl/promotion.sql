create table PROMOTION
(
    P_PROMO_SK        INTEGER not null,
    P_PROMO_ID        VARCHAR(16),
    P_START_DATE_SK   INTEGER,
    P_END_DATE_SK     INTEGER,
    P_ITEM_SK         INTEGER,
    P_COST            NUMERIC(15, 2),
    P_RESPONSE_TARGET INTEGER,
    P_PROMO_NAME      VARCHAR(50),
    P_CHANNEL_DMAIL   VARCHAR,
    P_CHANNEL_EMAIL   VARCHAR,
    P_CHANNEL_CATALOG VARCHAR,
    P_CHANNEL_TV      VARCHAR,
    P_CHANNEL_RADIO   VARCHAR,
    P_CHANNEL_PRESS   VARCHAR,
    P_CHANNEL_EVENT   VARCHAR,
    P_CHANNEL_DEMO    VARCHAR,
    P_CHANNEL_DETAILS VARCHAR(100),
    P_PURPOSE         VARCHAR(15),
    P_DISCOUNT_ACTIVE VARCHAR,
    constraint PROMOTION_PK
        primary key (P_PROMO_SK)
);