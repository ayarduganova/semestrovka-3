package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import java.time.LocalDateTime;

public record MessageResponse(String content, String recipient, String sender, LocalDateTime sentAt) {
}
