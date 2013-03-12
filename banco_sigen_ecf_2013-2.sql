--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.1
-- Dumped by pg_dump version 9.2.1
-- Started on 2013-01-02 16:17:11

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2109 (class 1262 OID 24576)
-- Name: sigen_ecf; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE sigen_ecf WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE sigen_ecf OWNER TO postgres;

\connect sigen_ecf

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 191 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2112 (class 0 OID 0)
-- Dependencies: 191
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 57473)
-- Name: cad_cliente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_cliente (
    cod_cli text NOT NULL,
    nome text NOT NULL,
    cpf_cnpj text
);


ALTER TABLE public.cad_cliente OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 32810)
-- Name: cad_codigo_barras; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_codigo_barras (
    cod_prod text NOT NULL,
    cod_und text NOT NULL,
    ean text NOT NULL
);


ALTER TABLE public.cad_codigo_barras OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 32828)
-- Name: cad_condicao_pagamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_condicao_pagamento (
    cod_condicao_pagamento text NOT NULL,
    descricao text NOT NULL,
    parcela_max integer NOT NULL,
    dias_entre_parcelas integer NOT NULL,
    exige_entrada boolean NOT NULL
);


ALTER TABLE public.cad_condicao_pagamento OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 32846)
-- Name: cad_conveniada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_conveniada (
    cod_conveniada text NOT NULL,
    descricao text NOT NULL
);


ALTER TABLE public.cad_conveniada OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 32864)
-- Name: cad_forma_condicao_pagamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_forma_condicao_pagamento (
    cod_forma_pagamento text NOT NULL,
    cod_condicao_pagamento text NOT NULL
);


ALTER TABLE public.cad_forma_condicao_pagamento OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 32822)
-- Name: cad_forma_pagamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_forma_pagamento (
    cod_forma_pagamento text NOT NULL,
    tipo text NOT NULL,
    descricao text NOT NULL,
    taxa numeric(20,2),
    pagamento_a_vista boolean NOT NULL,
    pagamento_a_prazo boolean NOT NULL
);


ALTER TABLE public.cad_forma_pagamento OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 32858)
-- Name: cad_forma_pagamento_conveniada; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_forma_pagamento_conveniada (
    cod_forma_pagamento text NOT NULL,
    cod_conveniada text NOT NULL,
    taxa_adm numeric(5,2) NOT NULL
);


ALTER TABLE public.cad_forma_pagamento_conveniada OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 32834)
-- Name: cad_operador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_operador (
    cod_operador text NOT NULL,
    nome text NOT NULL,
    supervisor boolean NOT NULL,
    senha text NOT NULL
);


ALTER TABLE public.cad_operador OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 32798)
-- Name: cad_produto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_produto (
    cod_prod text NOT NULL,
    descricao text NOT NULL,
    preco_venda numeric(20,2) NOT NULL,
    saldo_estoque numeric(20,2) NOT NULL,
    icms_st text NOT NULL,
    icms_red_bc numeric(20,2) NOT NULL,
    icms_aliq numeric(5,2) NOT NULL,
    ipi_st text NOT NULL,
    ipi_aliq numeric(5,2) NOT NULL,
    pis_st text NOT NULL,
    pis_aliq numeric(5,2) NOT NULL,
    cofins_st text NOT NULL,
    cofins_aliq numeric(5,2) NOT NULL,
    cfop text NOT NULL
);


ALTER TABLE public.cad_produto OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 32804)
-- Name: cad_produto_unidade_medida; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_produto_unidade_medida (
    cod_prod text NOT NULL,
    cod_und text NOT NULL,
    qtd_emb numeric(5,2) NOT NULL,
    und_padrao boolean NOT NULL
);


ALTER TABLE public.cad_produto_unidade_medida OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 32816)
-- Name: cad_unidade_medida; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_unidade_medida (
    cod_und text NOT NULL,
    descricao text NOT NULL
);


ALTER TABLE public.cad_unidade_medida OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 32840)
-- Name: cad_vendedor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cad_vendedor (
    cod_vendedor text NOT NULL,
    nome text NOT NULL
);


ALTER TABLE public.cad_vendedor OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 82456)
-- Name: ecf_parametros; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ecf_parametros (
    utilizacao_parcial_credito boolean NOT NULL,
    id text NOT NULL,
    folder_in text NOT NULL,
    folder_out text NOT NULL
);


ALTER TABLE public.ecf_parametros OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 98918)
-- Name: mov_devolucao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_devolucao (
    nome_cliente text NOT NULL,
    cpf_cnpj text NOT NULL,
    coo_devolucao text NOT NULL,
    data_devolucao date NOT NULL,
    hora text NOT NULL,
    loja text NOT NULL,
    cod_ecf text NOT NULL,
    valor_credito numeric(20,2) DEFAULT 0 NOT NULL,
    endereco text NOT NULL,
    cep text NOT NULL,
    numero text NOT NULL,
    complemento text,
    bairro text NOT NULL,
    estado text NOT NULL,
    cidade text NOT NULL,
    devolucao_utilizada boolean DEFAULT false NOT NULL,
    cod_mov text NOT NULL
);


ALTER TABLE public.mov_devolucao OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 98926)
-- Name: mov_item_devolucao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_item_devolucao (
    cod_ecf text NOT NULL,
    loja text NOT NULL,
    coo_devolucao text NOT NULL,
    cod_produto text NOT NULL,
    quantidade numeric(20,2) NOT NULL,
    valor_unitario numeric(20,2) NOT NULL,
    valor_total numeric(20,2) NOT NULL,
    cod_mov text NOT NULL
);


ALTER TABLE public.mov_item_devolucao OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 32870)
-- Name: mov_item_venda; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_item_venda (
    cod_movimento text NOT NULL,
    cod_operador text NOT NULL,
    coo text NOT NULL,
    loja text NOT NULL,
    cod_ecf text NOT NULL,
    item text NOT NULL,
    cod_prod text NOT NULL,
    descricao text NOT NULL,
    quantidade numeric(20,2) NOT NULL,
    cod_und text NOT NULL,
    valor_unitario numeric(20,2) NOT NULL,
    valor_desconto numeric(20,2) NOT NULL,
    valor_acrescimo numeric(20,2) NOT NULL,
    st text NOT NULL,
    valor_total numeric(20,2) NOT NULL,
    indicador_cancelamento text NOT NULL,
    qtd_emb numeric(10,0) NOT NULL,
    icms_st text NOT NULL,
    icms_red_bc numeric(5,2) NOT NULL,
    icms_aliq numeric(5,2) NOT NULL,
    icms_bc numeric(20,2) NOT NULL,
    icms_valor numeric(20,2) NOT NULL,
    ipi_st text NOT NULL,
    ipi_aliq numeric(5,2) NOT NULL,
    ipi_bc numeric(20,2) NOT NULL,
    ipi_valor numeric(20,2) NOT NULL,
    pis_st text NOT NULL,
    pis_aliq numeric(5,2) NOT NULL,
    pis_bc numeric(20,2) NOT NULL,
    pis_valor numeric(20,2) NOT NULL,
    cofins_st text NOT NULL,
    cofins_aliq numeric(5,2) NOT NULL,
    cofins_bc numeric(20,2) NOT NULL,
    cofins_valor numeric(20,2) NOT NULL,
    iat text NOT NULL,
    casas_decimais_quantidade numeric(5,0) NOT NULL,
    casas_decimais_valor numeric(20,2) NOT NULL,
    data_emissao date NOT NULL,
    data_cancelamento date,
    hora_emissao text NOT NULL,
    hora_cancelamento text,
    cfop text NOT NULL,
    cod_vendedor text
);


ALTER TABLE public.mov_item_venda OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 57386)
-- Name: mov_lancamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_lancamento (
    loja text NOT NULL,
    cod_ecf text NOT NULL,
    cod_movimento text NOT NULL,
    cod_operador text NOT NULL,
    coo text NOT NULL,
    cod_forma_pagamento text NOT NULL,
    tipo_forma_pagamento text NOT NULL,
    cod_conveniada text,
    cod_cliente text,
    valor_bruto numeric(20,2) NOT NULL,
    valor_liquido numeric(20,2) NOT NULL,
    data_lancamento date NOT NULL,
    hora_lancamento text NOT NULL,
    cod_condicao_pagamento text NOT NULL,
    num_lancamento text NOT NULL,
    num_parcela text NOT NULL,
    taxa_adm numeric(5,2) DEFAULT 0 NOT NULL,
    chq_banco text,
    chq_agencia text,
    chq_conta text,
    chq_numero text,
    data_vencimento date NOT NULL,
    recibo_devolucao text,
    numero_autorizacao text
);


ALTER TABLE public.mov_lancamento OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 32894)
-- Name: mov_movimento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_movimento (
    coo text NOT NULL,
    gnf text NOT NULL,
    loja text NOT NULL,
    cod_ecf text NOT NULL,
    cod_movimento text NOT NULL,
    cod_operador text NOT NULL,
    data_abertura date NOT NULL,
    data_fechamento date,
    cod_supervisor text NOT NULL,
    hora_abertura text NOT NULL,
    hora_fechamento text,
    saldo_dinheiro_abertura numeric(20,2) DEFAULT 0,
    saldo_dinheiro_fechamento numeric(20,2) DEFAULT 0
);


ALTER TABLE public.mov_movimento OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 32882)
-- Name: mov_sangria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_sangria (
    coo text NOT NULL,
    gnf text NOT NULL,
    loja text NOT NULL,
    cod_ecf text NOT NULL,
    cod_movimento text NOT NULL,
    cod_operador text NOT NULL,
    data date NOT NULL,
    cod_forma_pagamento text NOT NULL,
    hora text NOT NULL,
    valor numeric(20,2) NOT NULL,
    tipo_forma_pagamento text NOT NULL,
    observacao text
);


ALTER TABLE public.mov_sangria OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 107158)
-- Name: mov_sped_fiscal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_sped_fiscal (
    cod_ecf text NOT NULL,
    modelo_ecf text NOT NULL,
    serie_ecf text NOT NULL,
    data_referencia text NOT NULL,
    cro text NOT NULL,
    crz text NOT NULL,
    coo text NOT NULL,
    totalizador_geral text NOT NULL,
    venda_bruta_diaria text NOT NULL,
    cod_movimento text NOT NULL,
    loja text NOT NULL
);


ALTER TABLE public.mov_sped_fiscal OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 107164)
-- Name: mov_sped_fiscal_aliquota; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_sped_fiscal_aliquota (
    aliquota text NOT NULL,
    valor_aliquota text NOT NULL,
    data_referencia text NOT NULL,
    cod_ecf text NOT NULL,
    cod_movimento text NOT NULL,
    loja text NOT NULL,
    id text NOT NULL
);


ALTER TABLE public.mov_sped_fiscal_aliquota OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 32888)
-- Name: mov_suprimento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_suprimento (
    coo text NOT NULL,
    gnf text NOT NULL,
    loja text NOT NULL,
    cod_ecf text NOT NULL,
    cod_movimento text NOT NULL,
    cod_operador text NOT NULL,
    data date NOT NULL,
    cod_forma_pagamento text NOT NULL,
    hora text NOT NULL,
    valor numeric(20,2) NOT NULL
);


ALTER TABLE public.mov_suprimento OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 32876)
-- Name: mov_venda; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mov_venda (
    coo text NOT NULL,
    loja text NOT NULL,
    cod_ecf text NOT NULL,
    data_emissao date NOT NULL,
    data_cancelamento date,
    valor_sub_total numeric(20,2) NOT NULL,
    valor_desconto numeric(20,2) NOT NULL,
    valor_acrescimo numeric(20,2) NOT NULL,
    valor_total numeric(20,2) NOT NULL,
    indicador_cancelamento text NOT NULL,
    nome_adquirente text,
    cpf_cnpj_adquirente text,
    cod_movimento text NOT NULL,
    cod_operador text NOT NULL,
    hora_emissao text NOT NULL,
    hora_cancelamento text
);


ALTER TABLE public.mov_venda OWNER TO postgres;

--
-- TOC entry 2065 (class 2606 OID 57500)
-- Name: cad_cliente_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_cliente
    ADD CONSTRAINT cad_cliente_pk PRIMARY KEY (cod_cli);


--
-- TOC entry 2035 (class 2606 OID 32916)
-- Name: cad_codigo_barras_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_codigo_barras
    ADD CONSTRAINT cad_codigo_barras_pk PRIMARY KEY (cod_prod, cod_und);


--
-- TOC entry 2041 (class 2606 OID 32914)
-- Name: cad_condicao_pagamento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_condicao_pagamento
    ADD CONSTRAINT cad_condicao_pagamento_pk PRIMARY KEY (cod_condicao_pagamento);


--
-- TOC entry 2047 (class 2606 OID 32906)
-- Name: cad_conveniada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_conveniada
    ADD CONSTRAINT cad_conveniada_pk PRIMARY KEY (cod_conveniada);


--
-- TOC entry 2051 (class 2606 OID 32933)
-- Name: cad_forma_pagamento_condicao_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_forma_condicao_pagamento
    ADD CONSTRAINT cad_forma_pagamento_condicao_pk PRIMARY KEY (cod_forma_pagamento, cod_condicao_pagamento);


--
-- TOC entry 2049 (class 2606 OID 32945)
-- Name: cad_forma_pagamento_conveniada_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_forma_pagamento_conveniada
    ADD CONSTRAINT cad_forma_pagamento_conveniada_pk PRIMARY KEY (cod_forma_pagamento, cod_conveniada);


--
-- TOC entry 2039 (class 2606 OID 32912)
-- Name: cad_forma_pagamento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_forma_pagamento
    ADD CONSTRAINT cad_forma_pagamento_pk PRIMARY KEY (cod_forma_pagamento);


--
-- TOC entry 2043 (class 2606 OID 32904)
-- Name: cad_operador_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_operador
    ADD CONSTRAINT cad_operador_pk PRIMARY KEY (cod_operador);


--
-- TOC entry 2031 (class 2606 OID 32902)
-- Name: cad_prod_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_produto
    ADD CONSTRAINT cad_prod_pk PRIMARY KEY (cod_prod);


--
-- TOC entry 2033 (class 2606 OID 32957)
-- Name: cad_produto_unidade_medida_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_produto_unidade_medida
    ADD CONSTRAINT cad_produto_unidade_medida_pk PRIMARY KEY (cod_prod, cod_und);


--
-- TOC entry 2037 (class 2606 OID 32908)
-- Name: cad_unidade_medida_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_unidade_medida
    ADD CONSTRAINT cad_unidade_medida_pk PRIMARY KEY (cod_und);


--
-- TOC entry 2045 (class 2606 OID 32910)
-- Name: cad_vendedor_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cad_vendedor
    ADD CONSTRAINT cad_vendedor_pk PRIMARY KEY (cod_vendedor);


--
-- TOC entry 2067 (class 2606 OID 82473)
-- Name: ecf_parametros_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ecf_parametros
    ADD CONSTRAINT ecf_parametros_pkey PRIMARY KEY (id);


--
-- TOC entry 2069 (class 2606 OID 98955)
-- Name: mov_devolucao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_devolucao
    ADD CONSTRAINT mov_devolucao_pkey PRIMARY KEY (loja, cod_ecf, cod_mov, coo_devolucao);


--
-- TOC entry 2053 (class 2606 OID 73778)
-- Name: mov_item_venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_item_venda
    ADD CONSTRAINT mov_item_venda_pkey PRIMARY KEY (cod_movimento, cod_operador, coo, loja, cod_ecf, item);


--
-- TOC entry 2063 (class 2606 OID 73805)
-- Name: mov_lancamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_lancamento
    ADD CONSTRAINT mov_lancamento_pkey PRIMARY KEY (loja, cod_ecf, cod_movimento, cod_operador, coo, num_lancamento, num_parcela);


--
-- TOC entry 2061 (class 2606 OID 73839)
-- Name: mov_movimento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_movimento
    ADD CONSTRAINT mov_movimento_pkey PRIMARY KEY (loja, cod_ecf, cod_movimento);


--
-- TOC entry 2057 (class 2606 OID 32981)
-- Name: mov_sangria_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_sangria
    ADD CONSTRAINT mov_sangria_pk PRIMARY KEY (coo, gnf, loja, cod_ecf);


--
-- TOC entry 2073 (class 2606 OID 115398)
-- Name: mov_sped_fiscal_aliquota_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_sped_fiscal_aliquota
    ADD CONSTRAINT mov_sped_fiscal_aliquota_pkey PRIMARY KEY (id, cod_ecf, cod_movimento, loja, data_referencia);


--
-- TOC entry 2071 (class 2606 OID 115377)
-- Name: mov_sped_fiscal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_sped_fiscal
    ADD CONSTRAINT mov_sped_fiscal_pkey PRIMARY KEY (cod_ecf, cod_movimento, loja, data_referencia);


--
-- TOC entry 2059 (class 2606 OID 33008)
-- Name: mov_suprimento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_suprimento
    ADD CONSTRAINT mov_suprimento_pk PRIMARY KEY (coo, gnf, loja, cod_ecf);


--
-- TOC entry 2055 (class 2606 OID 74263)
-- Name: mov_venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mov_venda
    ADD CONSTRAINT mov_venda_pkey PRIMARY KEY (loja, cod_ecf, cod_movimento, coo);


--
-- TOC entry 2077 (class 2606 OID 32922)
-- Name: cad_codigo_barras_cad_produto_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cad_codigo_barras
    ADD CONSTRAINT cad_codigo_barras_cad_produto_fk FOREIGN KEY (cod_prod) REFERENCES cad_produto(cod_prod);


--
-- TOC entry 2076 (class 2606 OID 32917)
-- Name: cad_codigo_barras_cod_unidade_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cad_codigo_barras
    ADD CONSTRAINT cad_codigo_barras_cod_unidade_fk FOREIGN KEY (cod_und) REFERENCES cad_unidade_medida(cod_und);


--
-- TOC entry 2080 (class 2606 OID 65568)
-- Name: cad_condicao_pagamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cad_forma_condicao_pagamento
    ADD CONSTRAINT cad_condicao_pagamento_fk FOREIGN KEY (cod_condicao_pagamento) REFERENCES cad_condicao_pagamento(cod_condicao_pagamento);


--
-- TOC entry 2078 (class 2606 OID 73990)
-- Name: cad_forma_pagamento_conveniada_cad_conveniada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cad_forma_pagamento_conveniada
    ADD CONSTRAINT cad_forma_pagamento_conveniada_cad_conveniada_fk FOREIGN KEY (cod_conveniada) REFERENCES cad_conveniada(cod_conveniada);


--
-- TOC entry 2079 (class 2606 OID 73995)
-- Name: cad_forma_pagamento_conveniada_cad_forma_pagamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cad_forma_pagamento_conveniada
    ADD CONSTRAINT cad_forma_pagamento_conveniada_cad_forma_pagamento_fk FOREIGN KEY (cod_forma_pagamento) REFERENCES cad_forma_pagamento(cod_forma_pagamento);


--
-- TOC entry 2081 (class 2606 OID 65573)
-- Name: cad_forma_pagamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cad_forma_condicao_pagamento
    ADD CONSTRAINT cad_forma_pagamento_fk FOREIGN KEY (cod_forma_pagamento) REFERENCES cad_forma_pagamento(cod_forma_pagamento);


--
-- TOC entry 2074 (class 2606 OID 32958)
-- Name: cad_produto_unidade_medida_cad_produto_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cad_produto_unidade_medida
    ADD CONSTRAINT cad_produto_unidade_medida_cad_produto_fk FOREIGN KEY (cod_prod) REFERENCES cad_produto(cod_prod);


--
-- TOC entry 2075 (class 2606 OID 32963)
-- Name: cad_produto_unidade_medida_cad_unidade_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cad_produto_unidade_medida
    ADD CONSTRAINT cad_produto_unidade_medida_cad_unidade_fk FOREIGN KEY (cod_und) REFERENCES cad_unidade_medida(cod_und);


--
-- TOC entry 2102 (class 2606 OID 98961)
-- Name: mov_devolucao_mov_movimento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_devolucao
    ADD CONSTRAINT mov_devolucao_mov_movimento_fk FOREIGN KEY (loja, cod_ecf, cod_mov) REFERENCES mov_movimento(loja, cod_ecf, cod_movimento);


--
-- TOC entry 2082 (class 2606 OID 73860)
-- Name: mov_item_venda_cad_operador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_item_venda
    ADD CONSTRAINT mov_item_venda_cad_operador_fk FOREIGN KEY (cod_operador) REFERENCES cad_operador(cod_operador);


--
-- TOC entry 2083 (class 2606 OID 73865)
-- Name: mov_item_venda_cad_produto_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_item_venda
    ADD CONSTRAINT mov_item_venda_cad_produto_fk FOREIGN KEY (cod_prod) REFERENCES cad_produto(cod_prod);


--
-- TOC entry 2084 (class 2606 OID 73870)
-- Name: mov_item_venda_cad_unidade_medida_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_item_venda
    ADD CONSTRAINT mov_item_venda_cad_unidade_medida_fk FOREIGN KEY (cod_und) REFERENCES cad_unidade_medida(cod_und);


--
-- TOC entry 2085 (class 2606 OID 73875)
-- Name: mov_item_venda_mov_movimento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_item_venda
    ADD CONSTRAINT mov_item_venda_mov_movimento_fk FOREIGN KEY (cod_movimento, loja, cod_ecf) REFERENCES mov_movimento(cod_movimento, loja, cod_ecf);


--
-- TOC entry 2096 (class 2606 OID 98966)
-- Name: mov_lancamento_cad_cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_lancamento
    ADD CONSTRAINT mov_lancamento_cad_cliente_fk FOREIGN KEY (cod_cliente) REFERENCES cad_cliente(cod_cli);


--
-- TOC entry 2097 (class 2606 OID 98971)
-- Name: mov_lancamento_cad_condicao_pagamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_lancamento
    ADD CONSTRAINT mov_lancamento_cad_condicao_pagamento_fk FOREIGN KEY (cod_condicao_pagamento) REFERENCES cad_condicao_pagamento(cod_condicao_pagamento);


--
-- TOC entry 2098 (class 2606 OID 98976)
-- Name: mov_lancamento_cad_conveniada_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_lancamento
    ADD CONSTRAINT mov_lancamento_cad_conveniada_fk FOREIGN KEY (cod_conveniada) REFERENCES cad_conveniada(cod_conveniada);


--
-- TOC entry 2099 (class 2606 OID 98981)
-- Name: mov_lancamento_cad_forma_pagamento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_lancamento
    ADD CONSTRAINT mov_lancamento_cad_forma_pagamento FOREIGN KEY (cod_forma_pagamento) REFERENCES cad_forma_pagamento(cod_forma_pagamento);


--
-- TOC entry 2100 (class 2606 OID 98986)
-- Name: mov_lancamento_cad_operador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_lancamento
    ADD CONSTRAINT mov_lancamento_cad_operador_fk FOREIGN KEY (cod_operador) REFERENCES cad_operador(cod_operador);


--
-- TOC entry 2101 (class 2606 OID 98991)
-- Name: mov_lancamento_mov_movimento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_lancamento
    ADD CONSTRAINT mov_lancamento_mov_movimento_fk FOREIGN KEY (loja, cod_ecf, cod_movimento) REFERENCES mov_movimento(loja, cod_ecf, cod_movimento);


--
-- TOC entry 2094 (class 2606 OID 90744)
-- Name: mov_movimento_cad_operador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_movimento
    ADD CONSTRAINT mov_movimento_cad_operador_fk FOREIGN KEY (cod_operador) REFERENCES cad_operador(cod_operador);


--
-- TOC entry 2095 (class 2606 OID 90749)
-- Name: mov_movimento_cad_operador_sup_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_movimento
    ADD CONSTRAINT mov_movimento_cad_operador_sup_fk FOREIGN KEY (cod_supervisor) REFERENCES cad_operador(cod_operador);


--
-- TOC entry 2088 (class 2606 OID 74264)
-- Name: mov_sangria_cad_forma_pagamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_sangria
    ADD CONSTRAINT mov_sangria_cad_forma_pagamento_fk FOREIGN KEY (cod_forma_pagamento) REFERENCES cad_forma_pagamento(cod_forma_pagamento);


--
-- TOC entry 2089 (class 2606 OID 74269)
-- Name: mov_sangria_cad_operador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_sangria
    ADD CONSTRAINT mov_sangria_cad_operador_fk FOREIGN KEY (cod_operador) REFERENCES cad_operador(cod_operador);


--
-- TOC entry 2090 (class 2606 OID 74274)
-- Name: mov_sangria_mov_movimento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_sangria
    ADD CONSTRAINT mov_sangria_mov_movimento_fk FOREIGN KEY (loja, cod_ecf, cod_movimento) REFERENCES mov_movimento(loja, cod_ecf, cod_movimento);


--
-- TOC entry 2104 (class 2606 OID 115399)
-- Name: mov_sped_fiscal_aliquota_mov_sped_fiscal_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_sped_fiscal_aliquota
    ADD CONSTRAINT mov_sped_fiscal_aliquota_mov_sped_fiscal_fk FOREIGN KEY (data_referencia, cod_ecf, cod_movimento, loja) REFERENCES mov_sped_fiscal(data_referencia, cod_ecf, cod_movimento, loja);


--
-- TOC entry 2103 (class 2606 OID 115378)
-- Name: mov_sped_fiscal_mov_movimento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_sped_fiscal
    ADD CONSTRAINT mov_sped_fiscal_mov_movimento_fk FOREIGN KEY (cod_ecf, loja, cod_movimento) REFERENCES mov_movimento(cod_ecf, loja, cod_movimento);


--
-- TOC entry 2091 (class 2606 OID 73925)
-- Name: mov_suprimento_cad_forma_pagamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_suprimento
    ADD CONSTRAINT mov_suprimento_cad_forma_pagamento_fk FOREIGN KEY (cod_forma_pagamento) REFERENCES cad_forma_pagamento(cod_forma_pagamento);


--
-- TOC entry 2092 (class 2606 OID 73930)
-- Name: mov_suprimento_cad_operador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_suprimento
    ADD CONSTRAINT mov_suprimento_cad_operador_fk FOREIGN KEY (cod_operador) REFERENCES cad_operador(cod_operador);


--
-- TOC entry 2093 (class 2606 OID 73935)
-- Name: mov_suprimento_mov_movimento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_suprimento
    ADD CONSTRAINT mov_suprimento_mov_movimento_fk FOREIGN KEY (loja, cod_ecf, cod_movimento) REFERENCES mov_movimento(loja, cod_ecf, cod_movimento);


--
-- TOC entry 2086 (class 2606 OID 74252)
-- Name: mov_venda_cad_operador_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_venda
    ADD CONSTRAINT mov_venda_cad_operador_fk FOREIGN KEY (cod_operador) REFERENCES cad_operador(cod_operador);


--
-- TOC entry 2087 (class 2606 OID 74257)
-- Name: mov_venda_mov_movimento_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mov_venda
    ADD CONSTRAINT mov_venda_mov_movimento_fk FOREIGN KEY (loja, cod_ecf, cod_movimento) REFERENCES mov_movimento(loja, cod_ecf, cod_movimento);


--
-- TOC entry 2111 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-01-02 16:17:11

--
-- PostgreSQL database dump complete
--

CREATE TABLE syn_data
(
  data_time bigint NOT NULL,
  update_date timestamp without time zone NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE syn_data
  OWNER TO postgres;

CREATE TABLE syn_data_exp
(
  cod_mov text NOT NULL,
  cod_ecf text NOT NULL,
  loja text NOT NULL,
  export_date timestamp without time zone NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE syn_data_exp
  OWNER TO postgres;