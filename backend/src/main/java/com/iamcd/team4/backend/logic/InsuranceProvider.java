package com.iamcd.team4.backend.logic;

import com.iamcd.team4.backend.logic.model.insurance.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InsuranceProvider {


    private List<String> extremeHobbies = new ArrayList<>(){{
       add("climbing");
       add("skiing");
       add("snowboarding");
    }};

    private List<String> equipmentHobbies = new ArrayList<>(){{
        add("skiing");
        add("snowboarding");
        add("cycling");
        add("kart racing");
        add("longboarding");
        add("archery");
    }};


    private List<String> lifeInsurance = new ArrayList<>(){{
        add("skiing");
        add("snowboarding");
        add("cycling");
        add("kart racing");
        add("longboarding");
        add("figure skating");
    }};

    private List<String> bikeInsuranceHobbies = new ArrayList<>(){{
            add("cycling");
        }};

    private List<String> thirdPartyLiablitiyHobbies = new ArrayList<>(){{
        add("cycling");
        add("darts");
        add("bobsleigh");
        add("archery");
        add("Skiing");
        add("Snowboarding");
    }};

    private List<String> petOwnersHobbies = new ArrayList<>(){{
        add("beekeeping");
    }};


    public List<Insurance> getOffers(List<String> hobbies) {
        List<Insurance> offers = new ArrayList<>();
        if (hasExtremeHobby(hobbies)) {
            offers.add(new ExtremeSportInsurance(79));
        }
        if (needsLifeInsurance(hobbies)) {
            offers.add(new LifeInsurance(99));
        }
        if (needsEquipmentInsurance(hobbies)) {
            offers.add(new EquipmentInsurance(5));
        }
        if (needsBikeInsurance(hobbies)) {
            offers.add(new BikeInsurance(3));
        }
        if (needsThirdPartyLiabilityInsurance(hobbies)) {
            offers.add(new ThirdPartyLiabilityInsurance(42));
        }
        if (needsPetOwnerThirdPartyLiabilityInsurance(hobbies)) {
            offers.add(new PetOwnerThirdPartyLiability(52));
        }
        return offers;
    }

    private List<String> getNewHobbies(List<String> oldHobbies, List<String> newHobbies) {
        return newHobbies.stream().filter(oldHobbies::contains).collect(Collectors.toList());
    }


    private boolean hasExtremeHobby(List<String> hobbies) {
        return hobbies.stream().anyMatch(hobby -> this.extremeHobbies.contains(hobby));
    }

    private boolean needsLifeInsurance(List<String> hobbies) {
        return hobbies.stream().anyMatch(hobby -> this.lifeInsurance.contains(hobby));
    }

    private boolean needsEquipmentInsurance(List<String> hobbies) {
        return hobbies.stream().anyMatch(hobby -> this.equipmentHobbies.contains(hobby));
    }

    private boolean needsBikeInsurance(List<String> hobbies) {
        return hobbies.stream().anyMatch(hobby -> this.bikeInsuranceHobbies.contains(hobby));
    }

    private boolean needsThirdPartyLiabilityInsurance(List<String> hobbies) {
        return hobbies.stream().anyMatch(hobby -> this.thirdPartyLiablitiyHobbies.contains(hobby));
    }

    private boolean needsPetOwnerThirdPartyLiabilityInsurance(List<String> hobbies) {
        return hobbies.stream().anyMatch(hobby -> this.thirdPartyLiablitiyHobbies.contains(hobby));
    }

}
