package com.JavaTaskFlow.models;

import java.time.LocalDateTime;

public class Notification {
	private String id;
    private String userId; // Quem recebe a notificação
    private String message; // Ex: "Você foi adicionado ao projeto 'Novo App'"
    private String type; // "TASK_ASSIGNED", "PROJECT_INVITE", etc.
    private boolean read; // Se a notificação foi lida
    private LocalDateTime createdAt; // Data e hora
}
