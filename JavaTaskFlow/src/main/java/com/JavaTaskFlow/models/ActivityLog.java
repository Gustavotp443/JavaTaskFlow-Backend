package com.JavaTaskFlow.models;

import java.time.LocalDateTime;

public class ActivityLog {
	private String id;
    private String userId;
    private String action; // Tipo de atividade (ex: "Criou Tarefa", "Entrou no Sistema")
    private String details; // Informações extras (ex: "Criou a tarefa 'Revisar Código'")
    private LocalDateTime timestamp; // Data e hora da ação
}
