package br.com.gasppr.ForumHub.controller;

import br.com.gasppr.ForumHub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {


    @Autowired
    TopicoRespository repository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder builder){


        var topico = new Topico(dados);

        var topicoExiste = repository.findByTituloAndMensagem(topico.getTitulo(), topico.getMensagem());

        if (!topicoExiste.isPresent()){
            repository.save(topico);

            var uri = builder.path("/topicos/${id}").buildAndExpand(topico.getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
        }

        return ResponseEntity.badRequest().body("Este Tópico já existe! procure o tópico na pesquisa para te ajudar!");

    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemDetalhamento>> listagemDeTopicos(@PageableDefault(size = 10)Pageable paginacao){

        var page = repository.findAllTopicos(paginacao).map(DadosListagemDetalhamento::new);


       return ResponseEntity.ok(page);

    }

    @GetMapping("/{nomeCurso}")
    public ResponseEntity<Page<DadosListagemDetalhamento>> listagemDeTopicosPorCurso(@PageableDefault(size = 10)Pageable paginacao, @PathVariable String nomeCurso){

        var page = repository.findAllTopicosPorCurso(paginacao,nomeCurso).map(DadosListagemDetalhamento::new);

        return ResponseEntity.ok(page);
    }


    @GetMapping("topico/{id}")
    public ResponseEntity buscarTopicoPorId(@PathVariable @Valid Long id){

       var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosListagemDetalhamento(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody  @Valid DadosAtualizandoTopico dados){
        Topico topico = repository.getReferenceById(dados.id());


        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosListagemDetalhamento(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var topico = repository.getReferenceById(id);

        repository.deleteById(topico.getId());

        return ResponseEntity.noContent().build() ;

    }
}
