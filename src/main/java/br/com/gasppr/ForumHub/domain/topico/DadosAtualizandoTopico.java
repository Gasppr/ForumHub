package br.com.gasppr.ForumHub.domain.topico;

import br.com.gasppr.ForumHub.domain.autor.Autor;
import br.com.gasppr.ForumHub.domain.curso.Curso;

import java.time.LocalDateTime;

public record DadosAtualizandoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataDeCriacao ,
        EstadoDoTopico estadoDoTopico,
        Autor autor,
        Curso curso
        ) {
}
