package br.com.supersim.service.people.service;

import br.com.supersim.service.people.model.Candidate;
import br.com.supersim.service.people.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/candidate")
@CrossOrigin(origins = "http://localhost:3000")
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @ResponseBody
    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"all"}
    )
    public List<Candidate> findAll() {
        return this.candidateRepository.findAll();
    }


    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"{id}"}
    )
    public Candidate findById(
            @PathVariable(value = "id")
            Long id) {
        return this.candidateRepository.findById(id).orElse(null);
    }

    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"all/search"}
    )
    public List<Candidate> findAllWithFilters(
            @RequestParam String phaseValue,
            @RequestParam String areaValue) {
        return this.candidateRepository.findAllWithFilters(phaseValue, areaValue);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = {RequestMethod.POST})
    public Candidate create(
            @RequestBody Candidate candidate) {
        return this.candidateRepository.save(candidate);
    }

    @ResponseBody
    @RequestMapping(
            method = {RequestMethod.PUT},
            path = {"{id}"}
    )
    public Candidate update(
            @PathVariable(value = "id")
            Long id,
            @RequestBody
            Candidate updatedCandidate) {
        Candidate candidate = this.candidateRepository.findById(id).orElse(null);

        if (candidate != null){
            updatedCandidate.setId(candidate.getId());
            return this.candidateRepository.save(updatedCandidate);
        }
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(
            method = {RequestMethod.DELETE},
            path = {"{id}"}
    )
    public void delete(
            @PathVariable(value = "id")
            Long id) {
        this.candidateRepository.findById(id)
                .ifPresent(candidate -> this.candidateRepository.delete(candidate));   //Removes if null statement
    }

}
