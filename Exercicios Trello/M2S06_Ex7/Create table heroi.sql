DO $$
	BEGIN
		/*
		* DDL - Data Definition Language
		*/
		IF  (EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'heroi')) THEN
			DROP TABLE heroi;
			RAISE NOTICE 'Heroi was deleted';
		END IF;
			

		CREATE table heroi (
			identificador integer GENERATED ALWAYS AS IDENTITY,
			nome varchar(255) NOT NULL,
			superpoder varchar(255),
			idade numeric(3),
			data_cadastro timestamp DEFAULT current_timestamp NOT NULL
		);
		RAISE NOTICE 'Heroi table was created';

		COMMENT ON TABLE heroi IS 'Tabela para cadastros de herois.';
		COMMENT ON COLUMN heroi.identificador IS 'Identificador do heroi';		
		COMMENT ON COLUMN heroi.nome IS 'Nome do heroi';
		COMMENT ON COLUMN heroi.superpoder IS 'Superpoder do heroi';		
		COMMENT ON COLUMN heroi.idade IS 'Idade do heroi';		
		COMMENT ON COLUMN heroi.data_cadastro IS 'Data em que foi realizado o cadastro do heroi';

		/*
		* DML - Data Manipulation Language
		*/
		INSERT INTO heroi (nome, superpoder, idade) VALUES ('Spiderman', 'teia', 18);
		INSERT INTO heroi (nome, superpoder, idade) VALUES ('Iron Man', 'armadura', 40);
		INSERT INTO heroi (nome, superpoder, idade) VALUES ('Batman', 'bat-coisas', 39);
		INSERT INTO heroi (nome, superpoder, idade) VALUES ('Superman', 'super-força', 26);

		UPDATE heroi SET idade = 41 WHERE identificador = 2;

		SELECT nome, idade FROM heroi WHERE idade > 30;

		SELECT identificador, nome FROM heroi WHERE superpoder IS NOT NULL;

		DELETE FROM heroi WHERE nome = 'Batman';
END $$;