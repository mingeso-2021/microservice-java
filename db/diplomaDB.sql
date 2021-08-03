drop database if exists diplomadb;
create database diplomadb;
\c diplomadb;

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE public.diploma (
    id serial NOT NULL,
    name character varying(100),
    CONSTRAINT diploma_pkey PRIMARY KEY (id)
);

ALTER TABLE public.diploma OWNER TO postgres;

CREATE TABLE public.evaluator
(
    id serial NOT NULL,
    name character varying(100),
    rut character varying(12),
    email character varying(30),
    phone character varying(12),
    CONSTRAINT evaluator_pkey PRIMARY KEY (id)
);

ALTER TABLE public.evaluator OWNER to postgres;

CREATE TABLE public.postulant
(
    id serial NOT NULL,
    name character varying(100),
    rut character varying(12),
    email character varying(30),
    phone character varying(12),
    CONSTRAINT postulant_pkey PRIMARY KEY (id)
);

ALTER TABLE public.postulant OWNER to postgres;

CREATE TABLE public.secretary
(
    id serial NOT NULL,
    name character varying(100),
    rut character varying(12),
    email character varying(30),
    phone character varying(12),
    CONSTRAINT secretary_pkey PRIMARY KEY (id)
);

ALTER TABLE public.secretary OWNER to postgres;

CREATE TABLE public.postulation 
(
    id serial NOT NULL,
    id_diploma serial NOT NULL,
    id_postulant serial NOT NULL,
    id_evaluator serial NOT NULL,
    id_secretary serial NOT NULL,
    CONSTRAINT postulation_pkey PRIMARY KEY (id),
    CONSTRAINT fk_postulation_diploma FOREIGN KEY (id_diploma) REFERENCES public.diploma(id),
    CONSTRAINT fk_postulation_postulant  FOREIGN KEY (id_postulant) REFERENCES public.postulant(id),
    CONSTRAINT fk_postulation_evaluator FOREIGN KEY (id_evaluator) REFERENCES public.evaluator(id),
    CONSTRAINT fk_postulation_secretary  FOREIGN KEY (id_secretary) REFERENCES public.secretary(id)
);

ALTER TABLE public.postulation OWNER to postgres;


