package br.com.original.service;

import br.com.original.entity.Balance;
import br.com.original.entity.Child;
import br.com.original.repository.ChildRepository;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by @cardosomarcos on 03/12/17
 */
@Service
public class ChildService {
    @Autowired
    ChildRepository childRepository;

    @Autowired
    OriginalService originalService;

    public List<Child> getChilds(Integer id) {
        return childRepository.findByIdpai(id);
    }

    public Child findById(Integer id) throws IOException {
        Child child = childRepository.findOne(id);
        LinkedTreeMap<String, Double> valor  = (LinkedTreeMap<String, Double>) originalService.methodGetOriginal("/accounts/v1/balance", child.getBearer());
        child.setBalance(Double.parseDouble(String.valueOf(valor.get("current_balance"))));
        return child;
    }
}
