package com.aero.TafFlightService.Services.Interfaces;

import com.aero.TafFlightService.Models.FlightsDTO;

import java.util.List;

public interface FlightService {

    FlightsDTO AddFlight(FlightsDTO newFlight);
    List<FlightsDTO> getAllFlights();
    FlightsDTO getSingleFlight(Long flightId);
    String updateFlight(Long flightId,FlightsDTO updateFlight);
    String deleteFlight(Long flightId);

    FlightsDTO getFlightID(String departure, String arrival);
}
