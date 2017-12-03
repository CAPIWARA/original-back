package br.com.original.service;

import br.com.original.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by @cardosomarcos on 02/12/17
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
}
