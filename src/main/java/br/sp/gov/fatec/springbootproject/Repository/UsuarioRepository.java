package br.sp.gov.fatec.springbootproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sp.gov.fatec.springbootproject.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
