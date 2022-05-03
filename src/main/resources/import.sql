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
