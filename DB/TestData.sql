INSERT INTO messengerDB.conversation (Id, `Date`) 
	VALUES (1, DEFAULT);

INSERT INTO messengerDB.UserConversation (IdUser, IdConversation, NombreConversacion) 
	VALUES (1, 1, 'Prueba1');
INSERT INTO messengerDB.UserConversation (IdUser, IdConversation, NombreConversacion) 
	VALUES (2, 1, 'Prueba1');



INSERT INTO messengerDB.Message (Id, `Date`, Text, IdConversation, User_Id, Hora) 
	VALUES (1, DEFAULT, 'Sotcio le gustan las estrellas?', 1, 1, DEFAULT);
INSERT INTO messengerDB.Message (Id, `Date`, Text, IdConversation, User_Id, Hora) 
	VALUES (2, DEFAULT, 'No se, pues si creo, por?', 1, 2, DEFAULT);
INSERT INTO messengerDB.Message (Id, `Date`, Text, IdConversation, User_Id, Hora) 
	VALUES (3, DEFAULT, 'Porque miyoz tien 13 lok', 1, 1, DEFAULT);


INSERT INTO messengerDB.conversation (Id, `Date`) 
	VALUES (2, DEFAULT);

INSERT INTO messengerDB.UserConversation (IdUser, IdConversation, NombreConversacion) 
	VALUES (3, 2, 'Prueba2');
INSERT INTO messengerDB.UserConversation (IdUser, IdConversation, NombreConversacion) 
	VALUES (2, 2, 'Prueba2');


INSERT INTO messengerDB.Message (Id, `Date`, Text, IdConversation, User_Id, Hora) 
	VALUES (4, DEFAULT, 'Que mas? que hace?', 2, 3, DEFAULT);
INSERT INTO messengerDB.Message (Id, `Date`, Text, IdConversation, User_Id, Hora) 
	VALUES (5, DEFAULT, 'Nada aca sufriendo con el proyecto', 2, 2, DEFAULT);
INSERT INTO messengerDB.Message (Id, `Date`, Text, IdConversation, User_Id, Hora) 
	VALUES (6, DEFAULT, 'Uyyy re hardcore, suerte', 2, 3, DEFAULT);
