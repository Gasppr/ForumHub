package br.com.gasppr.ForumHub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRespository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);

    @Query("SELECT t FROM Topico t ORDER BY t.dataDeCriacao ASC")
     Page<Topico> findAllTopicos(Pageable paginacao);

    @Query("SELECT t FROM Topico t where t.curso.nomeCurso = :curso " )
    Page<Topico> findAllTopicosPorCurso(Pageable paginacao, String curso);
}
