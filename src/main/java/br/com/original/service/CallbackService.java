package br.com.original.service;

import br.com.original.entity.Callback;
import br.com.original.repository.CallbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@Service
public class CallbackService {

    @Autowired
    CallbackRepository callbackRepository;

    public Callback saveCallback(Callback callback) {
        callbackRepository.save(callback);
        return callback;
    }
}
