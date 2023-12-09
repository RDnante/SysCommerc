insert into poste(nom) values
                 ('employee'),
                 ('chef');

insert into service values (default,'economique');
insert into service values (default,'securite');
insert into service values (default,'magasin');

insert into login(idService,idPoste,password) values
                 (1,1,'eco123E'),
                 (1,2,'eco123'),
                 (2,1,'secu123E'),
                 (2,2,'secu123'),
                 (3,1,'mag123E'),
                 (3,1,'mag123');

INSERT INTO unite(libelle) VALUES
                ('unite'),
                ('kg'),
                ('litre');

INSERT INTO typeGestion(libelle,typeGestion) VALUES
                        ('LIFO', 'desc'),
                        ('FIFO', 'asc');

insert into categorie values (default,'fourniture');
insert into categorie values (default,'ustensile');
insert into categorie values (default,'aliment');

insert into article values (default,1,'stylo',1,1);
insert into article values  (default,2,'couteau',1,1);
insert into article values  (default,3,'Riz',3,2);

insert into fournisseur values (default,'jumbo');
insert into fournisseur values (default,'cosmos');

insert into stock_fournisseur values (default,1,1,150,340);
insert into stock_fournisseur values (default,2,2,150,340);
insert into stock_fournisseur values (default,1,2,150,340);