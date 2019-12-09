use ecommerce;

create table tblCliente(
	idUser int not null auto_increment,
	nome varchar(100),
	email varchar(50),
	senha varchar(20),
	constraint pk_usuario primary key (idUser)
);

create table tblEndereco(
	idEnd int not null auto_increment,
	tipoLogradouro varchar(100),
	logradouro varchar(50),
	numero int(5),
	complemento  varchar(50),
	cep varchar(10),
	cidade varchar(50),
	bairro varchar(50),
	estado varchar(50),
	cliente int not null,
	constraint pk_endereco primary key (idend),
	constraint fk_clienteEndereco foreign key (cliente) references tblCliente(idUser)
);

create table tblCompra(
	idCompra int not null auto_increment,
	data date,
	status varchar(50),
	cliente int not null,
	valorBruto  float(7),
	desconto float(7),
	valorTotal float(7),
	constraint pk_pedido primary key (idCompra),
	constraint fk_clienteCompra foreign key (cliente) references tblCliente(idUser)
);

create table tblProduto(
	idProd int not null auto_increment,
	titulo varchar(50),
	descricao text,
	preco float(7),
	categoria varchar(50),
	urlFoto1 varchar(100),
	urlFoto2 varchar(100),
	urlFoto3 varchar(100),
	constraint pk_produto primary key (idprod)
);

create table tblPedido(
	idCompra int not null,
	idProduto int not null,
	constraint fk_compra foreign key (idCompra) references tblCompra(idCompra),
	constraint fk_idProduto foreign key (idProduto) references tblProduto(idProd)
)