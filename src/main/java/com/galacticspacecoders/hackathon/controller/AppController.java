package com.galacticspacecoders.hackathon.controller;

import com.galacticspacecoders.hackathon.model.dto.GameDto;
import com.galacticspacecoders.hackathon.model.dto.PhytoplanktonDto;
import com.galacticspacecoders.hackathon.model.services.PhytoplanktonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(name = "The Phytoplankton Adventure Application", description = "CRUD Operations from Ocean Gardens Server")
@AllArgsConstructor
@RestController
@RequestMapping(value= "api/v1")
public class AppController {

    @Autowired
    private final PhytoplanktonService phytoplanktonService;

//    @Operation(
//            summary = "Feed check endpoint",
//            description = "Description: This method check if the player is feeding the phytoplankton",
//            responses = {
//                    @ApiResponse(
//                            responseCode = "200",
//                            description = "Phytoplankton well fed",
//                            content = @Content),
//                    @ApiResponse(
//                            responseCode = "500",
//                            description = "INTERNAL_ERROR",
//                            content = @Content)
//            }
//    )
//    @GetMapping("/missingPhotosynthesis") //método aleatorio
//    public ResponseEntity<?> lackOfPhotosynthesis() {
//        return new ResponseEntity<>(phytoplanktonService.tooMuchTimeWithoutPhotosynthesis(), HttpStatus.OK);
//    }

    @Operation(
            summary = "Game action endpoint",
            description = "Description: This method allow the user interact with the their phytoplankton",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Well played",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "500",
                            description = "INTERNAL_ERROR",
                            content = @Content)
            }
    )
    @PostMapping("/action")
    public ResponseEntity<?> performAction(@RequestBody GameDto gameDto) {

        log.info(gameDto.toString());
        return new ResponseEntity<>(phytoplanktonService.fromFrontend(gameDto), HttpStatus.OK);
    }

}
