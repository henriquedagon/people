package br.com.supersim.service.people.service;

import br.com.supersim.service.people.domain.Area;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
@RestController
@RequestMapping("/area")
@CrossOrigin(origins = "http://localhost:3000")
public class AreaService {

    @ResponseBody
    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"/"}
    )
    public List<Area> findAll() {
        return Area.getAll();
    }

    @ResponseBody
    @RequestMapping(
            method = {RequestMethod.GET},
            path = {"{id}"}
    )
    public Area findArea(
            @PathVariable
            Long id) {
        return Area.getById(id);
    }

}
