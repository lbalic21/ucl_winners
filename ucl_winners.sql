--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5 (Ubuntu 14.5-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.5 (Ubuntu 14.5-0ubuntu0.22.04.1)

-- Started on 2022-11-01 19:22:01 CET

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

--
-- TOC entry 211 (class 1259 OID 16408)
-- Name: coaches; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.coaches (
    name text,
    country text,
    id integer NOT NULL
);


ALTER TABLE public.coaches OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16407)
-- Name: coaches_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.coaches_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.coaches_id_seq OWNER TO postgres;

--
-- TOC entry 3376 (class 0 OID 0)
-- Dependencies: 210
-- Name: coaches_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.coaches_id_seq OWNED BY public.coaches.id;


--
-- TOC entry 213 (class 1259 OID 16417)
-- Name: players; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.players (
    name text,
    country text,
    "position" text,
    id integer NOT NULL
);


ALTER TABLE public.players OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16416)
-- Name: players_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.players_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.players_id_seq OWNER TO postgres;

--
-- TOC entry 3377 (class 0 OID 0)
-- Dependencies: 212
-- Name: players_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.players_id_seq OWNED BY public.players.id;


--
-- TOC entry 209 (class 1259 OID 16398)
-- Name: ucl_winners; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ucl_winners (
    club text,
    city text,
    country text,
    year bigint,
    stadium text,
    head_coach bigint,
    captain bigint,
    "final_match-up" text,
    result text,
    scorers bigint[],
    final_attendance bigint,
    id integer NOT NULL
);


ALTER TABLE public.ucl_winners OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16425)
-- Name: ucl_winners_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ucl_winners_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ucl_winners_id_seq OWNER TO postgres;

--
-- TOC entry 3378 (class 0 OID 0)
-- Dependencies: 214
-- Name: ucl_winners_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ucl_winners_id_seq OWNED BY public.ucl_winners.id;


--
-- TOC entry 3218 (class 2604 OID 16411)
-- Name: coaches id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coaches ALTER COLUMN id SET DEFAULT nextval('public.coaches_id_seq'::regclass);


--
-- TOC entry 3219 (class 2604 OID 16420)
-- Name: players id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.players ALTER COLUMN id SET DEFAULT nextval('public.players_id_seq'::regclass);


--
-- TOC entry 3217 (class 2604 OID 16426)
-- Name: ucl_winners id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ucl_winners ALTER COLUMN id SET DEFAULT nextval('public.ucl_winners_id_seq'::regclass);


--
-- TOC entry 3367 (class 0 OID 16408)
-- Dependencies: 211
-- Data for Name: coaches; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.coaches (name, country, id) FROM stdin;
Johan Cruyff	Netherlands	4
Fabio Capello	Italy	5
Jose Murinho	Portugal	6
Pep Guardiola	Spain	7
Ottmar Hitzfeld	Germany	8
Vicente del Bosque	Spain	10
Carlo Ancelotti	Italy	11
Rafael Benitez	Spain	12
Jupp Heynckes	Germany	13
Zinedine Zidane	France	14
Jürgen Klopp	Germany	15
Hansi Flick	Germany	16
Thomas Tuchel	Germany	17
Louis van Gaal	Netherlands	3
Sir Alex Ferguson	Scotland	9
\.


--
-- TOC entry 3369 (class 0 OID 16417)
-- Dependencies: 213
-- Data for Name: players; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.players (name, country, "position", id) FROM stdin;
Ronald Koeman	Netherlands	Defender	1
Basile Boli	France	Defender	2
Patrick Kluivert	Netherlands	Striker	3
Alessandro Del Piero	Italy	Striker	4
Karl-Heinz Riedle	Germany	Striker	5
Lars Ricken	Germany	Midfielder	6
Mario Basler	Germany	Midfielder	7
Teddy Sheringham	England	Striker	8
Ole Gunnar Solskjær	Norway	Striker	9
Peter Schmeichel	Denmark	Goalkeeper	10
Matthias Sammer 	Germany	Defender	11
Danny Blind	Netherlands	Defender	12
Didier Deschamps	France	Midfielder	13
Andoni Zubizarreta	Spain	Goalkeeper	14
Paolo Maldini	Italy	Defender	15
Jorge Costa	Portugal	Defender	16
Carlos Alberto	Brazil	Midfielder	17
Deco	Portugal	Midfielder	18
Dmitri Alenichev	Russia	Striker	19
Filippo Inzaghi	Italy	Striker	20
Lionel Messi	Argentina	Striker	21
Samuel Etoo	Cameroon	Striker	22
Carles Puyol	Spain	Defender	23
Diego Milito	Argentina	Striker	24
Javier Zanetti	Argentina	Defender	25
Philipp Lahm	Germany	Defender	26
İlkay Gündoğan	Germany	Midfielder	27
Mario Mandžukić	Croatia	Striker	28
Arjen Robben	Netherlands	Striker	29
Kai Havertz	Germany	Midfielder	30
César Azpilicueta	Spain	Defender	31
Manuel Neuer	Germany	Goalkeeper	32
Kingsley Coman	France	Striker	33
Jordan Henderson	England	Midfielder	34
Mohamed Salah	Egypt	Striker	35
Divock Origi	Belgium	Striker	36
Sergio Ramos	Spain	Defender	37
Karim Benzema	France	Striker	38
Gareth Bale	Wales	Striker	39
Sadio Mané	Cameroon	Striker	40
Dirk Kuyt	Netherlands	Striker	41
\.


--
-- TOC entry 3365 (class 0 OID 16398)
-- Dependencies: 209
-- Data for Name: ucl_winners; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ucl_winners (club, city, country, year, stadium, head_coach, captain, "final_match-up", result, scorers, final_attendance, id) FROM stdin;
FC Barcelona	Barcelona	Spain	1992	Wembley Stadium, London	4	14	Unione Calcio Sampdoria	0:1	{1}	70827	1
Olympique de Marseille	Marseille	France	1993	Olympiastadion, Munich	5	13	AC Milan	1:0	{2}	64400	2
AFC Ajax	Amsterdam	Netherlands	1995	Ernst-Happel-Stadion, Vienna	3	12	AC Milan	1:0	{3}	49730	3
Borussia Dortmund	Dortmund	Germany	1997	Olympiastadion, Munich	8	11	Juventus	3:1	{4,5,6}	59000	4
Manchester United	Manchester	England	1999	Camp Nou, Barcelona	9	10	FC Bayern Munich	2:1	{7,8,9}	90245	5
FC Porto	Porto	Portual	2004	Arena AufSchalke, Gelsenkirchen	6	16	AS Monaco	0:3	{17,18,19}	53053	6
AC Milan	Milan	Italy	2007	Olympic Stadium, Athens	11	15	Liverpool FC	2:1	{41,20}	63000	7
FC Barcelona	Barcelona	Spain	2009	Stadio Olimpico, Rome	7	23	Manchester United	2:0	{21,22}	62467	8
FC Internazionale Milan	Milan	Spain	2010	Santiago Bernabéu, Madrid	6	35	FC Bayern Munich	2:0	{24}	73490	9
FC Bayern Munich	Munich	Germany	2013	Wembley Stadium, London	13	26	Borussia Dortmund	2:1	{27,28,29}	86298	10
Real Madrid CF	Madrid	Spain	2018	NSC Olimpiyskiy Stadium, Kyiv	14	37	Liverpool FC	3:1	{38,39,40}	61561	11
Liverpool FC	Liverpool	England	2019	Metropolitano Stadium, Madrid	15	34	Tottenham Hotspur FC	2:0	{35,36}	63272	12
FC Bayern Munich	Munich	Germany	2020	Estádio da Luz, Lisbon	16	32	Paris Saint-Germain FC	0:1	{33}	0	13
Chelsea FC	London	England	2021	Estádio do Dragão, Porto	17	31	Manchester City FC	0:1	{30}	75000	14
\.


--
-- TOC entry 3379 (class 0 OID 0)
-- Dependencies: 210
-- Name: coaches_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.coaches_id_seq', 17, true);


--
-- TOC entry 3380 (class 0 OID 0)
-- Dependencies: 212
-- Name: players_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.players_id_seq', 40, true);


--
-- TOC entry 3381 (class 0 OID 0)
-- Dependencies: 214
-- Name: ucl_winners_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ucl_winners_id_seq', 14, true);


--
-- TOC entry 3223 (class 2606 OID 16415)
-- Name: coaches coaches_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coaches
    ADD CONSTRAINT coaches_pkey PRIMARY KEY (id);


--
-- TOC entry 3225 (class 2606 OID 16424)
-- Name: players players_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.players
    ADD CONSTRAINT players_pkey PRIMARY KEY (id);


--
-- TOC entry 3221 (class 2606 OID 16433)
-- Name: ucl_winners ucl_winners_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ucl_winners
    ADD CONSTRAINT ucl_winners_pkey PRIMARY KEY (id);


-- Completed on 2022-11-01 19:22:02 CET

--
-- PostgreSQL database dump complete
--

