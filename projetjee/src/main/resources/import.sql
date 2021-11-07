CREATE DATABASE pharmacie
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
CREATE TABLE IF NOT EXISTS public.utilisateur
(
    id integer NOT NULL DEFAULT nextval('utilisateur_id_seq'::regclass),
    password character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT utilisateur_pkey PRIMARY KEY (id),
    CONSTRAINT uk_66vu1vfh4m2fw682xmd4lobqy UNIQUE (username)
)

TABLESPACE pg_default;

ALTER TABLE public.utilisateur
    OWNER to "user";
CREATE TABLE IF NOT EXISTS public.article
(
    id integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    nom character varying(255) COLLATE pg_catalog."default",
    prix double precision,
    quantity integer,
    CONSTRAINT article_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.article
    OWNER to "user";

INSERT INTO public.article(id, description, nom, quantity, prix)VALUES (1, 'Antalgique et anti_inflamatoire', 'Aspirine', 80, 12.5);
INSERT INTO public.article(id, description, nom, quantity, prix)VALUES (2,' Antalgique anti-douleur','Paracetamol', 150, 5.3);
INSERT INTO public.article(id, description, nom, quantity, prix)VALUES (3, 'Anti-inflamatoire','Ibuprofène', 100, 6);


INSERT INTO UTILISATEUR(username, password) VALUES('user', '$2a$10$LRa9WdzoCq57Xv38i5lFDOiDoBTN9G3HFqhx82Bpxt/JuzUChabwq');
