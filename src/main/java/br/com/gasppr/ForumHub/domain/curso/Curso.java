package br.com.gasppr.ForumHub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
