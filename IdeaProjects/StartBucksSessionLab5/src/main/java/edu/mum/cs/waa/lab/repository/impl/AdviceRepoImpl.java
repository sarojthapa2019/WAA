package edu.mum.cs.waa.lab.repository.impl;

import edu.mum.cs.waa.lab.domain.Advice;
import edu.mum.cs.waa.lab.repository.AdviceRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Repository
public class AdviceRepoImpl implements AdviceRepo {

    private static HashMap<String, List<String>> advice = new HashMap();
    static {
        ArrayList<String> darkList = new ArrayList();
        darkList.add("Sumatra");
        darkList.add("Verona");
        darkList.add("French Roast");
        advice.put("dark", darkList);
        ArrayList<String> medList = new ArrayList();
        medList.add("Breakfast Blend");
        medList.add("Colombia");
        medList.add("Yukon");
        medList.add("Pike Place");
        medList.add("House Blend");
        advice.put("medium", medList);
        ArrayList<String> lightList = new ArrayList();
        lightList.add("Willow");
        lightList.add("Aria");
        lightList.add("Bright Sky");
        lightList.add("Veranda");
        advice.put("light", lightList);
    }
    @Override
    public List<Advice> getAdviceByType(String type) {
        return (List)advice.get(type);
    }

    @Override
    public Set<String> getAllAdviceKey() {
        return advice.keySet();
    }
}
