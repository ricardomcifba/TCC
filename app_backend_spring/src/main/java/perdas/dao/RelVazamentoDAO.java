package perdas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import perdas.model.RegistroVazamento;

public interface RelVazamentoDAO extends JpaRepository<RegistroVazamento,Long>{

}
