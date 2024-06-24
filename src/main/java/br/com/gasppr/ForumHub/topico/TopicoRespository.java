package br.com.gasppr.ForumHub.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRespository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);
}
