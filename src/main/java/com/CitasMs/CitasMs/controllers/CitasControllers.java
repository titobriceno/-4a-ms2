package com.CitasMs.CitasMs.controllers;

import com.CitasMs.CitasMs.models.Citas;
import com.CitasMs.CitasMs.repositories.CitasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CitasControllers {
    private final CitasRepository repository;

    public CitasControllers(CitasRepository repository) {
        this.repository = repository;
    }

    /*
    OBTENER una Cita por Usuario
    Tipo: GET
    url: "/citasUsuario/{pacianteId}"
    Path Variable: le mando Cita al PacianteId
    Que me debe devolver: Cita
     */

    @GetMapping("/citasUsuario/{Id}")
    public Optional <Citas> getCitas(@PathVariable String Id) {
        return this.repository.findById(Id);
    }

    /*
    CREAR una Cita por Usuario

    Tipo: POST
    url: "/citas"
    Body: le mando una cita
    Que me debe devolver: Cita
     */

    @PostMapping("/citas")
    public Citas newCItas(@RequestBody Citas citas){
        return this.repository.save(citas);
    }

        /*
    BORRAR una Cita

    Tipo: DELETE
    url: "/citas"
    Recibe: un pacienteId
    Que me debe devolver: Una Cancelacion
     */

    @DeleteMapping("/citas/{Id}")
    public void deleteCitas(@PathVariable String Id){
        repository.deleteById(Id);
    }

    /*
    ACTUALIZAR una Cita por PacienteId

    Tipo: UPDATE
    url: "/citas"
    Body: Actualizar una Cita
    Que me debe devolver: Cita
     */

    @PutMapping("/citas/{Id}")
    public Citas updateCitas(@PathVariable String Id, @RequestBody Citas newCita){
        Citas oldCita = repository.findById(Id).orElse(null);

//        Esto actualiza el procedimiento del paciente

        oldCita.setProcedimientoFormulado(newCita.getProcedimientoFormulado());
        return repository.save(oldCita);
    }

}
