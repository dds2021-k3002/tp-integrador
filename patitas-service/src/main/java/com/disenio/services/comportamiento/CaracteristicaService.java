package com.disenio.services.comportamiento;

import com.disenio.entities.caracteristicas.Caracteristica;

import java.util.List;

public interface CaracteristicaService {

    void alta(Caracteristica caracteristica);

    List<Caracteristica> getCaracteristicaAll();
}
