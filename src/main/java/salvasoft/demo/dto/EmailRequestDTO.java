package salvasoft.demo.dto;

import lombok.Data;

@Data
public class EmailRequestDTO {
    private String correoDestinatario;
    private String asunto;
    private String mensaje;
}
