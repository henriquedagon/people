package br.com.supersim.service.people.service;

import br.com.supersim.service.people.domain.Area;
import br.com.supersim.service.people.domain.Phase;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Service
@RestController
@RequestMapping("/phase")
@CrossOrigin(origins = "http://localhost:3000")
public class PhaseService {

    @ResponseBody
    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"/"}
    )
    public List<Phase> findAll() {
        return Phase.getAll();
    }

    @ResponseBody
    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"{id}"}
    )
    public Phase find(
            @PathVariable
                    Long id) {
        return Phase.getById(id);
    }

}
