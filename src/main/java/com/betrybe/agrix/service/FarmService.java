package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.model.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FarmService class, service layer for /farm endpoints.
 */
@Service
public class FarmService {
  private FarmRepository farmRepository;

  /**
   * Constructor function of the FarmService class.
   *
   * @param farmRepository repository received from spring
   *                        by dependency injection */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public List<Farm> getFarms() {
    List<Farm> allFarms = this.farmRepository.findAll();
    return allFarms;
  }

  public Farm createFarm(Farm newFarm) {
    Farm createdFarm = this.farmRepository.save(newFarm);
    return createdFarm;
  }

  public Optional<Farm> getFarmById(Long farmId) {
    Optional<Farm> farmFound = this.farmRepository.findById(farmId);
    return farmFound;
  }
}