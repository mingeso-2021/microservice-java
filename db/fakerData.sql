insert into public.diploma (name) values ('Diplomado en Ciencia de Datos Aplicada');
insert into public.diploma (name) values ('Diplomado en Ciberseguridad (Gestión, Técnico y Legal)');
insert into public.diploma (name) values ('Diplomado en Riesgo Operacional y Continuidad del Negocio en Procesos y TICs');
insert into public.diploma (name) values ('Diplomado en Control, Seguridad y Auditoría Computacional');
insert into public.diploma (name) values ('Diplomado en Peritaje Informático');

insert into public.evaluator (name, rut, email, phone) values ('Quispe Sanca Alcides', '22.338.702-0', 'alcides.quispe@usach.cl', '+56945089696' );
insert into public.evaluator (name, rut, email, phone) values ('Anastasia', '32.829.795-4', 'apiller0@nba.com', '+56986680389');
insert into public.evaluator (name, rut, email, phone) values ('Gilli', '15.146.897-0', 'gscarth2@rambler.com', '+56993227295');
insert into public.evaluator (name, rut, email, phone) values ('Nola', '21.753.647-2', 'nlowth3@e-recht24.com', '+56988246804');
insert into public.evaluator (name, rut, email, phone) values ('Siegfried', '23.035.745-3', 'sfavela4@dailymotion.com', '+56925632476');

insert into public.postulant (name, rut, email, phone) values ('Javier', '31.219.182-9', 'ddmisek0@prlog.org', '+56959292590');
insert into public.postulant (name, rut, email, phone) values ('Felipe', '68.728.646-2', 'twalczynski1@unicef.com', '+56967541574');
insert into public.postulant (name, rut, email, phone) values ('David', '29.188.824-9', 'rcarr2@blogtalkradio.com', '+56953026330');
insert into public.postulant (name, rut, email, phone) values ('Benjamin', '23.627.995-9', 'ldearness3@newyorker.com', '+56993037155');
insert into public.postulant (name, rut, email, phone) values ('Ignacio', '25.390.444-3', 'wclemencon4@umich.com', '+56991016207');

insert into public.secretary (name, rut, email, phone) values ('Karole', '15.404.529-4', 'krevington0@mail.ru', '+56959039759');
insert into public.secretary (name, rut, email, phone) values ('Elroy', '34.439.454-5', 'esowley1@answers.com', '+56944362274');
insert into public.secretary (name, rut, email, phone) values ('Taddeo', '49.127.511-5', 'tslyde2@gravatar.com', '+56963640597');
insert into public.secretary (name, rut, email, phone) values ('Dorelle', '50.071.995-3', 'dlauga3@exblog.jp', '+56912012520');
insert into public.secretary (name, rut, email, phone) values ('Elicia', '60.183.110-8', 'elinacre4@nature.com', '+56952083935');

insert into public.postulation (id_diploma, id_postulant, id_evaluator, id_secretary) values (1,1,1,1);
insert into public.postulation (id_diploma, id_postulant, id_evaluator, id_secretary) values (1,2,5,2);
insert into public.postulation (id_diploma, id_postulant, id_evaluator, id_secretary) values (3,3,2,2);
insert into public.postulation (id_diploma, id_postulant, id_evaluator, id_secretary) values (4,4,2,1);
insert into public.postulation (id_diploma, id_postulant, id_evaluator, id_secretary) values (4,5,3,4);