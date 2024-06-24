package br.com.gasppr.ForumHub.controller;

import br.com.gasppr.ForumHub.topico.DadosCadastroTopico;
import br.com.gasppr.ForumHub.topico.DadosDetalhamentoTopico;
import br.com.gasppr.ForumHub.topico.Topico;
import br.com.gasppr.ForumHub.topico.TopicoRespository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {


    @Autowired
    TopicoRespository respository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder builder){


        var topico = new Topico(dados);

        var topicoExiste = respository.findByTituloAndMensagem(topico.getTitulo(), topico.getMensagem());

        if (!topicoExiste.isPresent()){
            respository.save(topico);

            var uri = builder.path("/topicos/${id}").buildAndExpand(topico.getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
        }

        return ResponseEntity.badRequest().body("Este Tópico já existe! procure o tópico na pesquisa para te ajudar!");

    }


}
