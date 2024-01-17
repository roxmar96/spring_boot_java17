package salvasoft.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import salvasoft.demo.model.Empleados;
import salvasoft.demo.repo.EmpleadosRepository;

import java.util.List;

@CrossOrigin
@RestController
@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
    @Autowired
    private EmpleadosRepository empleadosRepository;

    /*
    @GetMapping("")
    List<Empleados> index() {
        return empleadosRepository.findAll();
    }
    */

    @GetMapping("/obtener")
    List<Empleados> index() {
        return empleadosRepository.findAll();
    }

    /*
    @GetMapping("/{id}")
    Empleados getEmpleadoById(@PathVariable String id) {
        return empleadosRepository.findById(id).orElse(null);
    }
    */

    @GetMapping("/obtener/{id}")
    Empleados getEmpleadoById(@PathVariable String id) {
        return empleadosRepository.findById(id).orElse(null);
    }

    /*
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Empleados create(@RequestBody Empleados empleados){
        return empleadosRepository.save(empleados);
    }
    */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/guardar")
    Empleados create(@RequestBody Empleados empleados){
        return empleadosRepository.save(empleados);
    }

    /*
    @PutMapping("{id}")
    Empleados update (@PathVariable String id, @RequestBody Empleados empleados){
        Empleados empleadosFromDB = empleadosRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        empleadosFromDB.setNombre(empleados.getNombre());
        empleadosFromDB.setEstado(empleados.isEstado());
        empleadosFromDB.setApellido(empleados.getApellido());
        empleadosFromDB.setEdad(empleados.getEdad());
        empleadosFromDB.setCargo(empleados.getCargo());
        empleadosFromDB.setDireccion(empleados.getDireccion());
        empleadosFromDB.setFecha(empleados.getFecha());
        return empleadosRepository.save(empleadosFromDB);
    }
    */

    @PutMapping("/actualizar/{id}")
    Empleados update (@PathVariable String id, @RequestBody Empleados empleados){
        Empleados empleadosFromDB = empleadosRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        empleadosFromDB.setE_nombre(empleados.getE_nombre());
        empleadosFromDB.setE_estado(empleados.isE_estado());
        empleadosFromDB.setE_apellido(empleados.getE_apellido());
        empleadosFromDB.setE_edad(empleados.getE_edad());
        empleadosFromDB.setE_cargo(empleados.getE_cargo());
        empleadosFromDB.setE_direccion(empleados.getE_direccion());
        empleadosFromDB.setE_fecha(empleados.getE_fecha());
        empleadosFromDB.setE_ficha(empleados.getE_ficha());
        empleadosFromDB.setE_genero(empleados.getE_genero());
        empleadosFromDB.setE_dui(empleados.getE_dui());
        empleadosFromDB.setE_fechaNacimiento(empleados.getE_fechaNacimiento());
        empleadosFromDB.setE_salario(empleados.getE_salario());
        empleadosFromDB.setE_correo(empleados.getE_correo());
        empleadosFromDB.setE_telefono(empleados.getE_telefono());
        empleadosFromDB.setE_estadoCivil(empleados.getE_estadoCivil());

        return empleadosRepository.save(empleadosFromDB);
    }

    /*
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("{id}")
    void delete (@PathVariable  String id) {
        Empleados empleados = empleadosRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        empleadosRepository.delete(empleados);
    }
    */

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("/borrar/{id}")
    void delete (@PathVariable  String id) {
        Empleados empleados = empleadosRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        empleadosRepository.delete(empleados);
    }

    /*
    @PatchMapping("/{id}")
    Empleados partialUpdate(@PathVariable String id, @RequestBody Empleados empleados) {
        Empleados empleadosFromDB = empleadosRepository.findById(id).orElse(null);
        if (empleadosFromDB != null) {
            // Realiza las actualizaciones parciales según los campos proporcionados en "empleados".
            if (empleados.getNombre() != null) {
                empleadosFromDB.setNombre(empleados.getNombre());
            }
            // Continúa actualizando otros campos según sea necesario.

            return empleadosRepository.save(empleadosFromDB);
        }
        return null;
    }
    */

    @PatchMapping("/modificacion/{id}")
    Empleados partialUpdate(@PathVariable String id, @RequestBody Empleados empleados) {
        Empleados empleadosFromDB = empleadosRepository.findById(id).orElse(null);
        if (empleadosFromDB != null) {
            // Realiza las actualizaciones parciales según los campos proporcionados en "empleados".
            if (empleados.getE_nombre() != null) {
                empleadosFromDB.setE_nombre(empleados.getE_nombre());
                empleadosFromDB.setE_estado(empleados.isE_estado());
            }
            // Continúa actualizando otros campos según sea necesario.

            return empleadosRepository.save(empleadosFromDB);
        }
        return null;
    }
}
