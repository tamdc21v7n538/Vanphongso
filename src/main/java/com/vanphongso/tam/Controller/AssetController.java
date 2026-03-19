package com.vanphongso.tam.Controller;

import com.vanphongso.tam.entity.Asset;
import com.vanphongso.tam.repository.AssetRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@RestController
@RequestMapping("/api/assets")
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @GetMapping
    public List<Asset> getAll() {
        return assetRepository.findAll();
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return assetRepository.save(asset);
    }
}