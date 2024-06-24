package br.com.gasppr.ForumHub.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Curso {


    private String nomeCurso;

    public Curso(DadosCurso curso) {
        this.nomeCurso = curso.nomeCurso();
    }
}
