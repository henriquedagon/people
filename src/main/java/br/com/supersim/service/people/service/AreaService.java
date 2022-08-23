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
    @RequestMapping(method = {RequestMethod.GET}, path = {"all"})
    public List<Map<String, Object>> findAll() {
        return Area.getAllAsJson();
    }

}
