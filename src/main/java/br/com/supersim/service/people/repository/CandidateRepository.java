package br.com.supersim.service.people.repository;

import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import br.com.supersim.service.people.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {


    /**
     * Find all candidates in phase and area.
     *
     * @param  phaseValue   Phase value.
     * @param  areaValue    Area value.
     * @return              Candidates.
     */
    @Transactional(
            propagation = Propagation.NOT_SUPPORTED,
            readOnly = true,
            timeout = 20
    )
    @Query(
            nativeQuery = true,
            value = ("SELECT * FROM Candidate candidate " +
                    "WHERE phase = :phaseValue " +
//                    "and area ->> 'value' = :areaValue"
                    "and area = :areaValue"
            )
    )
    List<Candidate> findAllWithFilters(
            @Param("phaseValue")
                    String phaseValue,
            @Param("areaValue")
                    String areaValue);

    /**
     * Finds a candidate by its identifier.
     *
     * @param  id The candidate identifier.
     * @return    The candidate.
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT candidate FROM Candidate candidate WHERE id = :id")
    @Transactional(
            propagation = Propagation.REQUIRED,
            timeout = 31
    )
    Optional<Candidate> findByIdForUpdate(
            @Param("id")
                    Long id);

}
