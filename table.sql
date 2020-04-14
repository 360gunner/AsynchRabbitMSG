--create 2 databses in postgres with these names "test1" and "test2"
--create this table in both of the databases
--Enjoy!

CREATE TABLE public.test
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT test_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.test
    OWNER to postgres;