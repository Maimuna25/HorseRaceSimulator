package Part2.Model;

import Part2.data.Constants;

public class Horse {
    private String horseName;
    private String breed;
    private String coatColour;
    private String equipment;
    private String accessory;

    public Horse(String horseName, String breed, String coatColour, String equipment, String accessory) {
        this.horseName = horseName;
        this.breed = breed;
        this.coatColour = coatColour;
        this.equipment = equipment;
        this.accessory = accessory;
    }

    public Horse(String horseName, String breed, String coatColour) {
        this(horseName, breed, coatColour, Constants.EQUIPMENT_OPTIONS[0], Constants.ACCESSORIES_OPTIONS[0]);
    }

    public String getHorseName() {
        return horseName;
    }

    public String getBreed() {
        return breed;
    }

    public String getCoatColour() {
        return coatColour;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    @Override
    public String toString() {
        return STR."Horse - \{horseName}. Breed: \{breed}, Coat Colour: \{coatColour}, Equipment: \{equipment}, Accessories: \{accessory}";
    }
}
