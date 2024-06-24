package br.com.gasppr.ForumHub.topico;

import br.com.gasppr.ForumHub.autor.Autor;
import br.com.gasppr.ForumHub.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
}
