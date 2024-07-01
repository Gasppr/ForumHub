package br.com.gasppr.ForumHub.domain.topico;

import br.com.gasppr.ForumHub.domain.autor.Autor;
import br.com.gasppr.ForumHub.domain.curso.DadosCurso;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @DateTimeFormat(pattern = "dd-MM-yyyy")
        LocalDateTime dataDeCriacao,

        @Enumerated(value = EnumType.STRING)
        EstadoDoTopico estadoDoTopico,


        Autor autor,

        @NotNull
        @Valid
        DadosCurso curso
        ) {
}
