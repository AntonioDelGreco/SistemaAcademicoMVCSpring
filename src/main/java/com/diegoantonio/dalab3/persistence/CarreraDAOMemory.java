package com.diegoantonio.dalab3.persistence;

import com.diegoantonio.dalab3.model.Carrera;
import com.diegoantonio.dalab3.persistence.exceptionsCustoms.NotFoundException;
import com.diegoantonio.dalab3.persistence.exceptionsCustoms.SaveException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CarreraDAOMemory implements CarreraDAO{

    private static final ArrayList<Carrera> repoCarrera = new ArrayList<Carrera>();

    @Override
    public Carrera save(Carrera c) throws SaveException {
        for ( Carrera carrera : repoCarrera ) {
            if (carrera.getNombre().equalsIgnoreCase(c.getNombre())){
                throw new SaveException("No fue posible guardar su carrera debido a que esta ya existe.");
            }
        }
        repoCarrera.add(c);
        return c;
    }

    @Override
    public Carrera findAndUpdate(Integer idCarrera, Carrera c) throws NotFoundException {
        if (repoCarrera.size() == 0) throw new NotFoundException("No existen carreras que se puedan actualizar.");
        for ( Carrera carrera : repoCarrera ) {
            if (carrera.getDepartamento().equals(idCarrera)){
                carrera.setNombre(c.getNombre());
                carrera.setCuatrimestres(c.getCuatrimestres());
                return carrera;
            }
        }
        throw new NotFoundException("No fue posible actualizar su carrera, el el departamento de la carrera no fue encontrado.");
    }

    @Override
    public void delete(Integer idCarrera) throws NotFoundException {
        if (repoCarrera.size() == 0) throw new NotFoundException("No existen carreras por lo que no sera posible borrar nada.");
        for ( Carrera carrera : repoCarrera ) {
            if (carrera.getDepartamento().equals(idCarrera)){
                repoCarrera.remove(carrera);
                return;
            }
        }
        throw new NotFoundException("No fue posible borrar su carrera, debido a que no existe una que coincida con su busqueda.");
    }
}
