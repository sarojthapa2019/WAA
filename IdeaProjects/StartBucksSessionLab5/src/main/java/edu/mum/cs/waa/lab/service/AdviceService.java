package edu.mum.cs.waa.lab.service;

import edu.mum.cs.waa.lab.domain.Advice;

import java.util.List;
import java.util.Set;

public interface AdviceService {
     List<Advice> getAdviceByType(String type);
     Set<String> getAllAdviceKey();
}
