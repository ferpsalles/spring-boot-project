package br.sp.gov.fatec.springbootproject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import br.sp.gov.fatec.springbootproject.Repository.AviaoRepository;
import br.sp.gov.fatec.springbootproject.entity.Aviao;


@SpringBootTest
@Transactional
@Rollback
class SpringBootProjectApplicationTests {

	@Autowired
	private AviaoRepository aviaoRepo;

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

}
