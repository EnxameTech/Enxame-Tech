package com.recodepro.enxametech.repository;

import com.recodepro.enxametech.model.Voluntario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select aluno.nome_completo, voluntario.nome_completo, \n" +
            "monitoria.descricao_duvida, monitoria.data_monitoria,monitoria.horario  from aluno, voluntario, monitoria \n" +
            "where aluno.id=monitoria.aluno_id and voluntario.id=monitoria.voluntario_id and voluntario_id= :id")
    List<Object[]> getMonitoriasVoluntario(@Param("id") Long id);
}
