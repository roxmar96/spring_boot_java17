package salvasoft.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Email {

    @Id
    private String id;
    private String correoDestinatario;
    private String asunto;
    private String mensaje;

}
