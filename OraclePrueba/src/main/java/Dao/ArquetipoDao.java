package Dao;

import modeloHce.Arquetipo;

public interface ArquetipoDao extends Dao {
    public void create(Arquetipo arquetipo);
    public Arquetipo read(Double idArquetipo);
    public void update(Arquetipo arquetipo);
}
