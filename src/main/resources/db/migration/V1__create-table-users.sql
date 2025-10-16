CREATE TABLE acessos_usuarios(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    loggin TEXT NOT NULL UNIQUE,
    senha TEXT NOT NULL,
    role TEXT NOT NULL
);