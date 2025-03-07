package com.JavaTaskFlow.models;

import java.time.LocalDateTime;
import java.util.List;

public class Task {
	private String id;
    private String name;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private String projectId; // Projeto ao qual a tarefa pertence
    private String assignedTo; // Usuário responsável pela tarefa
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
