package com.example.prdportal.controller;

import com.example.prdportal.model.Prd;
import com.example.prdportal.repository.PrdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prds")
@CrossOrigin(origins = "*")
public class PrdController {

    @Autowired
    private PrdRepository prdRepository;

    @GetMapping
    public List<Prd> getAllPrds() {
        return prdRepository.findAll();
    }

    @PostMapping
    public Prd createPrd(@RequestBody Prd prd) {
        return prdRepository.save(prd);
    }

    @PutMapping("/{id}")
    public Prd updatePrd(@PathVariable Long id, @RequestBody Prd prdDetails) {
        Prd prd = prdRepository.findById(id).orElseThrow();
        prd.setTitle(prdDetails.getTitle());
        prd.setStatus(prdDetails.getStatus());
        prd.setVersion(prdDetails.getVersion());
        return prdRepository.save(prd);
    }
}
