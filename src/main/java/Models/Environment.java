package Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.ArrayList;
import java.util.List;

public class Environment {

    public EnvironmentSpecs uat;
    public EnvironmentSpecs test;

    @JsonAnyGetter
    public EnvironmentSpecs getUat() {
        return uat;
    }

    @JsonAnyGetter
    public EnvironmentSpecs getTest() {
        return test;
    }

    @JsonAnyGetter
    public List<EnvironmentSpecs> getListOfEnvironments() {
        List<EnvironmentSpecs> listOfEnvironments = new ArrayList<>();
        listOfEnvironments.add(getUat());
        listOfEnvironments.add(getTest());
        return listOfEnvironments;
    }
}
