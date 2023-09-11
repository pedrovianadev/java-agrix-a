package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}