package br.escola;

import br.escola.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping("/alunos")
    public List<Aluno> listaAlunos() {
        return service.listarTodos();
    }

    @PostMapping("/alunos")
    public void adicionar(@RequestBody Aluno aluno){
        service.salvarAluno(aluno);
    }

    @PutMapping("/alunos/{ra}")
    public ResponseEntity<?> atualizar(@RequestBody Aluno aluno, @PathVariable Integer ra){

        Aluno existente = service.encontrarAluno(ra);
        if(existente != null)
        {
            service.salvarAluno(aluno);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
