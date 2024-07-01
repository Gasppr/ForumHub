package br.com.gasppr.ForumHub.topico;

import br.com.gasppr.ForumHub.autor.Autor;
import br.com.gasppr.ForumHub.curso.Curso;

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
