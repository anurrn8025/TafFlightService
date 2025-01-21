package com.aero.TafFlightService.Controllers;
import com.aero.TafFlightService.Models.FlightsDTO;
import com.aero.TafFlightService.Services.FlightServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@AllArgsConstructor
public class FlightController {
    private final FlightServiceImpl flightServiceImpl;

    //Add a new flight
    @PostMapping("/flights")
    public FlightsDTO AddFlight(@RequestBody FlightsDTO newFlight){
        return flightServiceImpl.AddFlight(newFlight);
    }

    //Retrieve all available flights
    @GetMapping("/flights")
    public List<FlightsDTO> getAllFlights(){
        return flightServiceImpl.getAllFlights();
    }

    //Retrieve single flight details
    @GetMapping("/flights/{flightId}")
    public FlightsDTO getSingleFlight(@PathVariable("flightId")Long flightId){
        return flightServiceImpl.getSingleFlight(flightId);
    }


    //  Update flight details
    @PutMapping("/flights/{flightId}")
    public String updateFlight(@PathVariable("flightId")Long flightId,@RequestBody FlightsDTO updateFlight){
        return flightServiceImpl.updateFlight(flightId,updateFlight);
    }

    //  Update flight details
    @DeleteMapping("/flights/{flightId}")
    public String deleteFlight(@PathVariable("flightId")Long flightId){
        return flightServiceImpl.deleteFlight(flightId);
    }



}
