package br.com.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.dao.AlunoDao;
import br.com.academy.model.Aluno;

@Controller
public class AlunoController {

	@Autowired
	private AlunoDao alunorepository;
	
	@GetMapping("/cadastrarAlunos")
	public ModelAndView cadastrarAlunos(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/cadastrar");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	/*Metodo para cadastrar alunos*/
	@PostMapping("cadastrarAlunos")
	public ModelAndView inserirAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/listarAlunos");
		alunorepository.save(aluno);
		return mv;
	
	}
	
	@GetMapping("listarAlunos")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/lista");
		mv.addObject("alunosList", alunorepository.findAll());
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/editar");
		Aluno aluno = alunorepository.getOne(id);
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@PostMapping("/editar")
	public ModelAndView editar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunorepository.save(aluno);
		mv.setViewName("redirect:/listarAlunos");
		return mv;
	}
	
}
