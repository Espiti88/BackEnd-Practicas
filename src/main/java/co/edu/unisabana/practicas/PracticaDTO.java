package co.edu.unisabana.practicas;

import lombok.*;
import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PracticaDTO {

    @NotEmpty(message = "Se requiere el nombre de la empresa")
    @NotNull(message = "Se requiere rellenar el campo de empresa")
    @Size(min = 3)
    private String empresa;

    @NotEmpty(message = "Se requiere el nombre del supervisor")
    @NotNull(message = "Se requiere rellenar el campo de supervisor")
    @Size(min = 3)
    private String supervisor;

    @NotEmpty(message = "Se requiere una descripción de la tarea")
    @NotNull(message = "Se requiere rellenar el campo de tarea")
    @Size(min = 3)
    private String tarea;

    @NotEmpty(message = "Se requiere una fecha")
    @NotNull(message = "Se requiere rellenar el campo de fecha")
    private Date fecha;
}
