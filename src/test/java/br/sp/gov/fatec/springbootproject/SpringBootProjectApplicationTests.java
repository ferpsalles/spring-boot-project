package br.sp.gov.fatec.springbootproject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.sp.gov.fatec.springbootproject.Repository.AviaoRepository;
import br.sp.gov.fatec.springbootproject.Repository.PecaRepository;
import br.sp.gov.fatec.springbootproject.Repository.ManutencaoRepository;
import br.sp.gov.fatec.springbootproject.entity.Aviao;
import br.sp.gov.fatec.springbootproject.entity.Manutencao;
import br.sp.gov.fatec.springbootproject.entity.Peca;
import br.sp.gov.fatec.springbootproject.service.SegurancaService;


@SpringBootTest
@Transactional
@Rollback
class SpringBootProjectApplicationTests {

	@Autowired
	private AviaoRepository aviaoRepo;

	@Autowired
	private PecaRepository pecaRepo;

	@Autowired
	private ManutencaoRepository manutencaoRepo;

	@Autowired
	private SegurancaService segurancaService;

	@Test
	void contextLoads() {
	}

	@Test
	void findByPrefixo() {
		Aviao aviao  = new Aviao();
		aviao.setPrefixo("Teste");
		aviao.setModelo("modelo");
		aviao.setPropulsao("propulsao");
		aviaoRepo.save(aviao);

		assertNotNull(aviaoRepo.findByPrefixo("Teste"));

	}

	@Test
	void findByModeloContainsOrPrefixoContains() {

		Aviao aviao  = new Aviao();
		aviao.setPrefixo("Teste");
		aviao.setModelo("modelo");
		aviao.setPropulsao("propulsao");
		aviaoRepo.save(aviao);

		assertFalse(aviaoRepo.findByModeloContainsOrPrefixoContains("del","est").isEmpty());
	}

	@Test
	void findByAvioesModelo() {

		Peca peca = new Peca();
		peca.setCodigo("codigo");
		peca.setDescricao("descricao");
		peca.setCategoria("categoria");
		pecaRepo.save(peca);

		Aviao aviao  = new Aviao();
		aviao.setPrefixo("Teste");
		aviao.setModelo("modelo");
		aviao.setPropulsao("propulsao");
		aviaoRepo.save(aviao);
		aviao.setPeca(new HashSet<Peca>());
		aviao.getPeca().add(peca);
		aviaoRepo.save(aviao);
		assertFalse(aviaoRepo.findByPecasCodigo("codigo").isEmpty());
	}

	@Test
	void findByPecasCodigo() {
		Peca peca = new Peca();
		peca.setCodigo("codigo");
		peca.setDescricao("descricao");
		peca.setCategoria("categoria");
		pecaRepo.save(peca);

		Aviao aviao  = new Aviao();
		aviao.setPrefixo("Teste");
		aviao.setModelo("modelo");
		aviao.setPropulsao("propulsao");
		aviaoRepo.save(aviao);
		aviao.setPeca(new HashSet<Peca>());
		aviao.getPeca().add(peca);
		aviaoRepo.save(aviao);


		assertFalse(pecaRepo.findByAvioesModelo("modelo").isEmpty());
	}

	@Test
	void findByAviaoModelo(){
		Aviao aviao = new Aviao();
		aviao.setPrefixo("Teste");
		aviao.setModelo("modelo");
		aviao.setPropulsao("propulsao");
		aviaoRepo.save(aviao);
		
		Manutencao manutencao = new Manutencao();
		manutencao.setProcedimento("procedimento");
		manutencao.setData(new Date());
		manutencao.setAviao(aviao);
		manutencaoRepo.save(manutencao);

		assertFalse(aviaoRepo.findByManutencaoProcedimento("procedimento").isEmpty());

	}

	@Test
	void findByManutencaoProcedimento(){
		Aviao aviao = new Aviao();
		aviao.setPrefixo("Teste");
		aviao.setModelo("modelo");
		aviao.setPropulsao("propulsao");
		aviaoRepo.save(aviao);
		
		Manutencao manutencao = new Manutencao();
		manutencao.setProcedimento("procedimento");
		manutencao.setData(new Date());
		manutencao.setAviao(aviao);
		manutencaoRepo.save(manutencao);

		assertFalse(manutencaoRepo.findByAviaoModelo("modelo").isEmpty());

	}

	@Test
	void novoAviao() {
		segurancaService.novoAviao("modelo", "pre", "propulsao", "categoria", "descricao", "codigo");
		assertNotNull(pecaRepo.findByCodigo("codigo"));

	}



}
