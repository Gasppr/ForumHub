package br.com.gasppr.ForumHub.topico;

import java.time.LocalDateTime;

public record DadosListagemDetalhamento(String titulo,
                                        String mensagem ,
                                        LocalDateTime dataDeCriação,
                                        EstadoDoTopico estado,
                                        String autor,
                                        String curso
                                        ) {
    public DadosListagemDetalhamento(Topico topico){
        this(topico.getTitulo(),topico.getMensagem(),topico.getDataDeCriacao(),topico.getEstadoDoTopico(),topico.getAutor().getNome(), topico.getCurso().getNomeCurso());
    }
}
