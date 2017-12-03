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

    public Object getBalance(Integer id) throws IOException {
        Callback callback = callbackRepository.findOne(id);
        return originalService
                .methodGetOriginal("/accounts/v1/balance", callback.getBearer());
    }

    public Object getHistory(Integer id) throws IOException {
        Callback callback = callbackRepository.findOne(id);
        return originalService.methodGetOriginal("/accounts/v1/transaction-history", callback.getBearer());
    }
}
