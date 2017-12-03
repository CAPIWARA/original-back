package br.com.original.controller;

import br.com.original.config.Constants;
import br.com.original.config.OriginalAuth;
import br.com.original.entity.Callback;
import br.com.original.service.CallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@RestController
public class ApiController {

    @Autowired
    private OriginalAuth originalAuth;

    @Autowired
    CallbackService callbackService;

    @RequestMapping(value = "/myapp")
    public Callback home(HttpServletRequest request) throws Exception {
        String url = request.getRequestURL().toString() + "?" + request.getQueryString();
        //String url = "http://localhost:8080/myapp?callback_id=1&auth_code=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0eXBlIjoiT0F1dGhBdXRoQ29kZSIsImlhdCI6MTUxMjI0MTA5MiwiZXhwIjoxNTEyMjQxNjkyLCJhdWQiOiI3MTIyNzMwYyIsImlzcyI6Ilp1cC5tZSBHYXRld2F5Iiwic3ViIjoiYmVmNDdiYTAtZDc5Mi0xMWU3LWE3YzAtMDA1MDU2OWE3MzA1IiwianRpIjoiYmYxNGZiZjAtZDc5Mi0xMWU3LWJjNTEtNzE0ZDBjZjQyMDFjIn0.NHemrJcWK2PT01hPVW0yUd6CJ5i0ls0IWc67WbjfRvU&uid=bef47ba0-d792-11e7-a7c0-0050569a7305";
        System.out.println(url);
        String[] regex = url.replaceAll("http://localhost:8080/myapp\\?", "").split("&");
        Callback callback = new Callback(regex[0], regex[1], regex[2]);
        String token = originalAuth.getToken(callback.getEuid()
                , callback.getAuth_code());
        System.out.println("SEU TOKEN EH: " + token);
        callback.setBearer(token);
        return callbackService.saveCallback(callback);
    }

}
