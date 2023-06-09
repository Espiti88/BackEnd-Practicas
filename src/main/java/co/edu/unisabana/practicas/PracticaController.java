package co.edu.unisabana.practicas;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/practicas")

@RestController
public class PracticaController {

    List<PracticaDTO> practicaDTOS = new ArrayList<>();
    int registro = 1;

    @GetMapping(path = "/")
    public Respuesta saludar() {
        return new Respuesta("Servidor de Prácticas");
    }

    @GetMapping(path = "/todos")
    public List<PracticaDTO> allPracticas(){
        return practicaDTOS;
    }

    @GetMapping(path = "/buscarFecha")
    public List<PracticaDTO> buscarPoFecha (@RequestParam String fecha){

        List<PracticaDTO> BuscarPractica = new ArrayList<>();

        for (PracticaDTO practicaDTO : practicaDTOS) {
            if (practicaDTO.getFecha().equals(fecha)) {
                BuscarPractica.add(practicaDTO);
            }
        }
        return BuscarPractica;
    }

    @PostMapping(path = "/crear")
    public Respuesta crearPractica(@RequestBody @Valid PracticaDTO practicaDTO){
        practicaDTO.setId(registro);
        registro += 1;

        practicaDTOS.add(practicaDTO);
        return new Respuesta("Practica agregada correctamente");
    }

    @PutMapping(path = "/actualizar/{codigo}")
    public Respuesta actualizarPractica(@PathVariable("codigo") int codigo, @RequestBody PracticaDTO practicaDTO){

        for(PracticaDTO laPracticaDTO : practicaDTOS){

            if(laPracticaDTO.getId() == codigo){
                laPracticaDTO.setEmpresa(practicaDTO.getEmpresa());
                laPracticaDTO.setSupervisor(practicaDTO.getSupervisor());
                laPracticaDTO.setTarea(practicaDTO.getTarea());
                laPracticaDTO.setFecha(practicaDTO.getFecha());

                return new Respuesta("¡Práctica modificada!");
            }
        }
        return new Respuesta("¡No se encontró la práctica!");
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public Respuesta eliminarPractica(@PathVariable int id) {
        for (PracticaDTO practicaDTO : practicaDTOS) {
            if (practicaDTO.getId() == id) {
                practicaDTOS.remove(practicaDTO);
                return new Respuesta("¡Práctica eliminada!");
            }
        }
        return new Respuesta("¡No se encontró la práctica!");
    }
}