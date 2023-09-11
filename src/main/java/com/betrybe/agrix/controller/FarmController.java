package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create class FarmController.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private FarmService farmService;

  /**
   * Class constructor FarmController.
   *
   * @param farmService service layer instance received
   *                      by dependency injection.
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Creates the POST /farms endpoint, where you can create and save
   * in the database a new farm.
   *
   * @param farmDto Receives a new farm in the Dto model
   * @return Returns a ResponseEntity with the information
   *         of the new farm created
   */
  @PostMapping
  public ResponseEntity<Farm> createFarm(@RequestBody FarmDto farmDto) {
    Farm farmToSave = farmDto.toFarm();
    Farm createdFarm = this.farmService.createFarm(farmToSave);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdFarm);
  }

  /**
   * Creates the GET /farms route that returns all registered farms.
   *
   * @return returns a list of all registered farms
   */
  @GetMapping
  public ResponseEntity<List<Farm>> getAllFarms() {
    List<Farm> allFarms = this.farmService.getFarms();
    return ResponseEntity.status(HttpStatus.OK).body(allFarms);
  }

  /**
   * Creates the GET route /farms/id that returns the farm searched by id.
   *
   * @return returns a farm from the database.
   */
  @GetMapping("/{farmId}")
  public ResponseEntity getFarmById(@PathVariable Long farmId) throws FarmNotFoundException {
    try {
      Optional<Farm> farmToFound = this.farmService.getFarmById(farmId);

      if (farmToFound.isEmpty()) {
        throw new FarmNotFoundException();
      }

      Farm farmFound = farmToFound.get();
      return ResponseEntity.status(HttpStatus.OK).body(farmFound);
    } catch (FarmNotFoundException farmNotFoundException) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(farmNotFoundException.getMessage());
    }

  }
}