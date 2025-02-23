package com.backend.pacientes.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate; // 💡 Importante para WebSocket
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientAlertController {

    private final RabbitTemplate rabbitTemplate;
    private final SimpMessagingTemplate messagingTemplate; // 💡 Para WebSocket

    // 🔔 Carga de propiedades desde application.properties
    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routingkey}")
    private String routingKey;

    // 💡 Inyectar también SimpMessagingTemplate
    public PatientAlertController(RabbitTemplate rabbitTemplate, SimpMessagingTemplate messagingTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * 🎯 Endpoint para iniciar las alertas respiratorias.
     * Recibe el ID del paciente desde el frontend y lo envía a RabbitMQ y WebSocket.
     */
    @PostMapping("/start-respiratory-alerts")
    public String startRespiratoryAlerts(@RequestParam String patientId) {
        System.out.println("🚨 Enviando alerta para el paciente ID: " + patientId);

        // 📡 Envía el mensaje al exchange con la routing key
        rabbitTemplate.convertAndSend(exchange, routingKey, patientId);

        // 🌐 Enviar mensaje al canal WebSocket
        messagingTemplate.convertAndSend("/topic/alerts", "🚨 Alerta para paciente ID: " + patientId);

        return "✅ Alerta respiratoria iniciada para el paciente ID: " + patientId;
    }
}
