package Part2.Model;

import Part2.data.Constants;

public class Horse {
    private String horseName;
    private String coatColour;
    private String hairColour;
    private String saddleColour;
    private String bridleColour;
    private double horseConfidence;

    public Horse(String horseName, String coatColour, String hairColour, String saddleColour, String bridleColour, double horseConfidence) {
        this.horseName = horseName;
        this.coatColour = coatColour;
        this.hairColour = hairColour;
        this.saddleColour = saddleColour;
        this.bridleColour = bridleColour;
        this.horseConfidence = horseConfidence;
    }

    public Horse(String horseName, String coatColour, String hairColour, String saddleColour, String bridleColour) {
        this(horseName, coatColour, hairColour, saddleColour, bridleColour, Math.random() / 2 + 0.5);
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

    public double getHorseConfidence() {
        return horseConfidence;
    }

    public String getImagePath() {
        StringBuilder sb = new StringBuilder();
        sb.append("Part2/assets/");

        // .replaceAll() removes all whitespaces using Regular Expressions (regex)
        sb.append("horse").append(coatColour.toLowerCase().replaceAll("\\s", "")).append("-");

        // "None" for saddle and bridle colours needs to be changed to "no" for image file name.
        // Uses a ternary statement to quickly do a selection out of two options.
        sb.append(saddleColour.equals("None") ? "no" : saddleColour.toLowerCase()).append("saddle").append("-");
        sb.append(bridleColour.equals("None") ? "no" : bridleColour.toLowerCase()).append("bridle").append("-");

        // Added .png at the end since it is a PNG file.
        sb.append(hairColour.toLowerCase()).append("hair.png");

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Horse - " + horseName + ", Coat Colour: " + coatColour + ", Hair Colour: " + hairColour +
                ", Saddle Colour: " + saddleColour + ", Bridle Colour: " + bridleColour;
    }

}
