package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.model.repositories.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class FarmService.
 */
@Service
public class FarmService {

  private FarmRepository farmRepository;

  /**
   * Function to construct class FarmService.
   *
   * @param farmRepository repository received by spring
   *                       by injection and dependency
   */
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

}