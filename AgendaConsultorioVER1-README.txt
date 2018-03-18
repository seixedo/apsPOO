AgendaConsultorio VER 1.0
Primeira versão do sistema de agenda para consultorio
Proxima modificação:
-trocar o tipo do campo "nascimento" de string para o tipo "date"
-Melhorar a interface

!!!!!!!--------SCRIPT PARA CRIAÇÃO DA BASE DE DADOS--------!!!!!!!
create table paciente(
cpf int not null,
nome varchar(255),
datanascimento varchar(255),
convenio varchar(255),
primary key (cpf)
);
create table medico(
crm int not null,
nome varchar(255),
especialidade varchar(255),
primary key (crm)
);

create table consulta(
id int not null auto_increment,
dia date,
hora time,
cpf_paciente int not null,
crm_medico int not null,
primary key(id),
foreign key(cpf_paciente) references paciente(cpf),
foreign key (crm_medico) references medico(crm)

);