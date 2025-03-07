package com.JavaTaskFlow.models;

import java.time.LocalDateTime;

public class UserSession {
	private String sessionId; // ID da sessão (gerado aleatoriamente)
    private String userId; 
    private String deviceInfo; // Ex: "Chrome - Windows 11"
    private String ipAddress; // Endereço IP do usuário
    private LocalDateTime createdAt; 
    private LocalDateTime lastActivity; // Última interação do usuário
    private boolean active; // Sessão ativa ou encerrada
}
