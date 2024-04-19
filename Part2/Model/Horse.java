package Part2.Model;

import Part2.data.Constants;

public class Horse {
    private String horseName;
    private String coatColour;
    private String hairColour;
    private String saddleColour;
    private String bridleColour;

    public Horse(String horseName, String coatColour, String hairColour, String saddleColour, String bridleColour) {
        this.horseName = horseName;
        this.coatColour = coatColour;
        this.hairColour = hairColour;
        this.saddleColour = saddleColour;
        this.bridleColour = bridleColour;
    }

    public Horse(String horseName, String coatColour, String hairColour) {
        this(horseName, coatColour, hairColour, Constants.SADDLE_COLOUR[0], Constants.BRIDLE_COLOUR[0]);
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getCoatColour() {
        return coatColour;
    }

    public void setCoatColour(String coatColour) {
        this.coatColour = coatColour;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public String getSaddleColour() {
        return saddleColour;
    }

    public void setSaddleColour(String saddleColour) {
        this.saddleColour = saddleColour;
    }

    public String getBridleColour() {
        return bridleColour;
    }

    public void setBridleColour(String bridleColour) {
        this.bridleColour = bridleColour;
    }

    @Override
    public String toString() {
        return STR."Horse - \{horseName}, Coat Colour: \{coatColour}, Hair Colour: \{hairColour}, Saddle Colour: \{saddleColour}, Bridle Colour: \{bridleColour}";
    }
}
