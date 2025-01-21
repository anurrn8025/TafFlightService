package com.aero.TafFlightService.Services;

import com.aero.TafFlightService.Models.FlightsDTO;
import com.aero.TafFlightService.Services.Interfaces.FlightService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${datastore.ms.url}")
    private String dataStoreUrl;

    private static final Logger logger = LogManager.getLogger(FlightServiceImpl.class);

    @Override
    public FlightsDTO AddFlight(FlightsDTO newFlight) {
        return restTemplate.postForObject(dataStoreUrl, newFlight, FlightsDTO.class);
    }

    @Override
    public List<FlightsDTO> getAllFlights() {
        return restTemplate.exchange( dataStoreUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FlightsDTO>>() {}).getBody();
    }

    @Override
    public FlightsDTO getSingleFlight(Long flightId) {
        System.out.println("received id = "+ flightId);
        return restTemplate.getForObject(dataStoreUrl+ "/" +flightId, FlightsDTO.class);
    }

    @Override
    public String updateFlight(Long flightId,FlightsDTO updateFlight) {
        restTemplate.put(dataStoreUrl+ "/" +flightId,updateFlight, FlightsDTO.class);
        String resp = "Flight updated successfully!";
        return resp;
    }

    @Override
    public String deleteFlight(Long flightId) {
        restTemplate.delete(dataStoreUrl+ "/" +flightId);
        String resp = "Flight deleted successfully!";
        return resp;
    }
}
