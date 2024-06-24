package br.com.gasppr.ForumHub.topico;

import br.com.gasppr.ForumHub.autor.Autor;
import br.com.gasppr.ForumHub.curso.Curso;
import jakarta.persistence.Embedded;

import java.time.LocalDateTime;
import java.util.ArrayList;

public record DadosDetalhamentoTopico(

         Long id,
         String titulo,
         String mensagem,
         LocalDateTime dataDeCriacao ,
         EstadoDoTopico estadoDoTopico,
         Autor autor,
         Curso curso
        ) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataDeCriacao(),
                topico.getEstadoDoTopico(),
                topico.getAutor(),
                topico.getCurso());
    }
}
