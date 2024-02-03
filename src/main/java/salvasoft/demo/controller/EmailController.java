package salvasoft.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import salvasoft.demo.dto.EmailRequestDTO;
import salvasoft.demo.dto.EmailResponseDTO;
import salvasoft.demo.service.EmailService;

@RestController
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/enviar-correo")
    public ResponseEntity<EmailResponseDTO> enviarCorreo(@RequestBody EmailRequestDTO emailRequestDTO) {
        emailService.enviarCorreo(emailRequestDTO);
        EmailResponseDTO response = new EmailResponseDTO();
        response.setMensaje("Correo enviado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
