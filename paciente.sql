CREATE TABLE paciente(
    IDPACIENTE INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    NOMBRE VARCHAR(30) NOT NULL,
    FECHA DATE,
    SEXO CHAR,
    ESTATURA INTEGER,
)