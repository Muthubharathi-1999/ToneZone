package com.example.demo.Controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {
    @GetMapping("/error")
    public String
    handleError(HttpServletRequest request) {
        String errorText = "Not Found";

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                errorText = "404 NOT FOUND";

            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {

                errorText = "403 FORBIDDEN";

            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorText = "500 INTERNAL SERVER ERROR";

            }
            else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                errorText = "400 BAD REQUEST";

            }
        }

        return errorText;
    }



    @PostMapping("/error")
    public String
    handleErrorPost(HttpServletRequest request) {
        String errorText = "Not Found";

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                errorText = "404 NOT FOUND";

            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {

                errorText = "403 FORBIDDEN";

            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorText = "500 INTERNAL SERVER ERROR";

            }
            else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                errorText = "400 BAD REQUEST";

            }
        }

        return errorText;
    }



}
