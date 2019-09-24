--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: zd_shorturl; Type: TABLE; Schema: public; Owner: zerodeng
--

CREATE TABLE public.zd_shorturl (
    id integer NOT NULL,
    short_code character varying(50),
    url character varying(1000) NOT NULL,
    create_time date
);


ALTER TABLE public.zd_shorturl OWNER TO zerodeng;

--
-- Name: COLUMN zd_shorturl.id; Type: COMMENT; Schema: public; Owner: zerodeng
--

COMMENT ON COLUMN public.zd_shorturl.id IS 'id';


--
-- Name: COLUMN zd_shorturl.short_code; Type: COMMENT; Schema: public; Owner: zerodeng
--

COMMENT ON COLUMN public.zd_shorturl.short_code IS '短网址标记';


--
-- Name: COLUMN zd_shorturl.url; Type: COMMENT; Schema: public; Owner: zerodeng
--

COMMENT ON COLUMN public.zd_shorturl.url IS '原始网址';


--
-- Name: COLUMN zd_shorturl.create_time; Type: COMMENT; Schema: public; Owner: zerodeng
--

COMMENT ON COLUMN public.zd_shorturl.create_time IS '创建时间';


--
-- Name: ZD_ShortUrl_id_seq; Type: SEQUENCE; Schema: public; Owner: zerodeng
--

CREATE SEQUENCE public."ZD_ShortUrl_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."ZD_ShortUrl_id_seq" OWNER TO zerodeng;

--
-- Name: ZD_ShortUrl_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: zerodeng
--

ALTER SEQUENCE public."ZD_ShortUrl_id_seq" OWNED BY public.zd_shorturl.id;


--
-- Name: zd_shorturl id; Type: DEFAULT; Schema: public; Owner: zerodeng
--

ALTER TABLE ONLY public.zd_shorturl ALTER COLUMN id SET DEFAULT nextval('public."ZD_ShortUrl_id_seq"'::regclass);


--
-- Data for Name: zd_shorturl; Type: TABLE DATA; Schema: public; Owner: zerodeng
--

COPY public.zd_shorturl (id, short_code, url, create_time) FROM stdin;
\.


--
-- Name: ZD_ShortUrl_id_seq; Type: SEQUENCE SET; Schema: public; Owner: zerodeng
--

SELECT pg_catalog.setval('public."ZD_ShortUrl_id_seq"', 206, true);


--
-- Name: zd_shorturl ZD_ShortUrl_pkey; Type: CONSTRAINT; Schema: public; Owner: zerodeng
--

ALTER TABLE ONLY public.zd_shorturl
    ADD CONSTRAINT "ZD_ShortUrl_pkey" PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

