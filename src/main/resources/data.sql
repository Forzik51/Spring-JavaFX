
INSERT INTO osoba (id, pesel, imie, nazwisko, adres_email)
VALUES
    (1, '88010112345', 'Jan',    'Kowalski',    'jan.kowalski@example.com'),
    (2, '90020254321', 'Anna',   'Nowak',       'anna.nowak@example.com'),
    (3, '75030367890', 'Piotr',  'Zieliński',   'piotr.zielinski@example.com'),
    (4, '65040456789', 'Ewa',    'Wiśniewska',  'ewa.wisniewska@example.com'),
    (5, '83050523456', 'Tomasz', 'Lewandowski', 't.lewandowski@example.com');


INSERT INTO osoba (id, pesel, imie, nazwisko, adres_email)
VALUES
    (6, '88010112345', 'Jan',    'Kowalski',    'jan.kowalski@example.com'),
    (7, '90020254321', 'Anna',   'Nowak',       'anna.nowak@example.com'),
    (8, '75030367890', 'Piotr',  'Zieliński',   'piotr.zielinski@example.com'),
    (9, '65040456789', 'Ewa',    'Wiśniewska',  'ewa.wisniewska@example.com'),
    (10, '83050523456', 'Tomasz', 'Lewandowski', 't.lewandowski@example.com'),
    (11, '80010100001','Adam',   'Adminski',   'adam.admin@firma.pl'),
    (12, '81020200002','Beata',  'Dyrektor',   'beata.dyrektor@firma.pl'),
    (13, '82030300003','Cezary', 'Inzynier',   'cezary.inzynier@firma.pl'),
    (14, '83040400004','Daniel', 'Mechanik',   'daniel.mechanik@firma.pl');


INSERT INTO klient (id, nazwa_firmy)
VALUES
    (1, 'KowalTech Sp. z o.o.'),
    (2, 'Nowak i Wspólnicy'),
    (3, 'Zielinski Industries'),
    (4, 'Wiśniewska Consulting'),
    (5, 'Lewandowski Auto');

INSERT INTO poziom_umiejetnosci (id, nazwa, opis)
VALUES
    (1,'Junior', 'Początkujący poziom umiejętności'),
    (2,'Mid',    'Średniozaawansowany poziom'),
    (3,'Senior', 'Zaawansowany poziom umiejętności');

INSERT INTO fabryka (id, nazwa, lokalizacja)
VALUES
    (1,  'Fabryka ADRT5',  'Warszawa'),
    (2,  'Fabryka BKKBN7',   'Krakow'),
    (3,  'Fabryka CZRTUI','Wroclaw');


INSERT INTO pracownik (id, data_rozpoczecia, data_zakonczenia, pensja, fabryka_id, poziom_id)
VALUES
    (6, '2020-01-15', NULL, 5500.00,3,2),
    (7, '2019-05-01', '2023-06-30', 7200.50,3,2),
    (8, '2021-09-10', NULL, 4800.75,2,3),
    (9, '2018-03-20', '2022-12-31', 12000.00,2,1),
    (10, '2024-02-01', NULL, 4300.00,3,2),
    (11, '2021-01-10', NULL,   9000.00,2,2),
    (12, '2020-03-15', NULL,  15000.00,3,3),
    (13, '2022-06-01', NULL,   8000.00,1,3),
    (14, '2019-11-20', NULL,   6000.00,2,3);



INSERT INTO administrator (id, rola) VALUES
    (7, 'SYS_ADMIN'),
    (9, 'SYS_ADMIN');



INSERT INTO dyrektor (id, numer_telefonu) VALUES
    (6, '+48 600 123 456'),
    (8, '+48 608 123 456'),
    (12, '+48 670 123 456');


INSERT INTO inzynier (id, specjalnosc) VALUES
    (13, 'Oprogramowanie'),
    (11, 'ADMIN_opragram');


INSERT INTO mechanik (id, doswiadczenie) VALUES
    (14, '5 lat doświadczenia'),
    (10, '8 lat doświadczenia');


INSERT INTO kontrakt (id, opis, wartosc_kontraktu, liczba, status, klient_id)
VALUES
    (1,'Produkcja 16 mysliwcow wielozadaniowych F-16 wg specyfikacji NATO',15000000.00,16,'Oczekujacy',1),
    (2,'Wytworzenie 12 czolgow M1A2 Abrams z pakietem modernizacyjnym',8000500.00, 10, 'WRealizacji',2),
    (3,'Modernizacja i uruchomienie drugiej linii montazowej samolotow transportowych',23000000.00,2,'Zakonczony',1),
    (4,'Wstrzymanie produkcji czolgow M1A2 ze wzgledu na brak kluczowych podzespolow',5000000.00,4,'Wstrzymany',4),
    (5,'Anulowanie kontraktu na okresowy przeglad maszyn wojskowych i systemow podporzadkowania',4500750.00,1,'Anulowany',3);


INSERT INTO pojazd (id, model, opis_statusu, fabryka_id, kontrakt_id)
VALUES
    (1, 'F-16C Block 50', 'Sprawny mysliwiec F-16C gotowy do pierwszego lotu',                  1, 1),
    (2, 'M1A2 Abrams SEP v3', 'Pelna sprawnosc pancerza i uzbrojenia, gotowy do akcji',         2, 2),
    (3, 'C-130H Hercules',    'Transportowy samolot gotowy do transportu ciezkiego sprzetu',   3, 3);

INSERT INTO czesc (id, nazwa, opis, cena, pojazd_id)
VALUES
    (1, 'Skrzydło',      'Lewy i prawy skrzydłowy panel',         50000.00  ,1),
    (2, 'Silnik odrzutowy','Turbosprężarka do silnika odrzutowego',150000.00,1),
    (3, 'Armata 88mm',   'Główne działo czołgowe kal. 88 mm',      120000.00,2),
    (4, 'Gąsienica',     'Zestaw gąsienic stalowych',            30000.00   ,3);


INSERT INTO Pojazd_Inzynier (pojazd_id, inzynier_id)
VALUES
    (1, 13),
    (1, 11),
    (2, 13),
    (3, 11);

INSERT INTO Pojazd_Mechanik (pojazd_id, mechanik_id)
VALUES
    (1, 14),
    (1, 10),
    (2, 14),
    (3, 10);


INSERT INTO samolot (id, rozpietosc_skrzydel, liczba_silnikow, moc_silnika)
VALUES
    (1, 28.5, 2, 1500.0),
    (3, 24.0, 1,  950.0);


INSERT INTO tank (id, grubosc_pancerza, waga, moc_silnika, uzbrojenie)
VALUES
    (2, 120.0, 60000.0, 1500.0, 'Armata kal. 88 mm');










