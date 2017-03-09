package lcb.com.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lcb.com.pe.domain.PermisoRepositorio;
import lcb.com.pe.domain.PermisoRepositorioId;

@Repository
public interface IPermisoRepositorioRepository extends JpaRepository<PermisoRepositorio, PermisoRepositorioId>{

}
