-- Database: Pharmacy

-- DROP DATABASE "Pharmacy";

CREATE DATABASE "Pharmacy"
    WITH 
    OWNER = user_pharmacy
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

ALTER DEFAULT PRIVILEGES
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLES TO user_pharmacy;