package br.com.controleequipamentosmanutencao.util;

import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class AppUtil {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDateTime getLocalDateTime(String data) {
        LocalDateTime localDateTime = null;
        if (Objects.nonNull(data)) {
            localDateTime = LocalDateTime.parse(data);
        }
        return localDateTime;
    }

    public static String formataData(LocalDateTime data) {
        return formatter.format(data);
    }

}
