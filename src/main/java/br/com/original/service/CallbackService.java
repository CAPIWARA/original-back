package br.com.original.service;

import br.com.original.entity.Callback;
import br.com.original.repository.CallbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@Service
public class CallbackService {

    @Autowired
    CallbackRepository callbackRepository;

    @Autowired
    OriginalService originalService;

    public Callback saveCallback(Callback callback) {
        callbackRepository.save(callback);
        return callback;
    }

    public String getBalance(Integer id) throws IOException {
        Callback callback = callbackRepository.findOne(id);
        System.out.println(originalService
                .methodGetOriginal("/accounts/v1/balance", callback.getBearer()));
        return "alo";
    }
}
