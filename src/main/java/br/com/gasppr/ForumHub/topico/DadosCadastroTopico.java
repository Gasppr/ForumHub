package br.com.gasppr.ForumHub.topico;

import br.com.gasppr.ForumHub.autor.Autor;
import br.com.gasppr.ForumHub.curso.Curso;
import br.com.gasppr.ForumHub.curso.DadosCurso;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
