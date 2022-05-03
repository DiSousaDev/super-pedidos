
    create table tb_categoria (
       id integer not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table tb_cidade (
       id integer not null auto_increment,
        nome varchar(255),
        estado_id integer,
        primary key (id)
    ) engine=InnoDB;

    create table tb_cliente (
       id integer not null auto_increment,
        cpf_ou_cnpj varchar(255),
        email varchar(255),
        nome varchar(255),
        tipo integer,
        primary key (id)
    ) engine=InnoDB;

    create table tb_endereco (
       id integer not null auto_increment,
        bairro varchar(255),
        cep varchar(255),
        complemento varchar(255),
        logradouro varchar(255),
        numero varchar(255),
        cidade_id integer,
        cliente_id integer,
        primary key (id)
    ) engine=InnoDB;

    create table tb_estado (
       id integer not null auto_increment,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table tb_item_pedido (
       desconto double precision,
        preco double precision,
        quantidade integer,
        produto_id integer not null,
        pedido_id integer not null,
        primary key (pedido_id, produto_id)
    ) engine=InnoDB;

    create table tb_pagamento (
       pedido_id integer not null,
        estado integer,
        primary key (pedido_id)
    ) engine=InnoDB;

    create table tb_pagamento_com_boleto (
       data_pagamento datetime(6),
        data_vencimento datetime(6),
        pedido_id integer not null,
        primary key (pedido_id)
    ) engine=InnoDB;

    create table tb_pagamento_com_cartao (
       numero_de_parcelas integer,
        pedido_id integer not null,
        primary key (pedido_id)
    ) engine=InnoDB;

    create table tb_pedido (
       id integer not null auto_increment,
        instante datetime(6),
        client_id integer,
        endereco_de_entrega_id integer,
        primary key (id)
    ) engine=InnoDB;

    create table tb_produto (
       id integer not null auto_increment,
        nome varchar(255),
        preco double precision,
        primary key (id)
    ) engine=InnoDB;

    create table tb_produto_categoria (
       produto_id integer not null,
        categoria_id integer not null
    ) engine=InnoDB;

    create table tb_telefone (
       cliente_id integer not null,
        telefones varchar(255)
    ) engine=InnoDB;

    alter table tb_cidade 
       add constraint FKlxge3ne91xrep1oe4cvrjldmm 
       foreign key (estado_id) 
       references tb_estado (id);

    alter table tb_endereco 
       add constraint FKotpdj815kf867dbkfbctglsjj 
       foreign key (cidade_id) 
       references tb_cidade (id);

    alter table tb_endereco 
       add constraint FKtqe8u5ggrtf93dr80hiibdfd 
       foreign key (cliente_id) 
       references tb_cliente (id);

    alter table tb_item_pedido 
       add constraint FKgfmv77km3wt2evaaq2vkiv2oj 
       foreign key (produto_id) 
       references tb_produto (id);

    alter table tb_item_pedido 
       add constraint FK3qvnhpdyxagngbf1t326cvnse 
       foreign key (pedido_id) 
       references tb_pedido (id);

    alter table tb_pagamento 
       add constraint FKjghfnncmma1w9wn5hnpq6nhx2 
       foreign key (pedido_id) 
       references tb_pedido (id);

    alter table tb_pagamento_com_boleto 
       add constraint FK3soda87ogb9jhvkhlf9rjpkbw 
       foreign key (pedido_id) 
       references tb_pagamento (pedido_id);

    alter table tb_pagamento_com_cartao 
       add constraint FKgxkpgslbqw568tww7uebyh0e8 
       foreign key (pedido_id) 
       references tb_pagamento (pedido_id);

    alter table tb_pedido 
       add constraint FK4jgc6wdyd5qy8eec96xwrjgbr 
       foreign key (client_id) 
       references tb_cliente (id);

    alter table tb_pedido 
       add constraint FKmfmrxaiieg7pbiuii68005j3q 
       foreign key (endereco_de_entrega_id) 
       references tb_endereco (id);

    alter table tb_produto_categoria 
       add constraint FK3becm1bka4cpmorcubx1fxl02 
       foreign key (categoria_id) 
       references tb_categoria (id);

    alter table tb_produto_categoria 
       add constraint FK98jyjls8tavr9o4wur6g9780c 
       foreign key (produto_id) 
       references tb_produto (id);

    alter table tb_telefone 
       add constraint FKpwjwudqbv75e49ux295dm87al 
       foreign key (cliente_id) 
       references tb_cliente (id);
INSERT INTO tb_categoria (nome) VALUES ('Informática');
INSERT INTO tb_categoria (nome) VALUES ('Escritório');
INSERT INTO tb_categoria (nome) VALUES ('Cama mesa e banho');
INSERT INTO tb_categoria (nome) VALUES ('Eletrônicos');
INSERT INTO tb_categoria (nome) VALUES ('Jardinagem');
INSERT INTO tb_categoria (nome) VALUES ('Decoração');
INSERT INTO tb_categoria (nome) VALUES ('Perfumaria');
INSERT INTO tb_produto (nome, preco) VALUES ('Computador', 2000.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Impressora', 800.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Mouse', 80.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Mesa de Escritório', 300.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Toalha', 50.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Colcha', 200.0);
INSERT INTO tb_produto (nome, preco) VALUES ('TV True Color', 1200.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Roçadeira', 800.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Abajour', 100.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Pendente', 180.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Shampoo', 90.0);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1, 1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2, 1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3, 1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2, 2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (4, 2);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (5, 3);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (6, 3);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (1, 4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (2, 4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (3, 4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (7, 4);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (8, 5);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (9, 6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (10, 6);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES (11, 7);
INSERT INTO tb_estado (nome) VALUES ('Minas Gerais');
INSERT INTO tb_estado (nome) VALUES ('São Paulo');
INSERT INTO tb_cidade (nome, estado_id) VALUES ('Uberlândia', 1);
INSERT INTO tb_cidade (nome, estado_id) VALUES ('São Paulo', 2);
INSERT INTO tb_cidade (nome, estado_id) VALUES ('Campinas', 2);
INSERT INTO tb_cliente (nome, email, cpf_ou_cnpj, tipo) values ('Maria Silva', 'maria@gmail.com', '36378912377', '1');
INSERT INTO tb_telefone (cliente_id, telefones) values (1, '27363323');
INSERT INTO tb_telefone (cliente_id, telefones) values (1, '93838393');
INSERT INTO tb_endereco (logradouro, numero, complemento, bairro, cep, cliente_id, cidade_id) values ('Rua Flores', '300', 'Apto 303', 'Jardim', '38220834', 1, 1);
INSERT INTO tb_endereco (logradouro, numero, complemento, bairro, cep, cliente_id, cidade_id) values ('Avenida Matos', '105', 'Sala 800', 'Centro', '38777012', 1, 2);
INSERT INTO tb_pedido (instante, client_id, endereco_de_entrega_id) values ('2017-09-30 10:32:00', 1, 1);
INSERT INTO tb_pedido (instante, client_id, endereco_de_entrega_id) values ('2017-10-10 19:35:00', 1, 2);
INSERT INTO tb_pagamento (pedido_id, estado) values (1, 2);
INSERT INTO tb_pagamento (pedido_id, estado) values (2, 1);
INSERT INTO tb_pagamento_com_cartao (pedido_id, numero_de_parcelas) values (1, 6);
INSERT INTO tb_pagamento_com_boleto (pedido_id, data_vencimento, data_pagamento) values (2,'2017-10-20 00:00:00', null);
INSERT INTO tb_item_pedido(desconto, preco, quantidade, produto_id, pedido_id) VALUES (0.0, 2000.0, 1, 1, 1);
INSERT INTO tb_item_pedido(desconto, preco, quantidade, produto_id, pedido_id) VALUES (0.0, 80.0, 2, 3, 1);
INSERT INTO tb_item_pedido(desconto, preco, quantidade, produto_id, pedido_id) VALUES (100.0, 800.0, 1, 2, 2);
