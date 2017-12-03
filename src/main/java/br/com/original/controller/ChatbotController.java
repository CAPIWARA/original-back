package br.com.original.controller;

import br.com.original.service.ChatbotService;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by @cardosomarcos on 03/12/17
 */

@RestController
public class ChatbotController {
    @Autowired
    ChatbotService chatbotService;


    @RequestMapping(value = "/quantCube/{id}")
    public String quantidadeCubinhos(@PathVariable("id") String id) throws IOException {
        return chatbotService.getCubinhos(id);
    }

    @RequestMapping(value = "/textToSpeech/{text}")
    public String textToSpeech(@PathVariable("text") String text) throws IOException {
        return chatbotService.getUrlaudio(text);
    }

    @RequestMapping(value="/chatbot/{text}")
    public String chatbox(@PathVariable("text")String text) throws IOException {
        return chatbotService.getChat(text);
    }
}
