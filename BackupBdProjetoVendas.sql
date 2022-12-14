PGDMP     :                
    z            postgres    15.0    15.0     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    5    postgres    DATABASE        CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE postgres;
                postgres    false            ?           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3065                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            ?           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            ?            1259    16663    id_cliente_sequence    SEQUENCE     ?   CREATE SEQUENCE public.id_cliente_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999
    CACHE 1;
 *   DROP SEQUENCE public.id_cliente_sequence;
       public          postgres    false            ?            1259    16632    cliente    TABLE     ?   CREATE TABLE public.cliente (
    id integer DEFAULT nextval('public.id_cliente_sequence'::regclass) NOT NULL,
    nome character varying(60) NOT NULL,
    cpf character varying(11) NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false    150            ?            1259    16662    id_item_sequence    SEQUENCE     ?   CREATE SEQUENCE public.id_item_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999
    CACHE 1;
 '   DROP SEQUENCE public.id_item_sequence;
       public          postgres    false            ?            1259    16665    id_itemvenda_sequence    SEQUENCE     ?   CREATE SEQUENCE public.id_itemvenda_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999
    CACHE 1;
 ,   DROP SEQUENCE public.id_itemvenda_sequence;
       public          postgres    false            ?            1259    16664    id_venda_sequence    SEQUENCE     ?   CREATE SEQUENCE public.id_venda_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999
    CACHE 1;
 (   DROP SEQUENCE public.id_venda_sequence;
       public          postgres    false            ?            1259    16627    item    TABLE     ?   CREATE TABLE public.item (
    id integer DEFAULT nextval('public.id_item_sequence'::regclass) NOT NULL,
    descricao character varying(60) NOT NULL,
    valor numeric(10,2) NOT NULL
);
    DROP TABLE public.item;
       public         heap    postgres    false    149            ?            1259    16647 	   itemvenda    TABLE     ?   CREATE TABLE public.itemvenda (
    id integer DEFAULT nextval('public.id_itemvenda_sequence'::regclass) NOT NULL,
    id_venda integer NOT NULL,
    id_item integer NOT NULL,
    qtde integer NOT NULL
);
    DROP TABLE public.itemvenda;
       public         heap    postgres    false    152            ?            1259    16637    venda    TABLE     ?   CREATE TABLE public.venda (
    id integer DEFAULT nextval('public.id_venda_sequence'::regclass) NOT NULL,
    id_cliente integer NOT NULL,
    vl_total numeric(10,2) NOT NULL
);
    DROP TABLE public.venda;
       public         heap    postgres    false    151            ?          0    16632    cliente 
   TABLE DATA           0   COPY public.cliente (id, nome, cpf) FROM stdin;
    public          postgres    false    146   ~       ?          0    16627    item 
   TABLE DATA           4   COPY public.item (id, descricao, valor) FROM stdin;
    public          postgres    false    145           ?          0    16647 	   itemvenda 
   TABLE DATA           @   COPY public.itemvenda (id, id_venda, id_item, qtde) FROM stdin;
    public          postgres    false    148   y        ?          0    16637    venda 
   TABLE DATA           9   COPY public.venda (id, id_cliente, vl_total) FROM stdin;
    public          postgres    false    147   ?        ?           0    0    id_cliente_sequence    SEQUENCE SET     B   SELECT pg_catalog.setval('public.id_cliente_sequence', 13, true);
          public          postgres    false    150            ?           0    0    id_item_sequence    SEQUENCE SET     >   SELECT pg_catalog.setval('public.id_item_sequence', 8, true);
          public          postgres    false    149            ?           0    0    id_itemvenda_sequence    SEQUENCE SET     D   SELECT pg_catalog.setval('public.id_itemvenda_sequence', 22, true);
          public          postgres    false    152            ?           0    0    id_venda_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.id_venda_sequence', 11, true);
          public          postgres    false    151            ?           2606    16636    cliente pk_cliente 
   CONSTRAINT     P   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cliente DROP CONSTRAINT pk_cliente;
       public            postgres    false    146            ?           2606    16631    item pk_item 
   CONSTRAINT     J   ALTER TABLE ONLY public.item
    ADD CONSTRAINT pk_item PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.item DROP CONSTRAINT pk_item;
       public            postgres    false    145            ?           2606    16651    itemvenda pk_itemvenda 
   CONSTRAINT     T   ALTER TABLE ONLY public.itemvenda
    ADD CONSTRAINT pk_itemvenda PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.itemvenda DROP CONSTRAINT pk_itemvenda;
       public            postgres    false    148            ?           2606    16641    venda pk_venda 
   CONSTRAINT     L   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT pk_venda PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.venda DROP CONSTRAINT pk_venda;
       public            postgres    false    147            ?           2606    16642    venda fk_cliente_venda    FK CONSTRAINT     z   ALTER TABLE ONLY public.venda
    ADD CONSTRAINT fk_cliente_venda FOREIGN KEY (id_cliente) REFERENCES public.cliente(id);
 @   ALTER TABLE ONLY public.venda DROP CONSTRAINT fk_cliente_venda;
       public          postgres    false    146    2967    147            ?           2606    16657    itemvenda fk_item_itemvenda    FK CONSTRAINT     y   ALTER TABLE ONLY public.itemvenda
    ADD CONSTRAINT fk_item_itemvenda FOREIGN KEY (id_item) REFERENCES public.item(id);
 E   ALTER TABLE ONLY public.itemvenda DROP CONSTRAINT fk_item_itemvenda;
       public          postgres    false    2965    145    148            ?           2606    16652    itemvenda fk_venda_itemvenda    FK CONSTRAINT     |   ALTER TABLE ONLY public.itemvenda
    ADD CONSTRAINT fk_venda_itemvenda FOREIGN KEY (id_venda) REFERENCES public.venda(id);
 F   ALTER TABLE ONLY public.itemvenda DROP CONSTRAINT fk_venda_itemvenda;
       public          postgres    false    148    147    2969            ?   ?   x?m?=
B1?z?9?d7?MRۊX??͢)??x????_H??0L?????n?ع?W?*%)?O?!??\?QƬ/??'Lo??ͣf!y?4[(&b!?? l??????|?'??Ps?۩??Tb`zNW?? ?8?      ?   V   x?3??,???KU04?4500?30?2?LN?)?I,?44ҳ0?2?,I-.I?4˚r????+x????MABf?%?Y?9??`^? ?_3      ?   c   x????0??a??@?t?9j*K???11??Hc???	n?	?????rjj???EEWPP??Tl?
?Qː???1D_.,-?b??߇???7      ?   J   x??? !Ϥ?<?U{?????f ??nJN?bPI)????Ni?㰟Y3+??????𙒤6ň?Zu??"?#.?     