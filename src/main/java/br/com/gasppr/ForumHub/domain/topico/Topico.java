package br.com.gasppr.ForumHub.domain.topico;

import br.com.gasppr.ForumHub.domain.autor.Autor;
import br.com.gasppr.ForumHub.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataDeCriacao ;

    private EstadoDoTopico estadoDoTopico;

    @Embedded
    private Autor autor;

    @Embedded
    private Curso curso;


    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataDeCriacao = dados.dataDeCriacao();
        this.estadoDoTopico = dados.estadoDoTopico();
        this.autor = dados.autor();
        this.curso = new Curso(dados.curso());
    }

    public void atualizarInformacoes(DadosAtualizandoTopico dados) {

        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }

        if(dados.mensagem() != null){
            this.mensagem= dados.mensagem();
        }

        if(dados.dataDeCriacao() != null){
            this.dataDeCriacao = dados.dataDeCriacao();
        }

        if(dados.estadoDoTopico() != null){
            this.estadoDoTopico = dados.estadoDoTopico();
        }

        if(dados.autor() != null){
            this.autor = dados.autor();
        }

        if(dados.curso() != null){
            this.curso = dados.curso();
        }
    }
}
