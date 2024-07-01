package br.com.gasppr.ForumHub.controller;

import br.com.gasppr.ForumHub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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


    @GetMapping
    public ResponseEntity<Page<DadosListagemDetalhamento>> listagemDeTopicos(@PageableDefault(size = 10)Pageable paginacao){

        var page = respository.findAllTopicos(paginacao).map(DadosListagemDetalhamento::new);


       return ResponseEntity.ok(page);

    }

    @GetMapping("/{nomeCurso}")
    public ResponseEntity<Page<DadosListagemDetalhamento>> listagemDeTopicosPorCurso(@PageableDefault(size = 10)Pageable paginacao, @PathVariable String nomeCurso){

        var page = respository.findAllTopicosPorCurso(paginacao,nomeCurso).map(DadosListagemDetalhamento::new);

        return ResponseEntity.ok(page);
    }

}
