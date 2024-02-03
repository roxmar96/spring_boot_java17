package salvasoft.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import salvasoft.demo.dto.EmailRequestDTO;
import salvasoft.demo.model.Email;
import salvasoft.demo.repo.EmailRepository;

@Service
public class EmailService {
    private final JavaMailSender emailSender;
    private final EmailRepository emailRepository;

    @Value("${spring.mail.username}")
    private String from;

    public EmailService(JavaMailSender emailSender, EmailRepository emailRepository) {
        this.emailSender = emailSender;
        this.emailRepository = emailRepository;
    }

    public void enviarCorreo(EmailRequestDTO requestDTO) {
        // Guardar el correo en la base de datos
        Email email = new Email();
        email.setCorreoDestinatario(requestDTO.getCorreoDestinatario());
        email.setAsunto(requestDTO.getAsunto());
        email.setMensaje(requestDTO.getMensaje());
        emailRepository.save(email);

        // Enviar correo electrónico
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(requestDTO.getCorreoDestinatario());
        message.setSubject(requestDTO.getAsunto());
        message.setText(requestDTO.getMensaje());
        emailSender.send(message);
    }
}
