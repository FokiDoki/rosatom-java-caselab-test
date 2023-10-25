package org.caselab;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CarServlet extends HttpServlet {
    CarRepository carRepository = new CarRepository();

    ObjectMapper objectMapper = new ObjectMapper();



    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        setJsonOkStatus(response);
        if (request.getPathInfo() == null) {
            getAllCars(response);
        } else {
            getCar(response, request);
        }
    }

    private void getAllCars(HttpServletResponse response) throws IOException {
        String jsonData = objectMapper.writeValueAsString(carRepository.getCars());
        response.getWriter().print(jsonData);
    }

    private void getCar(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String[] splits = request.getPathInfo().split("/");
        int index = Integer.parseInt(splits[1]);
        String jsonData = objectMapper.writeValueAsString(carRepository.getCar(index));
        response.getWriter().print(jsonData);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {



        Car car = objectMapper.readValue(request.getInputStream(), Car.class);
        response.setStatus(HttpServletResponse.SC_CREATED);
        carRepository.addCar(car);
    }

    @Override
    protected void doDelete(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        String[] splits = request.getPathInfo().split("/");
        int index = Integer.parseInt(splits[1]);
        carRepository.deleteCar(index);
    }

    @Override
    protected void doPut(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        String[] splits = request.getPathInfo().split("/");
        int index = Integer.parseInt(splits[1]);
        Car car = objectMapper.readValue(request.getInputStream(), Car.class);
        carRepository.updateCar(index, car);
    }



    private void setJsonOkStatus(HttpServletResponse response) {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
