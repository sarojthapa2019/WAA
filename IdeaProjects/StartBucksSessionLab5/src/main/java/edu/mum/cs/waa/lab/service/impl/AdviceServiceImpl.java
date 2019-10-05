package edu.mum.cs.waa.lab.service.impl;

import edu.mum.cs.waa.lab.domain.Advice;
import edu.mum.cs.waa.lab.repository.AdviceRepo;
import edu.mum.cs.waa.lab.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AdviceServiceImpl implements AdviceService {

    AdviceRepo adviceRepo;
    @Autowired
    public AdviceServiceImpl(AdviceRepo adviceRepo){
        this.adviceRepo = adviceRepo;
    }
    @Override
    public List<Advice> getAdviceByType(String type){
        return adviceRepo.getAdviceByType(type);
    }

    @Override
    public Set<String> getAllAdviceKey() {
        return adviceRepo.getAllAdviceKey();
    }

}
