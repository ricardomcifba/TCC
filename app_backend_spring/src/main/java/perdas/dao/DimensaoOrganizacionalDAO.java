package perdas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import perdas.model.UnidadeOrganizacional;

public interface DimensaoOrganizacionalDAO extends JpaRepository<UnidadeOrganizacional, Long>{

}
