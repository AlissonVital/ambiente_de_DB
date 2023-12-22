package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
        System.out.println();
        System.out.println(dados);
    }

    @GetMapping
    public List<DadosListagemMedico> listar() {
        //DadosListagemMedico- CRIADO UM DTO
        //medicoRepository- UTILISADO O REPOSITORY PARA FAZER A BUSCA
        //findAll()- UTILISADO PARA BUSCAR TODOS
        //PARA O DadosListagemMedico TRASER A LISTA, É NECESSARIO FAZER UMA CONVERÇÃO:
        //stream().map(DadosListagemMedico::new)- REALIZAR O MAPEAMENTO DO CONSTRUTOR CRIADO NA CLASSE DTO ATRAVÉS DESSE CHAMADO (DadosListagemMedico::new)
        //toList()- FAZ A CONVERSAO DE TODOS OS DADOS, CONSTRUTORES EM UMA LISTA
        return medicoRepository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
}
