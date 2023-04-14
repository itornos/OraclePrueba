package Dao;

import java.util.List;

import modeloHce.Plantilla;

public interface PlantillaDao extends Dao{   
    public void create(Plantilla plantilla);
    public Plantilla read(Double idPlantilla);
    public List<Plantilla> read(String idPlantilla, String campo);
    public void update(Plantilla plantilla);
}
