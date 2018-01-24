CREATE SCHEMA rhum;
ALTER SCHEMA rhum
OWNER TO rhum;
GRANT SELECT ON ALL TABLES IN SCHEMA rhum TO rhum;

SET search_path TO rhum;

CREATE TABLE RUM
(
  id uuid,
  name text NOT NULL,
  country text NOT NULL,
  type text NOT NULL,
  distilled int,
  bottled int,
  age int not null,
  PRIMARY KEY (id)
);

ALTER TABLE RUM OWNER to rhum;

CREATE TABLE AROMA
(
  id uuid,
  name text,
  PRIMARY KEY (id)
);

ALTER TABLE AROMA OWNER to rhum;

CREATE TABLE RATING
(
  id uuid,
  rum_id uuid,
  mark int,
  comment text,
  aroma_id uuid,
  aroma_mark int,
  PRIMARY KEY (id)
);

ALTER TABLE RATING OWNER to rhum;
