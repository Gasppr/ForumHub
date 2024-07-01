package br.com.gasppr.ForumHub.domain.topico;

import br.com.gasppr.ForumHub.domain.autor.Autor;
import br.com.gasppr.ForumHub.domain.curso.Curso;

import java.time.LocalDateTime;

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
