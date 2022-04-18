INSERT INTO tb_categoria (nome) VALUES ('Informática');
INSERT INTO tb_categoria (nome) VALUES ('Escritório');

INSERT INTO tb_produto (nome, preco) VALUES ('Computador', 2000.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Impressora', 800.0);
INSERT INTO tb_produto (nome, preco) VALUES ('Mouse', 80.0);

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES ( 1, 1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES ( 2, 1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES ( 3, 1);
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES ( 2, 2);