package com.disenio.dao;

import com.disenio.entities.caracteristicas.Caracteristica;
import com.disenio.entities.caracteristicas.CaracteristicaValor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CaracteristicaValorDAO")
public interface CaracteristicaValorDAO extends JpaRepository<CaracteristicaValor,Integer> {
}
