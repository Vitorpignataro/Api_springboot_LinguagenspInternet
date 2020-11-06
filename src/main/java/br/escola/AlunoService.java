package br.escola;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository arepository;

    public void salvarAluno(Aluno aluno){
        arepository.save(aluno);
    }

    public void deletarAluno(int ra){
        arepository.deleteById(ra);
    }

    public List<Aluno> listarTodos(){
        return arepository.findAll();
    }

    public Aluno encontrarAluno(int ra){
        return arepository.findById(ra).get();
    }


}
