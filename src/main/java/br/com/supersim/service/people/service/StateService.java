package br.com.supersim.service.people.service;

import br.com.supersim.service.people.domain.State;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "http://localhost:3000")
public class StateService {

    @ResponseBody
    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"/"}
    )
    public List<State> findAll() {
        return State.getAll();
    }

    @ResponseBody
    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"{id}"}
    )
    public State find(
            @PathVariable
                    Long id) {
        return State.getById(id);
    }

}
