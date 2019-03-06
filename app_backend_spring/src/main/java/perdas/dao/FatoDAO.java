package perdas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import perdas.model.Fato;

public interface FatoDAO extends JpaRepository<Fato, Long> {

}